/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;



public class CircleEx extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage stage){
        
        
        
       Group root = new Group();
       Scene scene = new Scene(root,800,600);
       stage.setTitle("This an example of Line");
       scene.setFill(Color.BLACK);
       stage.setScene(scene);
       stage.show();
      
       Circle ce = new Circle();
       ce.setCenterX(200);
       ce.setCenterY(300);
       ce.setRadius(40);
       
       ce.setStroke(Color.YELLOW);
       ce.setFill(Color.YELLOW);
       
       Circle ce2 = new Circle();
       ce2.setCenterX(30);
       ce2.setCenterY(300);
       ce2.setRadius(12);
       
       ce2.setStroke(Color.BLUE);
       ce2.setFill(Color.BLUE);
       
       Ellipse ellipse = new Ellipse ( );
ellipse.setCenterX(200);
ellipse.setCenterY(300);
ellipse.setRadiusX(170);
ellipse.setRadiusY(70);
ellipse.setStroke(Color.WHITE);
ellipse.setStrokeWidth(4 );
       root.getChildren().addAll(ellipse,ce,ce2);
        
    }

   
    
}
