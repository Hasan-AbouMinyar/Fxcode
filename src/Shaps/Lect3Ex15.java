
package Shaps;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Lect3Ex15 extends Application {

    @Override
    public void start(Stage stage) {

        Arc arc = new Arc();

        arc.setCenterX(300.0);
        arc.setCenterY(150.0);
        arc.setRadiusX(90.0);
        arc.setRadiusY(90.0);
        arc.setStartAngle(40.0);
        arc.setLength(239.0);

        arc.setType(ArcType.ROUND);

        Group root = new Group(arc);

        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("Drawing an Arc");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}