
package layout;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
 

public class T extends Application{

  @Override
    public void start(Stage PStage){
        Group root = new Group();
        
        
        Scene scene = new Scene(root,400,400);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}

