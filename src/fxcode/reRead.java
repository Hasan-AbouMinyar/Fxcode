
package fxcode;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
        
        Image so = new Image("/fxcode/logo.png");
        go.getIcons().add(so);
        go.setTitle("this is titel");
        
        go.setScene(se);
        
        go.show();
        
    }
    
}
