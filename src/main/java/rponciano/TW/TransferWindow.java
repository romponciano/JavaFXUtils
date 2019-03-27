package rponciano.TW;

import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Class created to implement a transfer window between two lists. This class
 * has a list (right side) with all the possibilities and a list (left side)
 * where the options desired by the user are sent through the buttons.<br>
 * <b>IMPORTANT:</b> For the class to work best, the R type defined at user
 * creation must be of type String or have the toString () method overrided to
 * display the desired attribute as the label of the list items. For more
 * examples, check the ModelExample.java class
 * 
 * @author romuloponciano
 *
 * @param <R>
 */
public class TransferWindow<R> extends Stage {

	private EventHandler<ActionEvent> openWindowEventHandler;

	private MigPane mainPane;
	private String titleSelected;
	private String titleAll;

	private MultSortedListView<R> lstAllPoss;
	private MultSortedListView<R> lstSelected;
	private ObservableList<R> savedAllPos;
	private ObservableList<R> savedSelected;

	private Button btnRight;
	private Button btnRightAll;
	private Button btnLeft;
	private Button btnLeftAll;
	private Button btnConfirm;
	private Button btnCancel;

	/**
	 * Basic constructor of the class.
	 * 
	 * @param titleSelected - represents the title of the list on the left. That is,
	 *                      the list with elements selected by the user.
	 * @param titleAll      - represents the title of the list on the right. That
	 *                      is, the list with all the possibilities elements.
	 */
	public TransferWindow(String titleSelected, String titleAll) {
		mainPane = new MigPane("", "[grow][][grow]", "");
		this.titleSelected = titleSelected;
		this.titleAll = titleAll;

		initFields();
		initListeners();
		createLayout();
		configStage();
	}

	/**
	 * Constructor of the class with all the possibilities.
	 * 
	 * @param titleSelected    - represents the title of the list on the left. That
	 *                         is, the list with elements selected by the user.
	 * @param titleAll         - represents the title of the list on the right. That
	 *                         is, the list with all the possibilities elements.
	 * @param allPossibilities - the list with all the possibilities to be
	 *                         transfered.
	 */
	public TransferWindow(String titleSelected, String titleAll, List<R> allPossibilities) {
		mainPane = new MigPane("", "[grow][][grow]", "");
		this.titleSelected = titleSelected;
		this.titleAll = titleAll;

		initFields();
		initListeners();
		createLayout();
		configStage();

		setAllPossibilities(allPossibilities);
	}

	/**
	 * Method to init the listeners of each button
	 */
	private void initListeners() {
		btnConfirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				savedAllPos = lstAllPoss.getItemsAsNewObservableList();
				savedSelected = lstSelected.getItemsAsNewObservableList();
				close();
			}
		});
		btnCancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadSaved();
				close();
			}
		});
		btnRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<R> aux = lstSelected.getSelectionModel().getSelectedItems();
				lstAllPoss.addAll(aux);
				lstSelected.removeAll(aux);
			}
		});
		btnRightAll.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lstAllPoss.addAll(lstSelected.getItems());
				lstSelected.clear();
			}
		});
		btnLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ObservableList<R> aux = lstAllPoss.getSelectionModel().getSelectedItems();
				lstSelected.addAll(aux);
				lstAllPoss.removeAll(aux);
			}
		});
		btnLeftAll.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lstSelected.addAll(lstAllPoss.getItems());
				lstAllPoss.clear();
			}
		});
	}

	/**
	 * Method to load the saved lists. Because the user can transfer the items, but
	 * hit cancel button. So, it must load the previous confirmed selections.
	 */
	protected void loadSaved() {
		if (savedAllPos != null) {
			lstAllPoss.setItems(FXCollections.observableArrayList(savedAllPos));
		}
		if (savedSelected != null) {
			lstSelected.setItems(FXCollections.observableArrayList(savedSelected));
		}
	}

	/**
	 * Method to set basic states of the stage window.
	 */
	private void configStage() {
		this.initStyle(StageStyle.UNDECORATED);
		this.setScene(new Scene(mainPane));
	}

	/**
	 * Methodo to init the fields/attributes
	 */
	private void initFields() {
		lstAllPoss = new MultSortedListView<R>();
		lstSelected = new MultSortedListView<R>();
		btnRight = new Button(">");
		btnRightAll = new Button(">>");
		btnLeft = new Button("<");
		btnLeftAll = new Button("<<");
		btnConfirm = new Button("Confirmar");
		btnCancel = new Button("Cancelar");
		openWindowEventHandler = createOpenWindowEvent();
	}

	/**
	 * Method to create the event that open this class as a new window.
	 * 
	 * @return - the event that open and wait user interaction with this window.
	 */
	private EventHandler<ActionEvent> createOpenWindowEvent() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				showAndWait();
			}
		};
	}

	/**
	 * Method to create the layout used inside this window
	 */
	private void createLayout() {
		mainPane.add(new Label(titleSelected));
		mainPane.add(new Label(titleAll), "skip 1, wrap");
		mainPane.add(lstSelected, "grow");
		mainPane.add(createTransferControl(), "growy");
		mainPane.add(lstAllPoss, "grow, wrap");
		mainPane.add(new Separator(), "growx, span 3, wrap");
		mainPane.add(createButtonControl(), "growx, span 3");
	}

	/**
	 * Method to create the layout of the control buttons (footer)
	 * 
	 * @return layout of the control buttons align horizontally
	 */
	private MigPane createButtonControl() {
		MigPane buttonsControl = new MigPane("", "[]push[][]", "[]");
		buttonsControl.add(btnCancel, "skip 1");
		buttonsControl.add(btnConfirm);
		return buttonsControl;
	}

	/**
	 * Method to create the layout of the "arrow" buttons
	 * 
	 * @return layout of the buttons align vertically
	 */
	private MigPane createTransferControl() {
		MigPane control = new MigPane("", "", "");
		control.add(btnRight, "wrap, growx");
		control.add(btnRightAll, "wrap, growx");
		control.add(btnLeft, "wrap, growx");
		control.add(btnLeftAll, "growx");
		return control;
	}

	/**
	 * Method to set all the possibilities which the user can select to transfer. If
	 * you do not set the possibilities, the window will not have any item inside
	 * the right list.
	 * 
	 * @param allPossibilities
	 */
	public void setAllPossibilities(List<R> allPossibilities) {
		lstAllPoss.addAll(FXCollections.observableArrayList(allPossibilities));
		savedAllPos = FXCollections.observableArrayList(allPossibilities);
	}

	/**
	 * Method to get the selected items. That is, the items on the left list.
	 * 
	 * @return selected and confirmed items inside the left list
	 */
	public ObservableList<R> getSavedSelected() {
		return savedSelected;
	}

	/**
	 * Method to get the event responsible for open this window and wait user
	 * interaction (confirm or cancel)
	 * 
	 * @return the event responsible for open this window and wait user interaction
	 *         (confirm or cancel)
	 */
	public EventHandler<ActionEvent> getOpenWindowEventHandler() {
		return openWindowEventHandler;
	}
}