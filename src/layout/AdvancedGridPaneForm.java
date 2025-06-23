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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AdvancedGridPaneForm extends Application {

    @Override
    public void start(Stage stage) {

        // 1. إنشاء الحاوية الرئيسية GridPane
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        // 2. إنشاء العناصر
        // ليبل وحقل نص للاسم
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();

        // ليبل ومنطقة نص للوصف
        Label descLbl = new Label("Description:");
        TextArea descText = new TextArea();
        descText.setPrefColumnCount(20);
        descText.setPrefRowCount(5);

        // الأزرار
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // ليبل شريط الحالة
        Label statusBar = new Label("Status: Ready");

        // 3. إضافة العناصر إلى الشبكة مع تحديد أماكنها وامتدادها
        // (العنصر، العمود، الصف، امتداد الأعمدة، امتداد الصفوف)
        root.add(nameLbl, 0, 0, 1, 1);
        root.add(nameFld, 1, 0, 1, 1);
        root.add(descLbl, 0, 1, 1, 1);
        root.add(descText, 0, 2, 2, 1); // يمتد على عمودين (0 و 1)
        root.add(okBtn, 2, 0, 1, 1);
        root.add(cancelBtn, 2, 1, 1, 1);
        root.add(statusBar, 0, 3, 3, 1); // يمتد على 3 أعمدة (0, 1, 2)

        // 4. *** التحكم في تمدد ونمو العناصر (الجزء الأهم) ***

        // اجعل حقل الاسم يتمدد أفقيًا
        GridPane.setHgrow(nameFld, Priority.ALWAYS);

        // اجعل منطقة الوصف تتمدد عموديًا
        GridPane.setVgrow(descText, Priority.ALWAYS);
        
        // اجعل زر OK يملأ عرض خليته بالكامل
        okBtn.setMaxWidth(Double.MAX_VALUE);

        // إنشاء المشهد وعرضه
        Scene scene = new Scene(root);
        stage.setTitle("Creating Forms Using a GridPane");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}