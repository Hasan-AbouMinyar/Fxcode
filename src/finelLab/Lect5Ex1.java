package finelLab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Lect5Ex1 extends Application {

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
        // Add a style sheet to the scene
//        scene.getStylesheets().add("finalLab/styles.css");
        scene.getStylesheets().add(getClass().getResource("/finelLab/styles.css").toExternalForm());


        stage.setScene(scene);
        stage.setTitle("Styling Buttons");
        stage.show();
    }
}