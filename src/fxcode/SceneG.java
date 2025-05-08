package fxcode;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
public class SceneG extends Application {

 
    public static void main(String [] args){
        launch();
        
    }
    @Override
    public void start(Stage ex){
        
        Group hold = new Group();
        
        Scene tohold = new Scene(hold);
        
        ex.setScene(tohold);
        
        ex.show();
        
        
        
        
        
    }
    
}
