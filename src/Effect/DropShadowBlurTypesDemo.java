/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class DropShadowBlurTypesDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox(20); // ترتيب أفقي مع مسافة 20 بين المستطيلات
        root.setPadding(new Insets(20));

        // إنشاء 4 مستطيلات بأنواع تمويه مختلفة
        Rectangle rect1 = createRectWithShadow(BlurType.ONE_PASS_BOX, "ONE_PASS_BOX");
        Rectangle rect2 = createRectWithShadow(BlurType.TWO_PASS_BOX, "TWO_PASS_BOX");
        Rectangle rect3 = createRectWithShadow(BlurType.THREE_PASS_BOX, "THREE_PASS_BOX");
        Rectangle rect4 = createRectWithShadow(BlurType.GAUSSIAN, "GAUSSIAN");

        // إضافتهم إلى واجهة العرض
        root.getChildren().addAll(rect1, rect2, rect3, rect4);

        Scene scene = new Scene(root, 700, 200);
        primaryStage.setTitle("DropShadow - BlurType Comparison");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // دالة لإنشاء مستطيل مع DropShadow بنوع معين
    private Rectangle createRectWithShadow(BlurType blurType, String label) {
        Rectangle rect = new Rectangle(120, 100, Color.LIGHTBLUE);

        DropShadow shadow = new DropShadow();
        shadow.setBlurType(blurType);
        shadow.setRadius(15);
        shadow.setColor(Color.GRAY);
        shadow.setOffsetX(10);
        shadow.setOffsetY(10);
        rect.setEffect(shadow);

        return rect;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
