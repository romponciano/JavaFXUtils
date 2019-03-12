package rponciano.ACTF;

import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RunExample extends Application {

	public static void main(String[] args) {
		Application.launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		List<String> users = new ArrayList<String>();
		users.add("log12ew");
		users.add("log546");
		users.add("logdsa5");
		users.add("user45");
		users.add("f5d4a6");
		
		AutoCompleteTextField textField = new AutoCompleteTextField(users, 3);
		
		MigPane pane = new MigPane();
		pane.add(textField);
		primaryStage.setScene(new Scene(pane));
		primaryStage.show();
	}
}
