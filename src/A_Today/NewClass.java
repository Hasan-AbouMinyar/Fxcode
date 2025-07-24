/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class exppto extends Application {
    @Override
               public void start(Stage primaryStage) {
        TextField tf = new TextField();
        Button btn = new Button();
        btn.setText("Add");        
         TextField tf2 = new TextField();
        Button btn2 = new Button();
        btn2.setText("Mul");
        Text t = new Text ("Result:");
        Text here = new Text (""); 
        btn.setOnAction(e-> {
                double f= Double.parseDouble(tf.getText());
                double s= Double.parseDouble(tf2.getText());
                double sum = f+s;
                here.setText(String.valueOf(sum));
        });
        btn2.setOnAction(e-> {
                double f= Double.parseDouble(tf.getText());
                double s= Double.parseDouble(tf2.getText());
                double mul = f*s;
                here.setText(String.valueOf(mul));            
        });
        HBox one = new HBox();
        one.getChildren().addAll(tf,btn);
        HBox two = new HBox();
        two.getChildren().addAll(tf2,btn2);
         HBox three = new HBox();
        three.getChildren().addAll(t,here);
        one.setSpacing(10);
        two.setSpacing(10);
        three.setSpacing(10);
        VBox root = new VBox();
        root.getChildren().addAll(one,two,three);
        root.setSpacing(10);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}