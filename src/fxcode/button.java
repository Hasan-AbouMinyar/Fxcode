
package fxcode;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;



public class button extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage thisstage){
        
        
        
        thisstage.setTitle("this is will show button");
        Group hold = new Group();
        Scene tohold = new Scene(hold,800,300);
        
        tohold.setFill(Color.BISQUE);
        
        
        
        Button bt = new Button();
        bt.setText("good luck");
        
        
        bt.setLayoutX(130);
        bt.setLayoutY(130);
        
        bt.setOnAction((ActionEvent event)->{
            System.out.println("good bor");
        });
        
        Text te = new Text();
        
        te.setFont(new Font(45));
        te.setX(30);
        te.setY(200);
        te.setText("good luck for your exam");
        
        hold.getChildren().add(te);
        
        
        hold.getChildren().add(bt);
       
        thisstage.setScene(tohold);
        
//        thisstage.setFullScreen(true);
        
        thisstage.show();
        
    }

   
    
}
