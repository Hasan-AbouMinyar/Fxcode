/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DropShadowExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. إنشاء العقدة (نص في هذه الحالة)
        Text text = new Text("DropShadow Effect");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        text.setFill(Color.CRIMSON);

        // 2. إنشاء كائن DropShadow وتخصيص خصائصه
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(5.0);
        dropShadow.setOffsetX(-9.0);
        dropShadow.setOffsetY(9.0);
        dropShadow.setColor(Color.color(0.4, 0.5, 0.5)); // لون رمادي داكن

        // 3. تطبيق التأثير على النص
        text.setEffect(dropShadow);

        // عرض النتيجة
        StackPane root = new StackPane(text);
        Scene scene = new Scene(root, 700, 200);

        primaryStage.setTitle("DropShadow Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}