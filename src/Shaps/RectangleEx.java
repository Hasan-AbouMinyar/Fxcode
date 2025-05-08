
package Shaps;


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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;



public class RectangleEx extends Application {
    
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
      
       Rectangle rect = new Rectangle();
        rect.setX(0);       // إحداثيات الزاوية العلوية اليسرى (X)
        rect.setY(50);       // إحداثيات الزاوية العلوية اليسرى (Y)
        rect.setWidth(750);  // عرض المستطيل
        rect.setHeight(100); // ارتفاع المستطيل
        rect.setFill(Color.BLUE); // لون التعبئة
        
       root.getChildren().add(rect);
        
    }

   
    
}
