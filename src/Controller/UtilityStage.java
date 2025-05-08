
package Controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UtilityStage extends Application {
    @Override
    public void start(Stage stage) {
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Utility Window");

        // إضافة النص لعرض نوع النافذة
        Label label = new Label("This is a Utility Window");
        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 300, 200);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
