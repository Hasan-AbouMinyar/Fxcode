package labday;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.Scene;

public class bottonbg extends Application {
    
    @Override
    public void start(Stage win){
        
        Button Click = new Button();
        Click.setLayoutX(170);
        Click.setLayoutY(180);
        Click.setText("Click me");
        
        Group list = new Group(Click);
       
        
        Click.setOnAction((ActionEvent event)->{
            System.out.println("go bro for noting");
        });
        
        Scene hold = new Scene(list,400,400);
        
        win.setScene(hold);
        
        win.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}
