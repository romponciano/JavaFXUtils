package rponciano.LWC;

import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Class created to manage a layout containing a list, a field for the user to
 * add data (combobox or textfield) and two buttons to control: add or remove
 * item from the list.
 * 
 * @author romuloponciano
 *
 */
public class ListWithControl extends MigPane {

	/**
	 * Type the list that will be created. COMBO_CHOICE to List with ComboBox
	 * TEXT_ENTRY to List with TextField
	 */
	public enum LIST_TYPE {
	TEXT_ENTRY, COMBO_CHOICE
	}

	private ListView<Object> list;
	private TextField text;
	private ComboBox<Object> combo;
	private Button add;
	private Button remove;
	private LIST_TYPE type;

	/**
	 * Constructor for add and remove buttons with default values, + and -,
	 * respectively.
	 * 
	 * @param type - type that determines whether the data will be entered by typing
	 *             (TEXT_ENTRY) or selected item (COMBO_CHOICE)
	 */
	public ListWithControl(LIST_TYPE type) {
		super("", "[grow][][]", "[grow]0[]");
		init(type, null);
	}

	/**
	 * Constructor for add and remove buttons with default values, + and -,
	 * respectively. And populate combobox
	 * 
	 * @param type      - type that determines whether the data will be entered by
	 *                  typing (TEXT_ENTRY) or selected item (COMBO_CHOICE)
	 * @param comboObjs - List with comboBox values
	 */
	public ListWithControl(LIST_TYPE type, List<? extends Object> comboObjs) {
		super("", "[grow][][]", "[grow]0[]");
		init(type, comboObjs);
	}

	/**
	 * Constructor to set name of add and remove buttons.
	 * 
	 * @param type             - type that determines whether the data will be
	 *                         entered by typing (TEXT_ENTRY) or selected item
	 *                         (COMBO_CHOICE)
	 * @param addButtonName    - name of the button used to add item
	 * @param removeButtonName - name of the button used to remove item
	 */
	public ListWithControl(LIST_TYPE type, String addButtonName, String removeButtonName) {
		super("", "[grow][][]", "[grow]0[]");
		init(type, null);
		add.setText(addButtonName);
		remove.setText(removeButtonName);
	}

	/**
	 * Constructor to set name of add and remove buttons. And populate comboBox
	 * 
	 * @param type             - type that determines whether the data will be
	 *                         entered by typing (TEXT_ENTRY) or selected item
	 *                         (COMBO_CHOICE)
	 * @param addButtonName    - name of the button used to add item
	 * @param removeButtonName - name of the button used to remove item
	 * @param comboObjs        - List with comboBox values
	 */
	public ListWithControl(LIST_TYPE type, String addButtonName, String removeButtonName,
			List<? extends Object> comboObjs) {
		super("", "[grow][][]", "[grow]0[]");
		init(type, comboObjs);
		add.setText(addButtonName);
		remove.setText(removeButtonName);
	}

	/**
	 * Method to initialize default values independent of the constructor used
	 */
	private void init(LIST_TYPE tp, List<? extends Object> comboObjs) {
		list = new ListView<>();
		text = new TextField();
		combo = new ComboBox<>();
		type = tp;
		add = new Button("+");
		remove = new Button("-");
		remove.setDisable(true);
		add(list, "span 3, grow, wrap");
		if (type.equals(LIST_TYPE.TEXT_ENTRY)) {
			this.add(text, "growx");
		} else if (type.equals(LIST_TYPE.COMBO_CHOICE)) {
			combo.getItems().addAll(comboObjs);
			this.add(combo, "growx");
		}
		this.add(add);
		this.add(remove);
		initListeners();
	}

	/**
	 * Method to initialize component listeners
	 */
	private void initListeners() {
		remove.setOnAction(createBtnRemoveClickEvent());
		initListOnItemSelectListener();
		if (type.equals(LIST_TYPE.TEXT_ENTRY)) {
			add.setOnAction(createBtnAddTextClickEvent());
		} else if (type.equals(LIST_TYPE.COMBO_CHOICE)) {
			add.setOnAction(createBtnAddComboClickEvent());
		}
	}

	/**
	 * Method to enable remove button when item is selected in list
	 */
	private void initListOnItemSelectListener() {
		list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
			if (newSelection == null) {
				remove.setDisable(true);
			} else {
				remove.setDisable(false);
			}
		});
	}

	/**
	 * Function to remove item click action
	 */
	private EventHandler<ActionEvent> createBtnRemoveClickEvent() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				list.getItems().remove(list.getSelectionModel().getSelectedItem());
				remove.setDisable(true);
			}
		};
	}

	/**
	 * Function to add item click via TEXT_ENTRY
	 */
	private EventHandler<ActionEvent> createBtnAddTextClickEvent() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String txt = text.getText();
				if (!list.getItems().contains(txt) && !txt.equals("")) { // negate duplicate and empty text
					list.getItems().add(txt);
				}
				remove.setDisable(true);
			}
		};
	}

	/**
	 * Function to add item click via COMBO_CHOICE
	 */
	private EventHandler<ActionEvent> createBtnAddComboClickEvent() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Object obj = combo.getSelectionModel().getSelectedItem();
				if (!list.getItems().contains(obj)) { // negate duplicate
					list.getItems().add(obj);
				}
				remove.setDisable(true);
			}
		};
	}

	public ListView<Object> getList() {
		return list;
	}

	public TextField getText() {
		return text;
	}

	public ComboBox<Object> getCombo() {
		return combo;
	}

	public Button getAdd() {
		return add;
	}

	public Button getRemove() {
		return remove;
	}
}