package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SceneFx extends Application {
    
    public static void main(String[] args){
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Group root = new Group();
        Scene scene = new Scene(root,600,600,Color.GREENYELLOW);
        Stage stage = new Stage();
        
        Text des = new Text();
        des.setText("this is an application");
        des.setX(50);
        des.setY(50);
        
        root.getChildren().add(des);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
}
