package Forms;

import javafx.application.Application;
import javafx.geometry.Pos; // Needed for Pos
import javafx.scene.Scene;
import javafx.scene.control.Button; // Needed for Button
import javafx.scene.layout.HBox; // Needed for HBox
import javafx.stage.Stage;

public class HBoxPrefSizeAndAlignmentExample extends Application { // Changed class name

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // HBox with spacing 10 between buttons
        HBox hbox = new HBox(10); // 10px spacing

        // *** Highlighted lines from the image ***
        hbox.setPrefSize(100, 50); // Set the preferred size of the HBox
        hbox.setAlignment(Pos.BOTTOM_RIGHT); // Set the alignment to bottom right
        // ***************************************

        // Add buttons to the HBox
        hbox.getChildren().addAll(okBtn, cancelBtn);

        // Create a Scene with the HBox as the root
        // The scene size can be determined by the HBox's preferred size and content
        Scene scene = new Scene(hbox);

        stage.setTitle("Using HBox Alignment Property");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}