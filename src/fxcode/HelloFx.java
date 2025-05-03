
package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloFx extends Application {
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //Stage go = new Stage();
      Group first = new Group();
      
      Scene sacand = new Scene(first,Color.YELLOW);
      
      stage.setScene(sacand);
      
      stage.setTitle("yellow scene");
      stage.show();
        
    }
    
    
}
