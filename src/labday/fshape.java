
package labday;

import static javafx.application.Application.launch;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

import javafx.application.Application;


public class fshape extends Application{
    
    @Override
    public void start(Stage li){
        
        Line Top = new Line(50,20,200,20);
        Line lf  = new Line(200,20,200,200);
        Line bttom = new Line(200,200,50,200);
        Line lr = new Line(50,200,50,20);
        
        lr.setStrokeWidth(10);
        Top.setStrokeWidth(10);
        lf.setStrokeWidth(10);
        bttom.setStrokeWidth(10);
        lr.setStroke(Color.RED);
        
        
        Group go = new Group();
        ObservableList g = go.getChildren();
        
        g.add(Top);
        g.add(lf);
        g.add(bttom);
        g.add(lr);
        
        Scene show = new Scene(go,400,400);
        li.setTitle("squar line");
        
        li.setScene(show);
        
        li.show();
        
        
        
        
        
      
    }
    
    public static void main (String[] args){
        launch();
    }

    
}
