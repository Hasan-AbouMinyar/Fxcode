package A_Today;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Lect3Ex5 extends Application {
    @Override

    public void start(Stage stage) {

        Line amv = new Line();

        amv.setStartX(500.0);
        amv.setStartY(30.0);
        amv.setEndX(100.0);
        amv.setEndY(270.0);
        
        Line amg = new Line();

        amg.setStartX(300.0);
        amg.setStartY(30.0);
        amg.setEndX(99.0);
        amg.setEndY(200.0);

        Group root = new Group();
        root.getChildren().addAll(amv,amg);

        Scene scene = new Scene(root, 600, 300);

        stage.setTitle("Sample application");

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}