package rponciano.DDTable;

import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;

public class DragDrop extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		List<ModelExample> examples = new ArrayList<ModelExample>();
		examples.add(new ModelExample(1L, "Example 1"));
		examples.add(new ModelExample(2L, "Example 2"));
		examples.add(new ModelExample(3L, "Example 3"));
		
		final TableView<ModelExample> dragOrigin = new TableView<>(FXCollections.observableArrayList(examples));
		createTableHeader(dragOrigin);

		final TableView<ModelExample> dragTarget = new TableView<>();
		createTableHeader(dragTarget);
		
		final DataFormat customFormat = new DataFormat("ModelExample");

		dragOrigin.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				Dragboard db = dragOrigin.startDragAndDrop(TransferMode.MOVE);
				ClipboardContent content = new ClipboardContent();
				content.put(customFormat, dragOrigin.getSelectionModel().getSelectedItem());
				db.setContent(content);
				event.consume();
			}
		});

		dragTarget.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getGestureSource() != dragTarget) {
					event.acceptTransferModes(TransferMode.MOVE);
				}
				event.consume();
			}
		});
		
		dragTarget.setOnDragDropped(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				Dragboard db = event.getDragboard();
				boolean success = false;
				if (db.hasContent(customFormat)) {
					dragTarget.getItems().add((ModelExample)db.getContent(customFormat));
					success = true;
				}
				event.setDropCompleted(success);
				event.consume();
			}
		});
		dragOrigin.setOnDragDone(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				if (event.getTransferMode() == TransferMode.MOVE) {
					dragOrigin.getItems().remove(dragOrigin.getSelectionModel().getSelectedIndex());
				}
				event.consume();
			}
		});

		MigPane pane = new MigPane("", "[]70[]", "");
		pane.add(dragOrigin);
		pane.add(dragTarget, "wrap");
		primaryStage.setScene(new Scene(pane));
		primaryStage.sizeToScene();
		primaryStage.show();
	}
	
	@SuppressWarnings("unchecked")
	public void createTableHeader(TableView<ModelExample> table) {
		TableColumn<ModelExample, Long> idCol = new TableColumn<>("Id");
		idCol.setCellValueFactory(new PropertyValueFactory<ModelExample, Long>("id"));
		TableColumn<ModelExample, String> nameCol = new TableColumn<>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<ModelExample, String>("name"));
		table.getColumns().addAll(idCol, nameCol);
	}

	public static void main(String[] args) {
		Application.launch();
	}
}
