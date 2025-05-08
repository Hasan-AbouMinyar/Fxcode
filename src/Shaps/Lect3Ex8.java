package Shaps; // تأكد أن اسم الحزمة (package) صحيح حسب تنظيم مشروعك

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Lect3Ex8 extends Application {

    // الدالة الرئيسية لتشغيل التطبيق
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();

        Rectangle rect1 = new Rectangle(25, 10, 60, 30);
        rect1.setStroke(Color.BLACK);
        rect1.setFill(Color.RED);
        root.getChildren().add(new Text(10,27, "r1"));
        root.getChildren().add(rect1);

        Rectangle rect2 = new Rectangle(25, 50, 60, 30);
        rect2.setStroke(Color.BLACK);
        rect2.setStrokeWidth(10);
        rect2.setFill(Color.TRANSPARENT);
        root.getChildren().add(new Text(10,67, "r2"));
        root.getChildren().add(rect2);

        Rectangle rect3 = new Rectangle(25, 90, 60, 30);
        rect3.setArcWidth(15);
        rect3.setArcHeight(25);
        rect3.setStroke(Color.BLACK);
        rect3.setFill(Color.YELLOW);
        root.getChildren().add(new Text(10,107, "r3"));
        root.getChildren().add(rect3);

        Rectangle rect4 = new Rectangle(30, 140, 60, 30);
        rect4.setStroke(Color.BLUE);
        rect4.setFill(Color.PINK);
        rect4.setStrokeWidth(15);
        rect4.setStrokeLineCap(StrokeLineCap.ROUND);
        rect4.getStrokeDashArray().addAll(5d, 30d);
        root.getChildren().add(new Text(10,157, "r4"));
        root.getChildren().add(rect4);

        Scene scene = new Scene(root, 320, 200);
        primaryStage.setTitle("ShowRectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}