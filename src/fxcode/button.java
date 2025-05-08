
package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class button extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage thisstage){
        
        
        
        thisstage.setTitle("this is will show button");
        Group hold = new Group(new Button("show this button"));
        Scene tohold = new Scene(hold,1000,1000,Color.BLUE);
        thisstage.setWidth(40.0);
        thisstage.setHeight(40.0);
        thisstage.setScene(tohold);
        
        thisstage.show();
        
    }

   
    
}
