
package finelLab;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class NewClass extends Application {
    
    @Override
    public void start(Stage g){
        
        Group amg = new Group();
        
        Scene doe = new Scene(amg,400,400);
        
        g.setScene(doe);
        
        g.show();
        
    }
    
    public static void main(String [] args){
        launch();
    }
    
}
