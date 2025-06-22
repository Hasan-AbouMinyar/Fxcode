/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labday;

import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;
/**
 *
 * @author abouminyar
 */
public class incenter extends Application {
    @Override
    public void start(Stage te){
        
        Text word = new Text();
        word.setFont(new Font(45));
        word.setLayoutX(170);
        word.setLayoutY(180);
        word.setText("This is me Hasan Abouminyar");
        
        Button g = new Button("Click the example");
        
        Group home = new Group();
        ObservableList li = home.getChildren();
        li.add(word);
        li.add(g);
        
        
        Scene show = new Scene(home, 800,400);
        
        te.setTitle("My name bro");
        
        te.setScene(show);
        
        te.show();
        
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}
