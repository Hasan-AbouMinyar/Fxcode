
package layout;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hboxex extends Application {

    @Override
    public void start(Stage primaryStage) {

        HBox hbox = new HBox(10); // space between child nodes only
        hbox.setPadding(new Insets(100)); // padding between hbox border and row.
        Rectangle r1 = new Rectangle(100, 100); // Square
        Rectangle r2 = new Rectangle(200, 200); // Big Square
        Rectangle r3 = new Rectangle(50, 200); // Vertical rectangle
        Rectangle r4 = new Rectangle(200, 50); // Horizontal rectangle
        HBox.setMargin(r1, new Insets(20, 20, 20, 20));
//        HBox.setMargin(r3, new Insets(20));
        hbox.getChildren().addAll(r1, r2, r3, r4);

        Scene scene = new Scene(hbox);

        primaryStage.setTitle("HBox Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}