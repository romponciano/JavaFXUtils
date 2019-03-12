package rponciano.DCRG;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.tbee.javafx.scene.layout.MigPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rponciano.DCRG.DynamicCRGroup.TYPE_GROUP;

public class RunExample extends Application implements Serializable {

    private static final long serialVersionUID = 4309486598445062855L;

    @Override
    public void start(Stage primaryStage) throws Exception {
    	
    	List<ModelExample> examples = new ArrayList<ModelExample>();
    	examples.add(new ModelExample(1L, "Example 1"));
    	examples.add(new ModelExample(2L, "Example 2"));
    	examples.add(new ModelExample(3L, "Example 3"));
    	
    	DynamicCRGroup checkList = new DynamicCRGroup(TYPE_GROUP.CHECKBOX, examples);
    	DynamicCRGroup radioList = new DynamicCRGroup(TYPE_GROUP.RADIO, examples);
    	
    	//checkList.getObjectAtPosition(position);
    	//radioList.isSelectedAtPosition(position);
    	//checkList.getObjectAtPosition(position);
    	//radioList.getToggleRadioGroup();
    	
    	MigPane pane = new MigPane();
    	pane.add(checkList, "wrap");
    	pane.add(radioList);
        primaryStage.setScene(new Scene(pane));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main( String[] args )
    {
    	Application.launch(RunExample.class);
    }
}; 