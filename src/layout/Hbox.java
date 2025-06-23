
package layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
 

public class Hbox extends Application{

  @Override
    public void start(Stage PStage){
       
        HBox one = new HBox(5);
        Button cancel = new Button("Cancel");
        Button ok = new Button("Doen");
        one.setAlignment(Pos.TOP_RIGHT);
        
        one.getChildren().addAll(cancel,ok);
        
        
        
        Scene scene = new Scene(one,400,400);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}

