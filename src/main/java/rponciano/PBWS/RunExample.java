package rponciano.PBWS;

import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RunExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MigPane pane = new MigPane("", "", "");
		
		ProgressBarWithService<List<ModelExample>> bar = new ProgressBarWithService<List<ModelExample>>() {
			@Override
			public List<ModelExample> methodToBeLoad() throws Exception {
				return delayMethod();
			}
			@Override
			public void actionAfterSuccess(List<ModelExample> result) {
				for(ModelExample res : result) {
					pane.add(new Label(res.getName()));
				}
			}
		};
		
		bar.startService();
		
		primaryStage.setScene(new Scene(pane, 300, 50));
		primaryStage.show();
	}
	
	private List<ModelExample> delayMethod() {
		List<ModelExample> examples = new ArrayList<ModelExample>();
		try {
			Thread.sleep(10000);
			examples.add(new ModelExample(1L, "ex1"));
			examples.add(new ModelExample(2L, "ex2"));
			examples.add(new ModelExample(3L, "ex3"));
			examples.add(new ModelExample(4L, "ex4"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return examples;
	}
	
	public static void main(String[] args) {
		launch();
	}

}
