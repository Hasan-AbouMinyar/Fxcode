/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxVGrowExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء المجموعة الأولى من العناصر
        Label descLbl1 = new Label("Description 1:");
        TextArea desc = new TextArea();
        desc.setPrefColumnCount(10);
        desc.setPrefRowCount(3); // تحديد ارتفاع مبدئي

        // إنشاء المجموعة الثانية من العناصر
        Label descLbl2 = new Label("Description 2:");
        TextArea desc1 = new TextArea();
        desc1.setPrefColumnCount(10);
        desc1.setPrefRowCount(3); // تحديد ارتفاع مبدئي

        // إنشاء حاوية VBox ووضع العناصر بداخلها
        VBox root = new VBox(10);
        root.getChildren().addAll(descLbl1, desc, descLbl2, desc1);

        // *** السطر المحدد: إعطاء أولوية النمو العمودي لمربع النص الأول ***
        // Let the TextArea desc grow vertically
        VBox.setVgrow(desc, Priority.ALWAYS);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Using Vertical Grow Priority in a VBox");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}