
package fxcode;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;



public class ex extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage stage){
        
        
        
       Group root = new Group();
       Scene scene = new Scene(root,800,600);
       stage.setTitle("This an example of Line");
       scene.setFill(Color.LIGHTSEAGREEN);
       stage.setScene(scene);
       stage.show();
       
       Line ln = new Line();
       ln.setStartX(50);
       ln.setStartY(200);
       ln.setEndX(700);
       ln.setEndY(200);
       ln.setStrokeWidth(200);
       ln.setStroke(Color.GREEN);
       
       root.getChildren().add(ln);
        
    }

   
    
}
