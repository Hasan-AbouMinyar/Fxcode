/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Lect4Ex2 extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء العناصر
        TextField textField = new TextField();
        Button playButton = new Button("Play");
        Button stopButton = new Button("Stop");

        // إنشاء حاوية VBox
        VBox vBox = new VBox();
        
        // تحديد المسافة بين العناصر بـ 10 بكسل
        vBox.setSpacing(10);

        // تحديد الهوامش الخارجية لكل عنصر
        // هذا يضيف مساحة فارغة حول العنصر من جميع الجهات
        VBox.setMargin(textField, new Insets(20, 20, 20, 20));
        VBox.setMargin(playButton, new Insets(20, 20, 20, 20));
        VBox.setMargin(stopButton, new Insets(20, 20, 20, 20));

        // إضافة العناصر إلى الحاوية
        vBox.getChildren().addAll(textField, playButton, stopButton);

        // إنشاء المشهد ووضعه في النافذة
        Scene scene = new Scene(vBox);
        stage.setTitle("VBox Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}