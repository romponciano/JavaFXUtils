package rponciano.LWC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rponciano.LWC.ListWithControl.LIST_TYPE;

public class RunExample extends Application implements Serializable {

	private static final long serialVersionUID = 4309486598445062855L;

	public static void main(String[] args) {
		Application.launch(RunExample.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		ListWithControl textList = new ListWithControl(LIST_TYPE.TEXT_ENTRY);

		List<String> comboValues = new ArrayList<String>();
		comboValues.add("opt 1");
		comboValues.add("opt 2");
		comboValues.add("opt 3");
		ListWithControl comboList = new ListWithControl(LIST_TYPE.COMBO_CHOICE, comboValues);

		MigPane pane = new MigPane("", "[]40[]", "");
		pane.add(textList);
		pane.add(comboList);
		primaryStage.setScene(new Scene(pane));
		primaryStage.sizeToScene();
		primaryStage.show();
	}

};