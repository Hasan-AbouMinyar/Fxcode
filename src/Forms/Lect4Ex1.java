
package Forms;

import javafx.application.Application;
import javafx.geometry.Insets; // Needed for Insets
import javafx.scene.Scene;
import javafx.scene.layout.HBox; // Needed for HBox
import javafx.scene.shape.Rectangle; // Needed for Rectangle
import javafx.stage.Stage;

public class Lect4Ex1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create an HBox with spacing between nodes
        HBox root = new HBox(50); // 50 is the spacing between child nodes only

        // Set padding around the HBox
        root.setPadding(new Insets(10)); // padding between hbox border and row

        // Create different Rectangle objects
        Rectangle r1 = new Rectangle(100, 100); // Square
        Rectangle r2 = new Rectangle(200, 200); // Big Square
        Rectangle r3 = new Rectangle(50, 200);  // Vertical rectangle
        Rectangle r4 = new Rectangle(200, 50);  // Horizontal rectangle

        // Set a margin for the first rectangle (space between border & child node)
        HBox.setMargin(r1, new Insets(20, 20, 20, 20)); // Top, Right, Bottom, Left insets

        // Add all rectangles to the HBox
        root.getChildren().addAll(r1, r2, r3, r4);

        // Create a Scene with the HBox as the root
        Scene scene = new Scene(root); // Scene size will be calculated based on content

        primaryStage.setTitle("HBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}