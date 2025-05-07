
package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class reRead extends Application {
    
    
    public static void main(String [] args){
        
        launch();
    }
    
    @Override
    public void start(Stage go){
        
        Group gg = new Group();
        Scene se = new Scene(gg,Color.BEIGE);
        
        go.setTitle("this is titel");
        
        go.setScene(se);
        
        go.show();
        
    }
    
}
