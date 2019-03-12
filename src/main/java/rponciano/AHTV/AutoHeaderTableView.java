package rponciano.AHTV;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Class created to make it easy to create the JavaFX TableView header. With
 * this class, just instantiate and call a method for the header to be created
 * based on the data class of the table.
 * 
 * @author romuloponciano
 *
 * @param <R> - represents the data class of the table. It is from this class
 *        that the header will be generated.
 */
public class AutoHeaderTableView<R> extends TableView<R> {

	private final Class<R> TYPE;

	/**
	 * Basic construtor of the class.
	 * 
	 * @param dataType - used to know which class contains get's to mount header
	 */
	public AutoHeaderTableView(Class<R> dataType) {
		super(FXCollections.<R>observableArrayList());
		TYPE = dataType;
	}

	/**
	 * Constructor to initialize table with values from an ObservableList.
	 * 
	 * @param dataType - used to know which class contains get's to mount header
	 * @param content  - content that will be populated in the table.
	 */
	public AutoHeaderTableView(Class<R> dataType, ObservableList<R> content) {
		super(content);
		TYPE = dataType;
	}

	/**
	 * Constructor to initialize table with values from a List.
	 * 
	 * @param dataType - used to know which class contains get's to mount header
	 * @param content  - content that will be populated in the table.
	 */
	public AutoHeaderTableView(Class<R> dataType, List<R> content) {
		super(FXCollections.observableArrayList(content));
		TYPE = dataType;
	}

	/**
	 * Method used to create the columns based on the get's class.
	 */
	public void createTableHeader() {
		try {
			PropertyDescriptor[] props = Introspector.getBeanInfo(TYPE).getPropertyDescriptors();
			for (PropertyDescriptor prop : props) {
				createColumn(prop);
			}
			this.getColumns().remove(0); // remove the first column : Class of table
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
	}

	private void createColumn(PropertyDescriptor prop) {
		String colName = prop.getReadMethod().getName().replace("get", "");
		TableColumn<R, Object> column = new TableColumn<R, Object>(colName.toUpperCase());
		column.setCellValueFactory(new PropertyValueFactory<R, Object>(colName.toLowerCase()));
		this.getColumns().add(column);
	}
}