package rponciano.DCRG;

import javafx.scene.control.CheckBox;

public class DynamicCheckBoxItem extends CheckBox {
	
	private Object item;
	
	public DynamicCheckBoxItem(Object obj) {	
		super(obj.toString());
		item = obj;
	}

	public Object getItem() {
		return item;
	}
}
