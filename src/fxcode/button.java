
package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class button extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage thisstage){
        
        
        
        thisstage.setTitle("this is will show button");
        Group hold = new Group(new Button("show this button"));
        Scene tohold = new Scene(hold);
        thisstage.setScene(tohold);
        
        thisstage.show();
        
    }

   
    
}
