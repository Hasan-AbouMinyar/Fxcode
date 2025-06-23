
package labday;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Polygon;
 

public class polygon extends Application{

  @Override
    public void start(Stage PStage){
        Group root = new Group();
        
        
        Polygon dymon = new Polygon();
        dymon.getPoints().addAll(new Double []{
            200.0,20.0,
            250.0,70.0,
            250.0,120.0,
            200.0,170.0,
            150.0,120.0,
            150.0,70.0
        });
        
        root.getChildren().add(dymon);
        Scene scene = new Scene(root,400,400);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}

