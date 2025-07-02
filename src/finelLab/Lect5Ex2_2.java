/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finelLab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lect5Ex2_2 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        HBox root = new HBox(10); // 10 is spacing
        root.getChildren().addAll(okBtn, cancelBtn);

        // Set styles for the OK button and its parent HBox
//        root.setStyle("-fx-cursor: hand; -fx-border-color: blue; -fx-border-width: 10px;");
        okBtn.setStyle("-fx-border-color: red; -fx-border-width: inherit;");
        
        root.setStyle("-fx-cursor: hand; -fx-border-color: lightgreen; -fx-border-width:70px;");
        
        cancelBtn.setStyle("-fx-border-color:gray; -fx-border-width:20px");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("CSS Inheritance");
        stage.show();
    }
}