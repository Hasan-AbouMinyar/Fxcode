package labday;

import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.StrokeLineCap;

public class fourRectangle extends Application {
    
    
        @Override
    public void start(Stage rgggg){
        
        Group root = new Group();
        
        Scene hold = new Scene(root,400,400);
        
        Rectangle r1 = new Rectangle(20,20,200,50);
        r1.setFill(Color.RED);
        r1.setStroke(Color.BLACK);
        Text t1 = new Text("r1");
        t1.setLayoutX(2);
        t1.setLayoutY(45);
        root.getChildren().add(r1);
        root.getChildren().add(t1);
        
        
        Rectangle r2 = new Rectangle(20,90,200,50);
        r2.setFill(Color.WHITE);
        r2.setStroke(Color.BLACK);
        r2.setStrokeWidth(15);
        Text t2 = new Text("r2");
        t2.setLayoutX(2);
        t2.setLayoutY(115);
        root.getChildren().add(r2);
        root.getChildren().add(t2);

        
        
        Rectangle r3 = new Rectangle(20,160,200,50);
        r3.setFill(Color.YELLOW);
        r3.setStroke(Color.BLACK);
        r3.setArcHeight(20);
        r3.setArcWidth(20);
        Text t3 = new Text("r3");
        t3.setLayoutX(2);
        t3.setLayoutY(185);
        root.getChildren().add(r3);
        root.getChildren().add(t3);

        
        
        Rectangle r4 = new Rectangle(20,230,200,50);
        r4.setFill(Color.PINK);
        r4.setStroke(Color.PURPLE);
        r4.setStrokeLineCap(StrokeLineCap.ROUND);
        r4.getStrokeDashArray().addAll(5d,30d);
        r4.setStrokeWidth(20);
        Text t4 = new Text("r4");
        t4.setLayoutX(2);
        t4.setLayoutY(255);
        root.getChildren().add(r4);
        root.getChildren().add(t4);
        
        rgggg.setScene(hold);
        rgggg.setTitle("ShowRegtangle");
        rgggg.show();
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}
