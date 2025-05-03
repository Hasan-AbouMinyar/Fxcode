package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneFx extends Application {
    
    public static void main(String[] args){
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Group root = new Group();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setScene(scene);
        stage.show();
        
    }
    
}
