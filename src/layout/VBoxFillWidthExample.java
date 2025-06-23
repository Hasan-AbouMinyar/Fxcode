/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxFillWidthExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء أربعة أزرار
        Button b1 = new Button("New");
        Button b2 = new Button("New Modified");
        Button b3 = new Button("Not Modified");
        Button b4 = new Button("Data Modified");

        // *** الأسطر المحددة ***
        // تعيين أقصى عرض لكل زر إلى أكبر قيمة ممكنة
        // هذا يسمح لحاوية VBox بتمديد عرض الأزرار
        b1.setMaxWidth(Double.MAX_VALUE);
        b2.setMaxWidth(Double.MAX_VALUE);
        b3.setMaxWidth(Double.MAX_VALUE);
        b4.setMaxWidth(Double.MAX_VALUE);

        // إنشاء حاوية VBox مع مسافة 10 بكسل بين العناصر
        VBox root = new VBox(10, b1, b2, b3, b4);
        
        Scene scene = new Scene(root);
        stage.setTitle("Using VBox fillWidth Property");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}