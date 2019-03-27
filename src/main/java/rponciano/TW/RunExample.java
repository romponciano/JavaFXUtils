package rponciano.TW;

import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class RunExample extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		MigPane pane = new MigPane("", "", "");
		
		List<ModelExample> examples = new ArrayList<ModelExample>();
		examples.add(new ModelExample(1L, "ex1"));
		examples.add(new ModelExample(2L, "ex2"));
		examples.add(new ModelExample(3L, "ex3"));
		examples.add(new ModelExample(4L, "ex4"));
		
		TransferWindow<ModelExample> transferWin = new TransferWindow<ModelExample>("Selecteds", "All");
		transferWin.setAllPossibilities(examples);
		Button clicktoOpen = new Button("click me");
		clicktoOpen.setOnAction(transferWin.getOpenWindowEventHandler());
		
		pane.add(clicktoOpen);
		primaryStage.setScene(new Scene(pane, 300, 50));
		primaryStage.show();
	}
	
	
			
	
	
	public static void main(String[] args) {
		launch();
	}

}
