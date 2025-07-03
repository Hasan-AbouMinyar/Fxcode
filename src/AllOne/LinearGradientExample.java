/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AllOne;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LinearGradientExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Rectangle rect = new Rectangle(200, 100);

        // 1. تحديد محطات الألوان
        Stop[] stops = new Stop[]{
            new Stop(0, Color.BLUE), // عند البداية (0%)، اللون أزرق
            new Stop(0.25, Color.RED),
            new Stop(0.50, Color.GREEN),// عند النهاية (100%)، اللون أحمر
            new Stop(0.75, Color.YELLOW),
            new Stop(0.1, Color.BROWN),};

        Stop[] o = new Stop[]{
            new Stop(0, Color.LIGHTGRAY),
            new Stop(1, Color.GREEN)
        };

        // 2. إنشاء كائن التدرج الخطي
        LinearGradient lg = new LinearGradient(
                0, 0, 1, 0, // من الأعلى (y=0) إلى الأسفل (y=1)
                true, // نسبي لحجم الشكل
                CycleMethod.NO_CYCLE,
                o
        );

        LinearGradient green = new LinearGradient(1, 0, 0, 0, true, CycleMethod.NO_CYCLE, stops);

        // 3. تطبيق التدرج كتعبئة للشكل
        rect.setFill(green);

        StackPane root = new StackPane(rect);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("LinearGradient Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
