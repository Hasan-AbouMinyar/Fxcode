/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AllOne;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ImagePatternExample extends Application {

    @Override
    public void start(Stage stage) {
        // الخطوة 1: تحميل الصورة
        Image img = new Image(getClass().getResource("button.jpg").toExternalForm());
         // يفترض وجود هذا الملف في المشروع

        // إنشاء نمط للمستطيل الأول (r2)
        ImagePattern p2 = new ImagePattern(img, 0, 0, 0.5, 0.5, true);
        Rectangle r2 = new Rectangle(100, 50);
        r2.setFill(p2);

        // إنشاء نمط للمستطيل الثاني (r1)
        ImagePattern p1 = new ImagePattern(img, 0, 0, 0.25, 0.25, true);
        Rectangle r1 = new Rectangle(100, 50);
        r1.setFill(p1);
        
        // إنشاء نمط للمثلث
        ImagePattern p3 = new ImagePattern(img, 0, 0, 0.25, 0.25, true);
        Polygon triangle = new Polygon(50, 0, 0, 50, 100, 50);
        triangle.setFill(p3);

        // إنشاء نمط للدائرة
        ImagePattern p4 = new ImagePattern(img, 0, 0, 0.1, 0.1, true);
        Circle c = new Circle(50, 50, 25);
        c.setFill(p4);

        // الخطوة 4: عرض الأشكال
        HBox root = new HBox();
        root.getChildren().addAll(r2, r1, triangle, c); // لاحظ ترتيب الإضافة
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Image Patterns");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
