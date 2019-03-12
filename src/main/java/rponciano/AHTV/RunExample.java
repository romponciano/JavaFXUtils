package rponciano.AHTV;

import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		List<ModelExample1> examples = new ArrayList<ModelExample1>();
		examples.add(new ModelExample1(1L, "Example 1"));
		examples.add(new ModelExample1(2L, "Example 2"));
		examples.add(new ModelExample1(3L, "Example 3"));
		
		AutoHeaderTableView<ModelExample1> table1 = new AutoHeaderTableView<>(ModelExample1.class, examples);
		table1.createTableHeader();
		
		AutoHeaderTableView<ModelExample2> table2 = new AutoHeaderTableView<>(ModelExample2.class);
		table2.createTableHeader();

		MigPane pane = new MigPane("", "[]70[]", "");
		pane.add(table1);
		pane.add(table2, "wrap");
		primaryStage.setScene(new Scene(pane));
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	public static void main( String[] args )
    {
    	Application.launch(RunExample.class);
    }
}
