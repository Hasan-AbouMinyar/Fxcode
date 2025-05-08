package fxcode;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class SceneG extends Application {

 
    public static void main(String [] args){
        launch();
        
    }
    @Override
    public void start(Stage ex){
        
        Group hold = new Group();
        
        Scene tohold = new Scene(hold,600,600,Color.BLUEVIOLET);
        
        Text whooa = new Text();
        whooa.setText("whoooa whoooa");
        whooa.setX(50);
        whooa.setY(50);
        whooa.setFont(Font.font("Verdana",60));
        whooa.setFill(Color.WHITESMOKE);
        
        Line le = new Line();
        le.setStartX(0);
        le.setStartY(60);
        le.setEndX(600);
        le.setEndY(60);
        
        le.setStrokeWidth(4);
        le.setStroke(Color.WHITESMOKE);
        le.setOpacity(0.2);
        
        hold.getChildren().add(le);
        
        
        ex.setScene(tohold);
        
        
        hold.getChildren().add(whooa);
        
        ex.show();
        
        
        
        
        
    }
    
}
