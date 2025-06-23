package labday;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
import javafx.scene.paint.Color;
 

public class Elips extends Application{

  @Override
    public void start(Stage PStage){
        Group root = new Group();
        
        Ellipse holl = new Ellipse();
        holl.setCenterX(200);
        holl.setCenterY(200);
        holl.setRadiusX(100);
        holl.setRadiusY(50);
        holl.setFill(Color.BLACK);
        holl.setStroke(Color.RED);
        holl.setStrokeWidth(4);
        root.getChildren().add(holl);
        
        
        Scene scene = new Scene(root,400,400);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}
