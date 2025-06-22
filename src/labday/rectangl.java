package labday;

import static javafx.application.Application.launch;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.Scene;

public class rectangl extends Application {
     @Override
    public void start(Stage spr){
        
        Rectangle rg = new Rectangle(250,20,120,300);
        rg.setFill(Color.RED);
        
        Rectangle rgb = new Rectangle(20,100,200,100);
        rgb.setFill(Color.BLUE);
        rgb.setArcWidth(1000);
        rgb.setArcHeight(1000);
        
        Group cach = new Group();
        cach.getChildren().add(rg);
        cach.getChildren().add(rgb);
        
        Scene hold = new Scene(cach,400,400);
        spr.setTitle("two Rectangle");
        spr.setScene(hold);
        spr.show();
        
    }
    
    public static void main (String[] args){
        launch();
    }
}
