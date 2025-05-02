
package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.Node;


public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage){
        Group amg= new Group();
        ObservableList<Node> list = amg.getChildren();
        
        Circle e = new Circle(200,150,50);
        e.setFill(Color.BLUE);
        
        list.add(e);
        
        Scene s = new Scene(amg,400,300);
        
        primaryStage.setTitle("example of fxcodex");
        primaryStage.setScene(s);
        primaryStage.show();
        
        
    }
    
    public static void main (String[] args){
        
        System.out.print("good lock");
        System.out.println("show ");
        launch(args);
        
    }
    
}


