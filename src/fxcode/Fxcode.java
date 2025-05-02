package fxcode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author abouminyar
 */
public class Fxcode extends Application {

    @Override
    public void start(Stage primaryStage) {
        // عنصر بسيط لعرض النص
        Label label = new Label("مرحبًا بك في JavaFX!");

        // تخطيط بسيط يحتوي على العنصر
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // إنشاء المشهد وتحديد الأبعاد
        Scene scene = new Scene(root, 400, 300);

        // إعداد النافذة
        primaryStage.setTitle("تطبيقي الأول بـ JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // تشغيل تطبيق JavaFX
    }
}
