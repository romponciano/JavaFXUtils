package rponciano.DCRG;

import javafx.scene.control.RadioButton;

public class DynamicRadioItem extends RadioButton {
	
	private Object item;
	
	public DynamicRadioItem(Object obj) {	
		super(obj.toString());
		item = obj;
	}

	public Object getItem() {
		return item;
	}
}
