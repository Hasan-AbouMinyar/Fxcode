package Shaps; // اسم الحزمة كما طلبت

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox; // نحتاج لاستيراد HBox لأن الكود يستخدمه كجذر
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

// يمكنك اختيار اسم للصنف، وليكن مثلاً ArcsExample
public class ArcsExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Arc Stage with 2D ");

        // إنشاء الأقواس المختلفة
        Arc A1 = new Arc(0, 0, 50, 100, 0, 90);
        A1.setFill(Color.LIGHTGRAY);

        Arc A2 = new Arc(0, 0, 50, 100, 0, 90);
        A2.setFill(Color.TRANSPARENT);
        A2.setStroke(Color.BLACK);

        Arc A3 = new Arc(0, 0, 50, 100, 0, 90);
        A3.setFill(Color.TRANSPARENT);
        A3.setStroke(Color.BLACK);
        A3.setType(ArcType.CHORD); // نوع الوتر

        Arc A4 = new Arc(0, 0, 50, 100, 0, 90);
        A4.setFill(Color.TRANSPARENT);
        A4.setStroke(Color.BLACK);
        A4.setType(ArcType.ROUND); // نوع دائري (مغلق بقطاع دائري)

        Arc A5 = new Arc(0, 0, 50, 100, 0, 90);
        A5.setFill(Color.GRAY);
        A5.setStroke(Color.BLACK);
        A5.setType(ArcType.ROUND); // نوع دائري آخر

        // استخدام HBox كجذر لتنظيم الأقواس أفقيًا
        HBox root = new HBox(A1, A2, A3, A4, A5);
        root.setSpacing(20); // مسافة بين العناصر في HBox

        Scene scene = new Scene(root, 400, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // الدالة الرئيسية لتشغيل التطبيق
    public static void main(String[] args) {
        launch(args);
    }
}