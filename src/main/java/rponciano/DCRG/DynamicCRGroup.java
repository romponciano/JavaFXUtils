package rponciano.DCRG;

import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.scene.control.ButtonBase;
import javafx.scene.control.ToggleGroup;

/**
 * Class to generate list of checkboxes or radios, dynamically. 
 * The class generates the group from an Object list.
 * <b>VERY IMPORTANT: To work, the toString() method must 
 * be @Override to return the String that wants to be 
 * displayed next to the CheckBox/RadioButton.</b>
 * See ModelExample.java
 * 
 * @author romuloponciano
 *
 */
public class DynamicCRGroup extends MigPane {

	/**
	 * Type to set whether the class will be from 
	 * CheckBox or RadioButton
	 */
	public enum TYPE_GROUP {
		CHECKBOX, RADIO
	}

	private List<? extends ButtonBase> itemList;
	private TYPE_GROUP type;
	private ToggleGroup toggleRadioGroup;

	/**
	 * Constructor. This constructor already creates 
	 * the group of panel.<br>
	 * <b>VERY IMPORTANT: To work, the toString() method of Object Class
	 * must be @Override to return the String that wants to be 
 	 * displayed next to the CheckBox/RadioButton.</b>
 	 * <br>
	 * @param tp - Type to set whether the class 
	 * will be from CheckBox or RadioButton.
	 * @param objs - Each item on the list will 
	 * be a CheckBox or RadioButton.
	 */
	public DynamicCRGroup(TYPE_GROUP tp, List<? extends Object> objs) {
		super("", "[grow]", "");
		type = tp;
		itemList = createItemList(objs);
		createListPanel();
	}

	/**
	 * Method used to tell if a CheckBox/RadioButton is checked.
	 * @param position - position of the element. Start at 0.
	 * @return True if the component is checked; False otherwise;
	 * null if something is wrong. 
	 */
	public Boolean isSelectedAtPosition(int position) {
		if(type.equals(TYPE_GROUP.CHECKBOX)) {
			return ((DynamicCheckBoxItem)itemList.get(position)).isSelected();
		} else if(type.equals(TYPE_GROUP.RADIO)) {
			return ((DynamicRadioItem)itemList.get(position)).isSelected();
		}
		return null;
	}
	
	/**
	 * Method used to get the text of the component at position.
	 * @param position - position of the element. Start at 0.
	 * @return String of the component in position.
	 */
	public String getTextAtPosition(int position) {
		if(type.equals(TYPE_GROUP.CHECKBOX)) {
			return ((DynamicCheckBoxItem)itemList.get(position)).getText();
		} else if(type.equals(TYPE_GROUP.RADIO)) {
			return ((DynamicRadioItem)itemList.get(position)).getText();
		}
		return null;
	}
	
	/**
	 * Method to get the object at position.
	 * @param position - position of the element. Start at 0.
	 * @return Object at position.
	 */
	public Object getObjectAtPosition(int position) {
		if(type.equals(TYPE_GROUP.CHECKBOX)) {
			return ((DynamicCheckBoxItem)itemList.get(position)).getItem();
		} else if(type.equals(TYPE_GROUP.RADIO)) {
			return ((DynamicRadioItem)itemList.get(position)).getItem();
		}
		return null;
	}
	
	/**
	 * Method used to pick radio group that make 
	 * only 1 radio marked at a time. It contains
	 * all radio buttons of the group.
	 * @return radio group that make only 1 radio 
	 * marked at a time.
	 */
	public ToggleGroup getToggleRadioGroup() {
		return toggleRadioGroup;
	}
	
	private void createListPanel() {
		if (type.equals(TYPE_GROUP.CHECKBOX)) {
			for (ButtonBase opt : itemList) {
				this.add((DynamicCheckBoxItem) opt, "growx, wrap");
			}
		} else if (type.equals(TYPE_GROUP.RADIO)) {
			for (ButtonBase opt : itemList) {
				this.add((DynamicRadioItem) opt, "growx, wrap");
			}
			createToggleRadioGroup();
		}
	}

	private void createToggleRadioGroup() {
		toggleRadioGroup = new ToggleGroup();
		for(ButtonBase rad : itemList) {
			((DynamicRadioItem)rad).setToggleGroup(toggleRadioGroup);
		}
	}

	private List<? extends ButtonBase> createItemList(List<? extends Object> objs) {
		if (type.equals(TYPE_GROUP.CHECKBOX)) {
			return createCheckBoxItemList(objs);
		} else if (type.equals(TYPE_GROUP.RADIO)) {
			return createRadioButtonItemList(objs);
		}
		return null;
	}

	private List<? extends ButtonBase> createRadioButtonItemList(List<? extends Object> objs) {
		List<DynamicRadioItem> out = new ArrayList<DynamicRadioItem>();
		for (Object element : objs) {
			out.add(new DynamicRadioItem((ModelExample)element));
		}
		return out;
	}

	private List<? extends ButtonBase> createCheckBoxItemList(List<? extends Object> objs) {
		List<DynamicCheckBoxItem> out = new ArrayList<DynamicCheckBoxItem>();
		for (Object element : objs) {
			out.add(new DynamicCheckBoxItem(element));
		}
		return out;
	}
}
