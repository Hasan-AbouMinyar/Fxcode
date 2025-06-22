
package labday;

import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.shape.StrokeLineCap;


public class strokeline extends Application{
     @Override
    public void start(Stage sto){
        
        sto.setTitle("type of line");
        Group math = new Group();
        Scene secreen = new Scene(math,400,400);
        secreen.setFill(Color.GRAY);
        
        Line one = new Line (20,20,220,20);
        one.setStroke(Color.RED);
        one.setStrokeWidth(15);
        one.setStrokeLineCap(StrokeLineCap.BUTT);
        one.getStrokeDashArray().addAll(40d,40d,40d,40d,40d);
        math.getChildren().add(one);
        
        Line two = new Line (20,60,220,60);
        two.setStroke(Color.WHITE);
        two.setStrokeWidth(15);
        two.setStrokeLineCap(StrokeLineCap.ROUND);
        two.getStrokeDashArray().addAll(40d,40d,40d,40d,40d);
        math.getChildren().add(two);
        
        Line three = new Line (20,100,220,100);
        three.setStroke(Color.BLUE);
        three.setStrokeWidth(15);
        three.setStrokeLineCap(StrokeLineCap.SQUARE);
        math.getChildren().add(three);
        
        sto.setScene(secreen);
        sto.setTitle("line bro");
        sto.show();
      
    }
    
    public static void main (String[] args){
        launch();
    }
}
