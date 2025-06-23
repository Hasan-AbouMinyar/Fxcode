/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneLoginExample extends Application {

    @Override
    public void start(Stage stage) {

        // 1. إنشاء الحاوية الرئيسية GridPane
        GridPane root = new GridPane();

        // 2. إعداد خصائص الشبكة (المسافات والمحاذاة)
        root.setAlignment(Pos.CENTER); // جعل الشبكة كلها في منتصف النافذة
        root.setHgap(5);               // تحديد الفجوة الأفقية بين الأعمدة
        root.setVgap(5);               // تحديد الفجوة العمودية بين الصفوف
        root.setPadding(new Insets(20, 20, 20, 20)); // تحديد الهامش الداخلي

        // 3. إنشاء وإضافة العناصر إلى الشبكة
        // العنوان الرئيسي
        Label welcomeLabel = new Label("Welcome");
        welcomeLabel.setFont(Font.font("Tahoma", 24));
        root.add(welcomeLabel, 0, 0, 2,1 ); // (العنصر، عمود، صف، امتداد عمود، امتداد صف)
                                                 // هنا يمتد على عمودين وصف واحد

        // حقل اسم المستخدم
        Label usernameLabel = new Label("User Name:");
        root.add(usernameLabel, 0, 1); // الخلية: العمود 0, الصف 1
        TextField usernameField = new TextField("Your User Name");
        root.add(usernameField, 1, 1); // الخلية: العمود 1, الصف 1

        // حقل كلمة المرور
        Label passwordLabel = new Label("Password:");
        root.add(passwordLabel, 0, 2); // الخلية: العمود 0, الصف 2
        PasswordField passwordField = new PasswordField();
        root.add(passwordField, 1, 2); // الخلية: العمود 1, الصف 2

        // 4. إنشاء حاوية للأزرار ووضعها في الشبكة
        HBox buttonBox = new HBox(10); // HBox لوضع الأزرار بجانب بعضها
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT); // محاذاة الأزرار لليمين داخل الـ HBox
        Button loginBtn = new Button("Login");
        Button cancelBtn = new Button("Cancel");
        buttonBox.getChildren().addAll(loginBtn, cancelBtn);
        root.add(buttonBox, 1, 3); // وضع صندوق الأزرار كله في الخلية: العمود 1, الصف 3

        // إنشاء المشهد وعرضه
        Scene scene = new Scene(root, 400, 200);
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}