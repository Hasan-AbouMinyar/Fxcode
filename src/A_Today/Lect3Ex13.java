/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Lect3Ex13 extends Application {

    @Override
    public void start(Stage stage) {

        Polygon polygon = new Polygon();

        polygon.getPoints().addAll(new Double[]{
            200.0, 150.0,
            170.0, 85.0,
            180.0, 75.0,
            320.0, 65.0,
            350.0, 95.0,
            325.0, 105.0,
            370.0, 150.0,
            325.0, 170.0,
            290.0, 150.0,
           
            
           
        });

        Group root = new Group(polygon);

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Drawing a Polygon");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}