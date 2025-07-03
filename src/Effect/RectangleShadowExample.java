/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleShadowExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // إنشاء الشكل (مستطيل)
        Rectangle rect = new Rectangle(120, 70, Color.BLUEVIOLET);

        // إنشاء كائن تأثير الظل وتحديد خصائصه
        DropShadow dseffect = new DropShadow(); 
        dseffect.setRadius(10); 
        dseffect.setOffsetX(8); 
        dseffect.setOffsetY(10); 
        dseffect.setSpread(0.2); 
        dseffect.setBlurType(BlurType.TWO_PASS_BOX); 

        // تطبيق التأثير على المستطيل
        rect.setEffect(dseffect); 

        // إعداد الحاوية والنافذة للعرض
        StackPane root = new StackPane(rect);
        Scene scene = new Scene(root, 250, 200);

        primaryStage.setTitle("Lect05_Effects01");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}