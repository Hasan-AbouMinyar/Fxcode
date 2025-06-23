/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StackPaneExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء الدائرة الكبيرة (الخلفية)
        Circle circle = new Circle(40, 20, 100);
        circle.setFill(Color.DARKSLATEBLUE); // اللون الأزرق الداكن
        circle.setStroke(Color.BLACK); // إطار أسود

        // إنشاء الدائرة الصغيرة (الأمامية)
        Circle circle1 = new Circle(150, 70, 50);
        circle1.setFill(Color.GAINSBORO); // اللون الرمادي الفاتح
        circle1.setStroke(Color.BLACK);

        // إنشاء عنصر النص
        Text text = new Text("السلام عليكم ورحمة الله وبركاته");
        text.setFill(Color.CRIMSON); // اللون القرمزي

        // محاولة تحديد موقع النص يدوياً (سيتم تجاهلها بواسطة StackPane)
        text.setX(60);
        text.setY(300);

        // إنشاء حاوية StackPane
        StackPane stackPane = new StackPane();

        // إضافة هامش حول الدائرة الأولى
        StackPane.setMargin(circle, new Insets(50, 50, 50, 50));
        
        // إضافة العناصر إلى الحاوية بالترتيب (الأول في الأسفل، الأخير في الأعلى)
        stackPane.getChildren().addAll(circle, circle1, text);
        
        Scene scene = new Scene(stackPane);
        stage.setTitle("Stack Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}