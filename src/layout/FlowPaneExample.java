/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application {

    @Override
    public void start(Stage stage) {

        // تحديد الفجوات الأفقية والعمودية
        double hgap = 5;
        double vgap = 10;

        // إنشاء الحاوية FlowPane مع تحديد الفجوات
        FlowPane root = new FlowPane(hgap, vgap);

        // إضافة 10 أزرار إلى الحاوية باستخدام حلقة تكرار
        for (int i = 1; i <= 10; i++) {
            root.getChildren().add(new Button("Button " + i));
        }

        // السطر التالي، إذا تم تفعيله، يغير اتجاه التدفق ليصبح عموديًا
        // root.setOrientation(Orientation.VERTICAL);

        // إنشاء المشهد ووضعه في النافذة
        Scene scene = new Scene(root);
        stage.setTitle("A Horizontal FlowPane");
        stage.setScene(scene);

        // *** هذا السطر مهم جدًا ***
        // تغيير اتجاه الواجهة ليكون من اليمين إلى اليسار (مناسب للعربية)
        stage.getScene().setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}