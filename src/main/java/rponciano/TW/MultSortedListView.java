package rponciano.TW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

/**
 * Helper class to perform operations with list contents and information that
 * lists share, such as being multi selectable.
 * 
 * @author romuloponciano
 *
 * @param <R>
 */
public class MultSortedListView<R> extends ListView<R> {

	/**
	 * Basic constructor of the class. It set the list as a Multi Selectable list.
	 */
	public MultSortedListView() {
		this.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	}

	/**
	 * Method to get the content inside the list as a List
	 * 
	 * @return the content inside the list as a List<R>
	 */
	public List<R> getItemsAsList() {
		List<R> out = new ArrayList<R>();
		for (R item : this.getItems()) {
			out.add(item);
		}
		return out;
	}

	/**
	 * Method to get the content inside the list as a Observable, but as a new
	 * Observable. <b>It is important because if we just associate the two
	 * Observable lists, the TransferWindow class will "save" the modifications of
	 * the user even if the user click on cancel button.</b>
	 * 
	 * @return a new ObservableList<R> with the content inside the list
	 */
	public ObservableList<R> getItemsAsNewObservableList() {
		return FXCollections.observableArrayList(getItemsAsList());
	}

	/**
	 * Method to sort the items. This method will define the mode and attribute that
	 * you want to user for sort the items. <b> If you want to change, just change
	 * the compare method.</b>
	 */
	public void sortItems() {
		Collections.sort(this.getItems(), new Comparator<R>() {
			@Override
			public int compare(R o1, R o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
	}

	/**
	 * Method to add a ObservableList inside the content. Then, sort items.
	 * 
	 * @param in ObservableList<R> with the new elements to be inserted
	 */
	public void addAll(ObservableList<R> in) {
		this.getItems().addAll(in);
		this.sortItems();
	}

	/**
	 * Method to remove a ObservableList inside the content. Then, sort items.
	 * 
	 * @param out ObservableList<R> with the elements to be removed
	 */
	public void removeAll(ObservableList<R> out) {
		this.getItems().removeAll(out);
		this.sortItems();
	}

	/**
	 * Method to clear the content inside a list
	 */
	public void clear() {
		this.getItems().clear();
	}
}
