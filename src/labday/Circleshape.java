
package labday;

import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.shape.Circle;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Circleshape extends Application {
    
      @Override
    public void start(Stage forC){
        
        Circle blackCircle = new Circle(200,200,70);
        
        Group tohold = new Group();
        tohold.getChildren().add(blackCircle);
        
        Scene hold = new Scene(tohold,400,400);
        
        forC.setScene(hold);
        forC.setTitle("Drowing Circle");
        forC.show();
        
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}
