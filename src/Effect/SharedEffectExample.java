
package Effect;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SharedEffectExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // استخدام Pane لأنها تسمح بوضع العناصر في إحداثيات محددة
        Pane root = new Pane();

        // إنشاء عنصر النص وتحديد خصائصه
        Text text = new Text(50, 50, "Welcome to Lecture 7"); 
        text.setFont(Font.font("null", FontWeight.BOLD, 40)); 
        text.setFill(Color.DARKGREEN); 

        // إنشاء عنصر الدائرة وتحديد خصائصه
        Circle circle = new Circle(100.0, 150.0, 50.0);
        // لم يتم تحديد لون للدائرة في الصورة، لذلك سأتركها باللون الأسود الافتراضي

        // إنشاء كائن DropShadow واحد فقط
        DropShadow dropShadow = new DropShadow(); 
        dropShadow.setRadius(5); 
        dropShadow.setOffsetX(8); 
        dropShadow.setOffsetY(4); 
        dropShadow.setColor(Color.CORNSILK); 

        // تطبيق نفس كائن التأثير على كلا العنصرين
        text.setEffect(dropShadow); 
        circle.setEffect(dropShadow); 

        // إضافة العناصر إلى الحاوية وعرضها
        root.getChildren().addAll(circle, text); 
        Scene scene = new Scene(root, 600, 300); 
        primaryStage.setTitle("Drop Shadow effect example"); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}