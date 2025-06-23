package labday;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
        
 

public class SolerSystem extends Application{

  @Override
    public void start(Stage PStage){
        Group root = new Group();
        
        Ellipse core = new Ellipse();
        core.setCenterX(300);
        core.setCenterY(300);
        core.setRadiusX(200);
        core.setRadiusY(100);
        core.setFill(Color.BLACK);
        core.setStroke(Color.WHITE);
        core.setStrokeWidth(5);
        
        
        Circle yoo = new Circle(300,300,50);
        yoo.setFill(Color.YELLOW);
        
        Circle yng = new Circle(100,300,20);
        yng.setFill(Color.BLUE);
        
        root.getChildren().addAll(core,yoo,yng);
        
        
        Scene scene = new Scene(root,800,600);
        scene.setFill(Color.BLACK);
        PStage.setScene(scene);
        PStage.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}

