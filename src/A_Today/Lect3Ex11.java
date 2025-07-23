/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Ellipse;

public class Lect3Ex11 extends Application {

    @Override
    public void start(Stage stage) {

        Ellipse ellipse = new Ellipse();

        ellipse.setCenterX(350.0);
        ellipse.setCenterY(150.0);
        ellipse.setRadiusX(75.0);
        ellipse.setRadiusY(150.0);

        ellipse.setStroke(Color.RED);
        ellipse.setStrokeWidth(4.5);

        Group root = new Group(ellipse);

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Drawing an Ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}