/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;

public class Lect3Ex6 extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(150.0);
        rectangle.setY(75.0);
        rectangle.setWidth(160.0);
        rectangle.setHeight(150.0);

        Group root = new Group(rectangle);

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Drawing a Rectangle");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}