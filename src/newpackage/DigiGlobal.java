/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileNotFoundException; // استيراد لمعالجة خطأ عدم العثور على ملف
import java.nio.file.Paths; // استيراد لمساعدتنا في التعامل مع المسارات

public class DigiGlobal extends Application {

    // بيانات منتجات وهمية (يمكن استبدالها ببيانات حقيقية من قاعدة بيانات مثلاً)
    private static final Product[] sampleProducts = {
            new Product("iPhone 15 Pro", "product_iphone15pro.png", 4599.00),
            new Product("MacBook Pro M3", "product_macbookpro.png", 6999.00),
            new Product("Apple Watch Ultra 2", "product_watchultra2.png", 3299.00),
            new Product("AirPods Max", "product_airpodsmax.png", 2399.00),
            new Product("iPad Pro M4", "product_ipadpro.png", 4199.00),
            new Product("Apple Vision Pro", "product_visionpro.png", 14999.00),
            new Product("HomePod (2nd Gen)", "product_homepod.png", 1299.00),
            new Product("AirTag (4 Pack)", "product_airtag.png", 499.00),
            new Product("Magic Keyboard", "product_magickeyboard.png", 899.00),
            new Product("Apple TV 4K", "product_appletv.png", 649.00),
             new Product("Studio Display", "product_studiodisplay.png", 6999.00),
            new Product("Mac Mini M2", "product_macmini.png", 2499.00),
            // أضف المزيد من المنتجات هنا حسب الحاجة
    };

    // فئة بسيطة لتمثيل المنتج (بيانات المنتج)
    private static class Product {
        String name;
        String imagePath; // مسار الصورة (يفترض أنها في نفس المجلد أو مسار نسبي)
        double price;

        Product(String name, String imagePath, double price) {
            this.name = name;
            this.imagePath = imagePath;
            this.price = price;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("متجر ديقلوبيتال - Apple Style"); // عنوان النافذة
        primaryStage.setWidth(1200); // تحديد عرض مبدئي للنافذة
        primaryStage.setHeight(850); // تحديد ارتفاع مبدئي للنافذة

        // استخدام BorderPane كحاوية جذرية لتنظيم الرأس والوسط والذيل
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f5f5f7;"); // خلفية بيضاء/رمادية فاتحة للمظهر النظيف

        // 1. بناء قسم الرأس (Header)
        HBox header = new HBox(25); // مسافة 25 بكسل بين العناصر في الرأس
        header.setAlignment(Pos.CENTER_LEFT); // محاذاة العناصر لليسار عمودياً وفي الوسط أفقياً
        header.setPadding(new Insets(15, 30, 15, 30)); // هوامش داخلية (أعلى، يمين، أسفل، يسار)
        header.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 5, 0, 0, 1);"); // خلفية بيضاء، حد سفلي رمادي خفيف، وظل خفيف

        Label logo = new Label("ديقلوبيتال");
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 28)); // خط عريض وكبير للشعار
        logo.setStyle("-fx-text-fill: #333;"); // لون نص غامق
        // يمكنك إضافة EventHandler هنا لعمل حدث عند الضغط على الشعار (مثلاً العودة للصفحة الرئيسية)
        logo.setCursor(javafx.scene.Cursor.HAND); // مؤشر يد للدلالة على أنه قابل للتفاعل

        // روابط التنقل الرئيسية
        HBox navigation = new HBox(35); // مسافة أكبر بين روابط التنقل
        navigation.setAlignment(Pos.CENTER);
        String[] navItems = {"الرئيسية", "المنتجات", "العروض الخاصة", "الدعم الفني", "اتصل بنا"};
        for (String item : navItems) {
            Label navLabel = new Label(item);
            navLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); // خط عادي بحجم مناسب
            navLabel.setStyle("-fx-text-fill: #555; -fx-cursor: hand; -fx-padding: 5 0;"); // لون نص رمادي، مؤشر يد، وهوامش عمودية
            // إضافة تأثير المرور (Hover effect)
            navLabel.setOnMouseEntered(e -> navLabel.setStyle("-fx-text-fill: #007aff; -fx-underline: false; -fx-cursor: hand; -fx-padding: 5 0;")); // تغيير اللون عند المرور
            navLabel.setOnMouseExited(e -> navLabel.setStyle("-fx-text-fill: #555; -fx-underline: false; -fx-cursor: hand; -fx-padding: 5 0;")); // العودة للون الأصلي
            // يمكنك إضافة EventHandler هنا للتنقل بين صفحات المتجر فعلياً
            navigation.getChildren().add(navLabel);
        }

        // شريط البحث وأيقونة السلة
        HBox searchAndIcons = new HBox(15); // مسافة 15 بكسل بين حقل البحث والسلة
        searchAndIcons.setAlignment(Pos.CENTER_RIGHT);

        TextField searchField = new TextField();
        searchField.setPromptText("ابحث في المتجر..."); // نص توضيحي داخل الحقل
        searchField.setStyle("-fx-prompt-text-fill: #999; -fx-border-color: #d0d0d0; -fx-border-radius: 18; -fx-background-radius: 18; -fx-padding: 8 15; -fx-font-size: 15; -fx-background-color: #f8f8f8;"); // أنماط حقل البحث، زوايا مستديرة
        searchField.setPrefWidth(250); // عرض مفضل لحقل البحث

        Label cartIcon = new Label("🛒 (0)"); // استخدام رمز Unicode للسلة وعداد وهمي
        cartIcon.setFont(Font.font("Arial", FontWeight.NORMAL, 22)); // حجم الخط للأيقونة
        cartIcon.setStyle("-fx-text-fill: #555; -fx-cursor: hand;"); // لون رمادي ومؤشر يد
        // يمكنك إضافة EventHandler هنا لفتح صفحة السلة

        searchAndIcons.getChildren().addAll(searchField, cartIcon);

        // استخدام عنصر مرن (Spacer) لدفع مجموعات العناصر في الرأس
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS); // جعل الـ spacer يأخذ كل المساحة المتاحة

        // إضافة جميع العناصر إلى حاوية الرأس
        header.getChildren().addAll(logo, navigation, spacer, searchAndIcons);
        // وضع حاوية الرأس في المنطقة العلوية من BorderPane
        root.setTop(header);

        // 2. بناء قسم المحتوى الرئيسي (Center Area)
        // سنستخدم ScrollPane رئيسية تسمح بالتمرير لكامل المحتوى في الوسط
        ScrollPane mainScrollPane = new ScrollPane();
        mainScrollPane.setFitToWidth(true); // جعل محتوى التمرير يتناسب مع عرض الـ ScrollPane
        mainScrollPane.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;"); // إزالة خلفية وحدود الـ ScrollPane

        // VBox لتنظيم الأقسام المختلفة داخل منطقة المحتوى الرئيسية (البانر، قسم المنتجات، إلخ)
        VBox mainContentArea = new VBox(60); // مسافة كبيرة بين الأقسام
        mainContentArea.setAlignment(Pos.TOP_CENTER); // محاذاة المحتوى لأعلى وفي الوسط
        mainContentArea.setPadding(new Insets(40, 0, 60, 0)); // هوامش داخلية علوية وسفلية كبيرة

        // قسم البانر المميز (Featured Banner Section)
        VBox bannerSection = new VBox(15); // مسافة 15 بين عناصر البانر
        bannerSection.setAlignment(Pos.CENTER); // محاذاة عناصر البانر للوسط
        bannerSection.setPadding(new Insets(0, 50, 0, 50)); // هوامش أفقية

        Label bannerTitle = new Label("أحدث المنتجات المبتكرة");
        bannerTitle.setFont(Font.font("Arial", FontWeight.BOLD, 40)); // عنوان البانر كبير وعريض
        bannerTitle.setStyle("-fx-text-fill: #1a1a1a;"); // لون نص غامق

        Label bannerSubtitle = new Label("اكتشف عالمًا جديدًا من التكنولوجيا مع ديقلوبيتال");
        bannerSubtitle.setFont(Font.font("Arial", FontWeight.NORMAL, 22)); // عنوان فرعي بحجم مناسب
        bannerSubtitle.setStyle("-fx-text-fill: #444;"); // لون نص رمادي أغمق قليلاً

        // تحميل صورة البانر باستخدام الدالة المساعدة loadImageView
        // تأكد من وجود ملف banner_placeholder.png في نفس المجلد
        ImageView bannerImage = loadImageView("banner_placeholder.png", 900, 350); // حجم مفضل للبانر
        bannerImage.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 20, 0, 0, 8); -fx-background-radius: 10; -fx-border-radius: 10;"); // ظل وظلال مستديرة للصورة


        Button bannerButton = new Button("اكتشف الآن");
         bannerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
         bannerButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;");
         // تأثير المرور على زر البانر
          bannerButton.setOnMouseEntered(e -> bannerButton.setStyle("-fx-background-color: #005bb5; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));
          bannerButton.setOnMouseExited(e -> bannerButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));

        // إضافة عناصر البانر إلى حاويتها
        bannerSection.getChildren().addAll(bannerTitle, bannerSubtitle, bannerImage, bannerButton);


        // قسم عرض المنتجات في شبكة (Products Grid Section)
        VBox productsSection = new VBox(30); // مسافة بين عنوان القسم وشبكة المنتجات
        productsSection.setAlignment(Pos.TOP_CENTER);
        productsSection.setPadding(new Insets(0, 0, 0, 0)); // لا هوامش داخلية إضافية هنا لأنها ستكون في شبكة المنتجات

        Label productsTitle = new Label("منتجاتنا");
        productsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // عنوان قسم المنتجات
        productsTitle.setStyle("-fx-text-fill: #1a1a1a;");


        // شبكة المنتجات الفعلية
        GridPane productGrid = new GridPane();
        productGrid.setHgap(40); // مسافة أفقية بين المنتجات
        productGrid.setVgap(40); // مسافة عمودية بين المنتجات
        productGrid.setPadding(new Insets(0, 50, 0, 50)); // هوامش أفقية للشبكة للحفاظ على المسافة من الحواف
        productGrid.setAlignment(Pos.TOP_CENTER); // محاذاة الشبكة لأعلى ووسط

        int col = 0;
        int row = 0;
        int colsPerRow = 4; // عدد المنتجات في الصف الواحد (يمكن تغيير هذا الرقم)

        // إضافة بطاقات المنتجات إلى الشبكة
        for (Product product : sampleProducts) {
            VBox productCard = createProductCard(product); // إنشاء بطاقة المنتج باستخدام الدالة المساعدة
            productGrid.add(productCard, col, row); // إضافة البطاقة للشبكة في الموضع (عمود، صف)

            col++;
            if (col == colsPerRow) { // إذا وصلنا لنهاية الصف، ابدأ صفاً جديداً
                col = 0;
                row++;
            }
        }

        // إضافة عنوان قسم المنتجات وشبكة المنتجات إلى حاوية قسم المنتجات
        productsSection.getChildren().addAll(productsTitle, productGrid);

        // إضافة جميع الأقسام إلى حاوية المحتوى الرئيسية
        mainContentArea.getChildren().addAll(bannerSection, productsSection);

        // وضع حاوية المحتوى الرئيسية (القابلة للتمرير) في المنطقة الوسطى من BorderPane
        mainScrollPane.setContent(mainContentArea);
        root.setCenter(mainScrollPane);


        // 3. بناء قسم الذيل (Footer)
        VBox footer = new VBox(15); // مسافة بين العناصر في الذيل
        footer.setAlignment(Pos.CENTER); // محاذاة العناصر للوسط
        footer.setPadding(new Insets(30, 0, 30, 0)); // هوامش داخلية علوية وسفلية
        footer.setStyle("-fx-background-color: #e0e0e0;"); // خلفية رمادية فاتحة للذيل

        Label copyrightLabel = new Label("© 2023 ديقلوبيتال. جميع الحقوق محفوظة.");
        copyrightLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 15)); // خط عادي بحجم مناسب
        copyrightLabel.setStyle("-fx-text-fill: #555;"); // لون نص رمادي

        // يمكنك إضافة روابط أخرى للذيل هنا (مثلاً: سياسة الخصوصية، شروط الاستخدام، روابط التواصل الاجتماعي)
        // HBox footerLinks = new HBox(20);
        // footerLinks.setAlignment(Pos.CENTER);
        // Label privacy = new Label("سياسة الخصوصية"); privacy.setStyle("-fx-text-fill: #555; -fx-cursor: hand;"); ... add to footerLinks
        // Label terms = new Label("شروط الاستخدام"); terms.setStyle("-fx-text-fill: #555; -fx-cursor: hand;"); ... add to footerLinks
        // footerLinks.getChildren().addAll(privacy, terms); // أضف الروابط هنا
        // footer.getChildren().add(footerLinks); // أضف حاوية الروابط إلى الذيل

        // إضافة عنصر حقوق النشر إلى حاوية الذيل
        footer.getChildren().add(copyrightLabel);
        // وضع حاوية الذيل في المنطقة السفلية من BorderPane
        root.setBottom(footer);

        // إعداد المشهد والمسرح (Scene and Stage)
        Scene scene = new Scene(root); // إنشاء مشهد جديد باستخدام حاوية الجذر
        primaryStage.setScene(scene); // تعيين المشهد للمسرح (النافذة)
        primaryStage.show(); // عرض النافذة للمستخدم
    }

     // دالة مساعدة لتحميل الصور بشكل آمن من مسار ملف محلي
    // تتضمن معالجة الأخطاء واستخدام صورة بديلة
    private ImageView loadImageView(String imagePath, double fitWidth, double fitHeight) {
        ImageView imageView = new ImageView();
        Image image = null;
        try {
            // إنشاء مسار URI للملف المحلي
            // يفترض أن الملف موجود في نفس المجلد الذي يتم تشغيل الكود منه
            String uri = Paths.get(imagePath).toUri().toString();
            image = new Image(uri);

            // التحقق إذا كان هناك خطأ في تحميل الصورة باستخدام isError()
            if (image.isError()) {
                 System.err.println("Error loading image: " + imagePath + (image.getException() != null ? ", Details: " + image.getException().getMessage() : ""));
                 // في حالة وجود خطأ، حاول تحميل صورة بديلة
                 try {
                      // تأكد من وجود ملف placeholder.png في نفس المجلد
                      String placeholderUri = Paths.get("placeholder.png").toUri().toString();
                      image = new Image(placeholderUri);
                       // التحقق إذا كان هناك خطأ في تحميل الصورة البديلة أيضاً
                       if (image.isError()) {
                            System.err.println("Error loading placeholder image: placeholder.png" + (image.getException() != null ? ", Details: " + image.getException().getMessage() : ""));
                            // إذا فشل تحميل الصورة البديلة أيضاً، قم بتعيين الصورة إلى null
                             image = null;
                       }
                 } catch (Exception e) {
                      System.err.println("Exception trying to load placeholder image: " + e.getMessage());
                      image = null;
                 }
            }

        } catch (Exception e) {
            // معالجة أي استثناءات أخرى أثناء إنشاء المسار أو تحميل الصورة الأولية
            System.err.println("Exception loading image " + imagePath + ": " + e.getMessage());
             // حاول تحميل الصورة البديلة في حالة الاستثناء الأولي
             try {
                  String placeholderUri = Paths.get("placeholder.png").toUri().toString();
                  image = new Image(placeholderUri);
                   // التحقق إذا كان هناك خطأ في تحميل الصورة البديلة بعد الاستثناء
                   if (image.isError()) {
                        System.err.println("Error loading placeholder image after exception: placeholder.png" + (image.getException() != null ? ", Details: " + image.getException().getMessage() : ""));
                         image = null;
                   }
             } catch (Exception ex) {
                  System.err.println("Exception trying to load placeholder image after error: " + ex.getMessage());
                  image = null;
             }
        }

        // إذا تم تحميل صورة بنجاح (ليست null وليست بها أخطاء)
        if (image != null && !image.isError()) {
             imageView.setImage(image); // تعيين الصورة للـ ImageView
             imageView.setFitWidth(fitWidth); // تعيين العرض المناسب
             imageView.setFitHeight(fitHeight); // تعيين الارتفاع المناسب
             imageView.setPreserveRatio(true); // الحفاظ على نسبة الطول للعرض
        } else {
            // إذا فشل تحميل كل من الصورة الأصلية والبديلة
             System.err.println("Failed to load image: " + imagePath + " (and placeholder.png)");
             // يمكنك إضافة Label هنا بدلاً من الصورة المفقودة
             // مثال بسيط:
             // Label errorLabel = new Label("صورة\nغير متوفرة");
             // errorLabel.setAlignment(Pos.CENTER);
             // errorLabel.setStyle("-fx-border-color: #ccc; -fx-border-width: 1; -fx-text-fill: #888;");
             // errorLabel.setPrefSize(fitWidth, fitHeight);
             // StackPane placeholderPane = new StackPane(errorLabel); // استخدم StackPane لوضع النص في الوسط
             // placeholderPane.setPrefSize(fitWidth, fitHeight);
             // imageView.setImage(placeholderPane.snapshot(null, null)); // تحويل الـ StackPane إلى صورة (حل بديل)
             // أو يمكنك إضافة الـ placeholderPane مباشرة إلى VBox البطاقة وتخطي الـ ImageView

             // للحفاظ على الهيكل الحالي الذي يستخدم ImageView، نترك الـ ImageView بدون صورة ولكن نحدد حجمها
             imageView.setFitWidth(fitWidth);
             imageView.setFitHeight(fitHeight);
             imageView.setPreserveRatio(true); // لا يزال ضرورياً للحفاظ على المساحة
        }

        return imageView; // إرجاع الـ ImageView (مع الصورة أو فارغة)
    }


    // دالة مساعدة لإنشاء بطاقة منتج فردية
    private VBox createProductCard(Product product) {
        VBox card = new VBox(8); // مسافة 8 بكسل بين عناصر البطاقة
        card.setAlignment(Pos.TOP_CENTER); // محاذاة العناصر لأعلى وفي الوسط
        card.setPadding(new Insets(15)); // هوامش داخلية للبطاقة
        card.setPrefWidth(230); // عرض مفضل للبطاقة
        card.setMaxWidth(230); // تأكيد العرض الأقصى
        // أنماط البطاقة: خلفية بيضاء، زوايا مستديرة، ظل خفيف
        card.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 15; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 20, 0, 0, 8);");
        card.setCursor(javafx.scene.Cursor.HAND); // مؤشر يد للدلالة على أنه قابل للنقر/التفاعل

        // تأثير المرور (Hover effect) على البطاقة بأكملها
        card.setOnMouseEntered(e -> card.setStyle("-fx-background-color: #f8f8f8; -fx-border-radius: 15; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.15), 25, 0, 0, 10); -fx-cursor: hand;")); // تغيير طفيف في الخلفية والظل
        card.setOnMouseExited(e -> card.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 15; -fx-background-radius: 15; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 20, 0, 0, 8); -fx-cursor: hand;")); // العودة للوضع الأصلي

        // تحميل صورة المنتج باستخدام الدالة المساعدة loadImageView
        ImageView imageView = loadImageView(product.imagePath, 190, 190); // حجم مفضل لصورة المنتج داخل البطاقة
         VBox.setMargin(imageView, new Insets(0,0,5,0)); // مسافة سفلية صغيرة بعد الصورة

        Label nameLabel = new Label(product.name);
        nameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18)); // خط شبه عريض وحجم أكبر قليلاً للاسم
        nameLabel.setStyle("-fx-text-fill: #333;");
        nameLabel.setWrapText(true); // السماح بلف النص
        nameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER); // محاذاة النص في الوسط
        VBox.setVgrow(nameLabel, Priority.NEVER); // الاسم لا يأخذ مساحة عمودية إضافية

        Label priceLabel = new Label(String.format("%.2f ر.س", product.price)); // تنسيق السعر مع عملة
        priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20)); // خط عريض وحجم أكبر للسعر
        priceLabel.setStyle("-fx-text-fill: #007aff;"); // لون أزرق مميز
        VBox.setVgrow(priceLabel, Priority.ALWAYS); // يدفع زر "أضف للسلة" للأسفل إذا كان هناك مساحة إضافية

        Button addButton = new Button("أضف للسلة");
        addButton.setFont(Font.font("Arial", FontWeight.BOLD, 15)); // خط عريض وزر بحجم مناسب
        // أنماط الزر: خلفية زرقاء، نص أبيض، هوامش داخلية، زوايا مستديرة
        addButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 10 25; -fx-border-radius: 6; -fx-background-radius: 6; -fx-cursor: hand;");
        // تأثير المرور (Hover effect) على زر "أضف للسلة"
         addButton.setOnMouseEntered(e -> addButton.setStyle("-fx-background-color: #005bb5; -fx-text-fill: white; -fx-padding: 10 25; -fx-border-radius: 6; -fx-background-radius: 6; -fx-cursor: hand;")); // لون أزرق أغمق عند المرور
         addButton.setOnMouseExited(e -> addButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 10 25; -fx-border-radius: 6; -fx-background-radius: 6; -fx-cursor: hand;")); // العودة للون الأصلي

        // يمكنك إضافة EventHandler هنا لعملية إضافة المنتج للسلة فعلياً

        // إضافة جميع عناصر البطاقة إلى حاوية البطاقة (VBox)
        card.getChildren().addAll(imageView, nameLabel, priceLabel, addButton);

        return card; // إرجاع بطاقة المنتج
    }

    // دالة main لبدء تطبيق JavaFX
    public static void main(String[] args) {
        launch(args); // هذا السطر ضروري لبدء دورة حياة تطبيق JavaFX
    }
}