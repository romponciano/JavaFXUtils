package rponciano.PBWS;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Class created for progress bar creation when using methods that may take time
 * to load/terminate.
 * 
 * @author romuloponciano
 *
 * @param <R> - Return class of the time-consuming method.
 */
public abstract class ProgressBarWithService<R> extends ProgressBar {

	private Service<R> service;
	private Stage stage;

	public ProgressBarWithService() {
		super();
		stage = new Stage();
		configStage();
		service = createService();
		createOnScheduled();
		createOnSuccedded();
		this.progressProperty().bind(getService().progressProperty());
	}

	/**
	 * Method to be executed upon completion of the task.
	 * 
	 * @param result - Result of the method called in methodToBeLoad()
	 */
	public abstract void actionAfterSuccess(R result);

	/**
	 * Method that will be executed and that has the delay.
	 * 
	 * @return - R class object defined when constructing PBWS
	 * @throws Exception
	 */
	public abstract R methodToBeLoad() throws Exception;

	/**
	 * Method used to start the task.
	 */
	public void startService() {
		getService().restart();
	}

	/**
	 * Method to get the result of the task.
	 * 
	 * @return - returns the result of the task in class corrupts when constructing
	 *         PBWS
	 */
	public R getResult() {
		return getService().getValue();
	}

	/**
	 * Method for picking up the created service.
	 * 
	 * @return - returns the created service.
	 */
	public Service<R> getService() {
		return service;
	}

	private void configStage() {
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setAlwaysOnTop(true);
	}

	private Service<R> createService() {
		return new Service<R>() {
			@Override
			protected Task<R> createTask() {
				return new Task<R>() {
					@Override
					protected R call() throws Exception {
						return methodToBeLoad();
					}
				};
			}
		};
	}

	private void createOnScheduled() {
		getService().setOnScheduled(e -> {
			stage.setScene(new Scene(this));
			stage.show();
		});
	}

	private void createOnSuccedded() {
		getService().setOnSucceeded(e -> {
			stage.close();
			actionAfterSuccess(getResult());
		});
	}
}
