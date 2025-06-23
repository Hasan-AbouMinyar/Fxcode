package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class Hgrowht extends Application {

    @Override
    public void start(Stage stage) {
        
        
        
        Label des = new Label("name");
        TextField name = new TextField();
        
        
        
        
        
        
        Button ok = new Button("ok");
        Button cn = new Button("cnacel");
        
        
        HBox line = new HBox(10);
        
        line.getChildren().addAll(des,name,ok,cn);
        HBox.setHgrow(name, Priority.ALWAYS);
        
        Scene e = new Scene(line);
        stage.setScene(e);
        stage.show();
     }

    public static void main(String[] args) {
        launch(args);
    }
}