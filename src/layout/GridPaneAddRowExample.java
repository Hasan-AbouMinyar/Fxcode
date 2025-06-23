/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneAddRowExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء العناصر
        Label fnameLbl = new Label("First Name:");
        TextField fnameFld = new TextField();
        Label lnameLbl = new Label("Last Name:");
        TextField lnameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // اجعل زر OK يملأ عرض خليته
        okBtn.setMaxWidth(Double.MAX_VALUE);

        // إنشاء حاوية GridPane
        GridPane root = new GridPane();

        // *** الخصائص المميزة في هذا المثال ***
        // 1. إظهار خطوط الشبكة (مفيدة جدًا للتصميم)
        root.setGridLinesVisible(true);

        // 2. تحديد الفجوات الأفقية والعمودية
        root.setHgap(10); // hgap = 10px
        root.setVgap(5);  // vgap = 5px

        // 3. استخدام CSS لتحديد هامش داخلي ولون خلفية
        root.setStyle("-fx-padding: 10; -fx-background-color: lightgray;");

        // *** إضافة صفوف كاملة من العناصر (الجزء المحدد) ***
        // إضافة الصف الأول (index = 0)
        root.addRow(0, fnameLbl, fnameFld, okBtn);

        // إضافة الصف الثاني (index = 1)
        root.addRow(1, lnameLbl, lnameFld, cancelBtn);

        // إنشاء المشهد وعرضه
        Scene scene = new Scene(root);
        stage.setTitle("Using hgap and vgap Properties for a GridPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}