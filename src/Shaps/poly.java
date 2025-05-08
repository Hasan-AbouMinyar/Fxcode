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
import javafx.scene.shape.Polygon;



public class poly extends Application {
    
    public static void main (String [] args){
        
        launch();
    }
    @Override
    public void start(Stage stage){
        
        
        
       Group root = new Group();
       Scene scene = new Scene(root,800,600);
       stage.setTitle("This an example of Line");
       scene.setFill(Color.WHITE);
       stage.setScene(scene);
       stage.show();
       
       Polygon g = new Polygon();
       
//       g.getPoints().addAll(new Double[]{
//           400.0,50.0,
//           550.0,150.0,
//           400.0,250.0,
//           250.0,150.0,
//       });
g.getPoints().addAll(new Double[]{
           300.0,50.0,
           150.0,50.0,
           50.0,250.0,
           400.0,250.0,
       });
      
       root.getChildren().addAll(g);
        
    }

   
    
}
