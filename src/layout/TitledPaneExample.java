package layout;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TitledPaneExample extends Application {

    @Override
    public void start(Stage stage) {

        // 1. إنشاء عناصر نموذج الإدخال
        TextField firstNameFld = new TextField();
        firstNameFld.setPrefColumnCount(8);

        TextField lastNameFld = new TextField();
        lastNameFld.setPrefColumnCount(8);

        DatePicker dob = new DatePicker();
        dob.setPrefWidth(150);

        // 2. إنشاء شبكة (GridPane) لتنظيم عناصر النموذج
        GridPane grid = new GridPane();
        grid.addRow(0, new Label("First Name:"), firstNameFld);
        grid.addRow(1, new Label("Last Name:"), lastNameFld);
        grid.addRow(2, new Label("DOB:"), dob);
        grid.setVgap(10); // فجوة عمودية بين الصفوف

        // 3. إنشاء وإعداد TitledPane
        TitledPane infoPane = new TitledPane();
        
        infoPane.setText("Personal Info");       // تحديد عنوان اللوحة
        infoPane.setContent(grid);               // وضع الشبكة (النموذج) كمحتوى للوحة

        // --- التعديل هنا: استبدال الصورة بـ Label نصي ---
        Label iconAsText = new Label(" i "); // إنشاء ليبل كنص للأيقونة
        // إضافة بعض التنسيق لجعله يبدو كأيقونة
        iconAsText.setStyle("-fx-background-color: #007bff; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 50%;");
        infoPane.setGraphic(iconAsText);     // وضع الليبل كـ graphic في العنوان
        // --------------------------------------------------

        infoPane.setCollapsible(true);      // السماح للمستخدم بطي/فتح اللوحة
        infoPane.setExpanded(false);        // جعل اللوحة مطوية (مغلقة) عند بدء التشغيل

        // وضع اللوحة داخل حاوية أخرى للعرض
        HBox root = new HBox(infoPane);
        root.setPadding(new Insets(20)); // إضافة هامش خارجي

        Scene scene = new Scene(root); // تم إزالة الحجم الثابت لجعله يتكيف مع المحتوى
        stage.setTitle("Using TitledPane Controls");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}