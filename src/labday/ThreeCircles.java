
package labday;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;


public class ThreeCircles extends Application{
    
    @Override
    public void start(Stage threeC){
        
        Group holdCir = new Group();
        
        Circle redTop = new Circle(140,180,70);
        redTop.setFill(Color.RED);
        redTop.setStroke(Color.BLACK);
        holdCir.getChildren().add(redTop);
         
        Circle redDown = new Circle(100,250,70);
        redDown.setFill(Color.RED);
        redDown.setStroke(Color.BLACK);
        holdCir.getChildren().add(redDown);
        
        Circle white = new Circle(180,250,70);
        white.setFill(Color.WHITE);
        holdCir.getChildren().add(white);
        
        Scene hold = new Scene(holdCir, 400,400);
        
        threeC.setScene(hold);
        threeC.setTitle("Drow Three Circle");
        
        threeC.show();
         
        
        
        
        
    }
    
    
    public static void main(String[] args){
        launch();
    }
}
