package labday;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
 

public class ARC extends Application{

  @Override
    public void start(Stage PStage){
        Group root = new Group();
        
        Arc one = new Arc(200,200,100,100,45,240);
        one.setType(ArcType.ROUND);
//        one.setFill(Color.TRANSPARENT);
        one.setStroke(Color.BLACK);
        
        root.getChildren().add(one);
        
        Scene scene = new Scene(root,400,400);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}

