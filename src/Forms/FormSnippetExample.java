package Forms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FormSnippetExample extends Application { // Changed class name

    @Override
    public void start(Stage stage) {
        // HBox with spacing
        HBox root = new HBox(10); // 10px spacing

        // Create form elements
        Label descLbl = new Label("Description:");
        TextArea desc = new TextArea();

        // --- Highlighted lines from the image ---
        // Set preferred number of columns (width hint)
        desc.setPrefColumnCount(10);
        // Set preferred number of rows (height hint)
        desc.setPrefRowCount(3);

        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // Allow the Cancel button to expand vertically to fill available space
        cancelBtn.setMaxHeight(Double.MAX_VALUE);

        CheckBox fillHeightCbx = new CheckBox("Fill Height");
        // Set the checkbox to be selected by default
        fillHeightCbx.setSelected(true);

        // Add elements to the root HBox
        // Note: Adding all directly to HBox will place them horizontally
        root.getChildren().addAll(descLbl, desc, fillHeightCbx, okBtn, cancelBtn);
        // ----------------------------------------

        Scene scene = new Scene(root); // Scene size based on content
        stage.setTitle("Using HBox Alignment Property"); // Title from the image
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}