
package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class button extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage thisstage){
        
        
        
        thisstage.setTitle("this is will show button");
        Group hold = new Group();
        Scene tohold = new Scene(hold,300,300,Color.LIGHTBLUE);
        
        thisstage.initStyle(StageStyle.UNIFIED);
        
        Button bt = new Button();
        bt.setText("good luck");
       
        thisstage.setScene(tohold);
        
//        thisstage.setFullScreen(true);
        
        thisstage.show();
        
    }

   
    
}
