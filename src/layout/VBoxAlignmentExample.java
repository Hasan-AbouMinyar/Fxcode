/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxAlignmentExample extends Application {

    @Override
    public void start(Stage stage) {
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        VBox vbox = new VBox(10);

        // *** الأسطر المحددة ***
        // 1. تحديد الحجم المفضل لحاوية VBox نفسها
        vbox.setPrefSize(200, 100);

        // إضافة الأزرار إلى الحاوية
        vbox.getChildren().addAll(okBtn, cancelBtn);

        // 2. تعيين محاذاة العناصر ككتلة واحدة إلى الركن الأيمن السفلي
        vbox.setAlignment(Pos.BOTTOM_RIGHT);
        
        Scene scene = new Scene(vbox);
        stage.setTitle("Using VBox Alignment Property");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}