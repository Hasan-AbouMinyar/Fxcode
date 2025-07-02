
package finelLab;

import javafx.application.Application;
import javafx.stage.Stage;

public class NewClass extends Application {
    
    @Override
    public void start(Stage g){
        
        Groupe amg = new Groupe();
        
        g.show();
        
    }
    
    public static void main(String [] args){
        launch();
    }
    
}
