// هذا مجرد مثال توضيحي بسيط للغاية لكيفية بناء واجهة برمجياً في ملف واحد.
// لا يمثل تعقيد أو تصميم متجر Apple إطلاقاً وغير موصى به لمشروعك.
package ecommerce.store;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos; // لتوسيط العناصر

public class SimpleDiglobetalApp extends Application {

    private Label statusLabel; // لعرض حالة بسيطة كتفاعل

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ديقلوبيتال البسيط"); // عنوان النافذة

        // 1. إنشاء عناصر الواجهة برمجياً
        Label titleLabel = new Label("مرحباً في ديقلوبيتال!");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;"); // تطبيق نمط بسيط برمجياً

        ImageView productImageView = new ImageView();
        try {
             // حاول تحميل صورة بسيطة (تأكد أن لديك ملف logo.png في مسار الموارد الصحيح أو استخدم URL)
             Image logoImage = new Image(getClass().getResourceAsStream("/logo.png"));
             productImageView.setImage(logoImage);
             productImageView.setFitWidth(100);
             productImageView.setPreserveRatio(true);
        } catch (Exception e) {
             System.err.println("Failed to load image. Check /logo.png");
             // إذا فشل تحميل الصورة، استخدم مجرد Placeholder
             Label imagePlaceholder = new Label("[صورة المنتج هنا]");
             VBox imageBox = new VBox(imagePlaceholder);
             imageBox.setAlignment(Pos.CENTER);
             imageBox.setPrefSize(100, 100);
             // يمكنك إضافة imageBox بدلاً من productImageView في العناصر
        }


        Button viewDetailsButton = new Button("عرض تفاصيل المنتج");
        viewDetailsButton.setStyle("-fx-background-color: #007AFF; -fx-text-fill: white; -fx-font-size: 14px;"); // نمط زر بسيط

        statusLabel = new Label("اضغط على الزر لعرض التفاصيل الوهمية");
        statusLabel.setStyle("-fx-text-fill: #555555;");

        // 2. إضافة تفاعل للزر
        viewDetailsButton.setOnAction(event -> {
            // هذا هو التفاعل: تحديث الملصق عند النقر
            statusLabel.setText("تم النقر! (هذه مجرد محاكاة تفاعل بسيط)");

            // في تطبيق حقيقي معقد مثل متجر، هنا ستقوم بإنشاء واجهة تفاصيل منتج جديدة
            // وتعبئتها ببيانات المنتج، ثم تبديل المشهد في النافذة (Stage)
            // لكن فعل ذلك برمجياً بالكامل في نفس الملف سيجعل الكود طويلاً جداً ومعقداً
            // وسيتطلب إنشاء جميع عناصر واجهة صفحة التفاصيل هنا أيضاً.
        });

        // 3. ترتيب العناصر في لوحة تنسيق (Container)
        VBox root = new VBox(20); // تباعد 20 بين العناصر
        root.setAlignment(Pos.CENTER); // توسيط المحتوى في الوسط
        root.getChildren().addAll(titleLabel, productImageView, viewDetailsButton, statusLabel);
        root.setStyle("-fx-padding: 20px; -fx-background-color: #F5F5F7;"); // نمط خلفية وحشوة

        // 4. إنشاء المشهد (Scene) وتعيينه للنافذة (Stage)
        Scene scene = new Scene(root, 400, 300); // حجم النافذة

        // لا يمكن ربط ملف CSS منفصل هنا بشكل تقليدي،
        // الأنماط تم تطبيقها باستخدام setStyle() وهذا مرهق جداً للتصميم المعقد.
        // scene.getStylesheets().add("مسار/ملف.css"); // <-- هذا لا يعمل إذا كان كل شيء في ملف واحد

        primaryStage.setScene(scene);
        primaryStage.show(); // عرض النافذة
    }

    public static void main(String[] args) {
        launch(args); // بدء تطبيق JavaFX
    }
}