
package labday;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
        
public class thefirst extends Application {
    
    @Override
    public void start(Stage look){
    
        look.setTitle("this a button");
        Button clik = new Button("Click");
        Group holder = new Group(clik);
        Scene wind = new Scene(holder, 400,400);
        
        look.setWidth(400);
        look.setHeight(400);
        look.setFullScreen(true);
        
        
      
        
        
        look.setScene(wind);
        look.show();
    }
    
    public static void main(String[] args){
        
        launch();
    }
    
   
}
