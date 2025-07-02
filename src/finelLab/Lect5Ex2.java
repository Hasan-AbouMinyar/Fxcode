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

public class Lect5Ex2 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Button yesBtn = new Button("Yes");
        Button noBtn = new Button("No");
        Button cancelBtn = new Button("Cancel");

        HBox root = new HBox();
        root.getChildren().addAll(yesBtn, noBtn, cancelBtn);
        Scene scene = new Scene(root,400,400);

        // --- هذا هو السطر المهم ---
        // تطبيق التنسيق مباشرة على زر "Yes" فقط
        yesBtn.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        
        noBtn.setStyle("-fx-text-fill: white; -fx-background-color: blue;");
        
        scene.getStylesheets().add(getClass().getResource("fu.css").toExternalForm());

        stage.setScene(scene);
        stage.setTitle("Styling Buttons");
        stage.show();
    }
}