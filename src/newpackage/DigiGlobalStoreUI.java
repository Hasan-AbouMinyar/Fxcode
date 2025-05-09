
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

import java.nio.file.Paths;

public class DigiGlobalStoreUI extends Application {

    // بيانات منتجات وهمية (يمكن استبدالها ببيانات حقيقية من قاعدة بيانات مثلاً)
    // تم إضافة حقل الوصف
    private static final Product[] sampleProducts = {
            new Product("iPhone 15 Pro", "product_iphone15pro.png", 4599.00, "أقوى آيفون حتى الآن. مزود بشريحة A17 Pro الخارقة، نظام كاميرات احترافي، وهيكل متين من التيتانيوم."),
            new Product("MacBook Pro M3", "product_macbookpro.png", 6999.00, "قوة خارقة مع شريحة M3 Pro أو M3 Max. شاشة Liquid Retina XDR مذهلة وعمر بطارية لا يصدق."),
            new Product("Apple Watch Ultra 2", "product_watchultra2.png", 3299.00, "ساعة رياضية متينة للمغامرات. GPS دقيق ثنائي التردد، عمر بطارية طويل، وميزات متقدمة للرياضيين والغواصين."),
            new Product("AirPods Max", "product_airpodsmax.png", 2399.00, "تجربة صوتية غامرة وعالية الدقة. عزل ضوضاء نشط، شفافية، وصوت مكاني مع تتبع ديناميكي للرأس."),
            new Product("iPad Pro M4", "product_ipadpro.png", 4199.00, "أنحف جهاز Apple على الإطلاق وأكثرها قوة مع شريحة M4. شاشة Ultra Retina XDR مذهلة."),
            new Product("Apple Vision Pro", "product_visionpro.png", 14999.00, "حاسوب مكاني ثوري يدمج المحتوى الرقمي مع العالم الحقيقي بسلاسة."),
            new Product("HomePod (2nd Gen)", "product_homepod.png", 1299.00, "مكبر صوت ذكي قوي يوفر صوتاً غنياً وعميقاً. يعمل كمحور منزلي ذكي."),
            new Product("AirTag (4 Pack)", "product_airtag.png", 499.00, "تتبع أغراضك بسهولة ودقة باستخدام شبكة تحديد الموقع."),
            new Product("Magic Keyboard", "product_magickeyboard.png", 899.00, "تجربة كتابة مريحة ودقيقة مع لوحة تعقب مدمجة. مثالية لجهاز iPad Pro و iPad Air."),
            new Product("Apple TV 4K", "product_appletv.png", 649.00, "استمتع بأفضل محتوى ترفيهي بدقة 4K HDR مع صوت Dolby Atmos. مدعوم بشريحة قوية."),
             new Product("Studio Display", "product_studiodisplay.png", 6999.00, "شاشة 27 إنش 5K Retina مذهلة مع كاميرا مركز المسرح ونظام صوتي بستة مكبرات."),
            new Product("Mac Mini M2", "product_macmini.png", 2499.00, "قوة فائقة وحجم مدمج. مزود بشريحة M2 أو M2 Pro لأداء مذهل في مهامك اليومية والاحترافية."),
             new Product("Apple Mouse", "product_mouse.png", 399.00, "تصميم لاسلكي أنيق وسطح Multi-Touch. تجربة استخدام سلسة مع أجهزة Mac."),
             new Product("Apple Keyboard", "product_keyboard.png", 499.00, "لوحة مفاتيح لاسلكية مريحة ودقيقة. تصميم نحيف وبطارية تدوم طويلاً."),
    };

    // فئة بسيطة لتمثيل المنتج
    private static class Product {
        String name;
        String imagePath;
        double price;
        String description;

        Product(String name, String imagePath, double price, String description) {
            this.name = name;
            this.imagePath = imagePath;
            this.price = price;
            this.description = description;
        }
    }

    // بيانات عناصر السلة الوهمية (يمكن استبدالها بـ ObservableList في تطبيق حقيقي)
    private static final Product[] sampleCartItems = {
         sampleProducts[0], // iPhone 15 Pro
         sampleProducts[3], // AirPods Max
         sampleProducts[sampleProducts.length - 1], // Apple Keyboard
    };
    private static int[] sampleCartQuantities = {1, 2, 1}; // كميات وهمية

    // متغيرات لتخزين واجهات الأقسام الرئيسية للتبديل بينها وللوصول إليها من دوال مختلفة
    private BorderPane root;
    private ScrollPane mainScrollPane; // الحاوية الرئيسية القابلة للتمرير للمحتوى الوسطي (تشمل البانر وقائمة المنتجات)
    // لا نحتاج لمتغير خاص بصفحة التفاصيل أو السلة لأننا سنعيد بناءها كل مرة أو نضعها مباشرة في Center

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("متجر ديقلوبيتال - Apple Style"); // عنوان النافذة
        primaryStage.setWidth(1200); // تحديد عرض مبدئي للنافذة
        primaryStage.setHeight(850); // تحديد ارتفاع مبدئي للنافذة

        // استخدام BorderPane كحاوية جذرية لتنظيم الرأس والوسط والذيل
        root = new BorderPane(); // تم تعريفها كمتغير على مستوى الفئة
        root.setStyle("-fx-background-color: #f5f5f7;"); // خلفية بيضاء/رمادية فاتحة للمظهر النظيف

        // 1. بناء قسم الرأس (Header)
        HBox header = new HBox(25); // مسافة 25 بكسل بين العناصر في الرأس
        header.setAlignment(Pos.CENTER_LEFT); // محاذاة العناصر لليسار عمودياً وفي الوسط أفقياً
        header.setPadding(new Insets(15, 30, 15, 30)); // هوامش داخلية (أعلى، يمين، أسفل، يسار)
        header.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.05), 5, 0, 0, 1);"); // خلفية بيضاء، حد سفلي رمادي خفيف، وظل خفيف

        Label logo = new Label("ديقلوبيتال");
        logo.setFont(Font.font("Arial", FontWeight.BOLD, 28)); // خط عريض وكبير للشعار
        logo.setStyle("-fx-text-fill: #333;"); // لون نص غامق
        logo.setCursor(javafx.scene.Cursor.HAND); // مؤشر يد للدلالة على أنه قابل للتفاعل
        // حدث عند الضغط على الشعار (العودة للصفحة الرئيسية/قائمة المنتجات)
        logo.setOnMouseClicked(e -> showProductsGrid());


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

            // حدث عند الضغط على رابط "المنتجات" (يعرض قائمة المنتجات)
            if (item.equals("المنتجات") || item.equals("الرئيسية")) { // يمكن جعل "الرئيسية" و "المنتجات" يعرضان نفس الصفحة في هذا المثال
                 navLabel.setOnMouseClicked(e -> showProductsGrid());
            }
             // يمكنك إضافة EventHandler هنا لباقي الروابط للتنقل بين صفحات المتجر فعلياً (يتطلب بناء تلك الصفحات)

            navigation.getChildren().add(navLabel);
        }

        // شريط البحث وأيقونة السلة
        HBox searchAndIcons = new HBox(15); // مسافة 15 بكسل بين حقل البحث والسلة
        searchAndIcons.setAlignment(Pos.CENTER_RIGHT);

        TextField searchField = new TextField();
        searchField.setPromptText("ابحث في المتجر..."); // نص توضيحي داخل الحقل
        searchField.setStyle("-fx-prompt-text-fill: #999; -fx-border-color: #d0d0d0; -fx-border-radius: 18; -fx-background-radius: 18; -fx-padding: 8 15; -fx-font-size: 15; -fx-background-color: #f8f8f8;"); // أنماط حقل البحث، زوايا مستديرة
        searchField.setPrefWidth(250); // عرض مفضل لحقل البحث

        Label cartIcon = new Label("🛒 (" + sampleCartItems.length + ")"); // استخدام رمز Unicode وعدد عناصر السلة الوهمي
        cartIcon.setFont(Font.font("Arial", FontWeight.NORMAL, 22)); // حجم الخط للأيقونة
        cartIcon.setStyle("-fx-text-fill: #555; -fx-cursor: hand;"); // لون رمادي ومؤشر يد
        // *** إضافة حدث عند الضغط على أيقونة السلة لعرض صفحة السلة ***
        cartIcon.setOnMouseClicked(e -> showCartView());


        searchAndIcons.getChildren().addAll(searchField, cartIcon);

        // استخدام عنصر مرن (Spacer) لدفع مجموعات العناصر في الرأس
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS); // جعل الـ spacer يأخذ كل المساحة المتاحة

        // إضافة جميع العناصر إلى حاوية الرأس
        header.getChildren().addAll(logo, navigation, spacer, searchAndIcons);
        // وضع حاوية الرأس في المنطقة العلوية من BorderPane
        root.setTop(header);

        // 2. بناء قسم المحتوى الرئيسي (Center Area)
        // سيتم بناء هذا القسم داخل دالة منفصلة showProductsGrid لعرضه وتبديله
        showProductsGrid(); // عرض قائمة المنتجات كواجهة مبدئية عند بدء التشغيل


        // 3. بناء قسم الذيل (Footer)
        VBox footer = new VBox(15); // مسافة بين العناصر في الذيل
        footer.setAlignment(Pos.CENTER); // محاذاة العناصر للوسط
        footer.setPadding(new Insets(30, 0, 30, 0)); // هوامش داخلية علوية وسفلية
        footer.setStyle("-fx-background-color: #e0e0e0;"); // خلفية رمادية فاتحة للذيل

        Label copyrightLabel = new Label("© 2023 ديقلوبيتال. جميع الحقوق محفوظة.");
        copyrightLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 15)); // خط عادي بحجم مناسب
        copyrightLabel.setStyle("-fx-text-fill: #555;"); // لون نص رمادي

        // يمكنك إضافة روابط أخرى للذيل هنا
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

    // --- دوال مساعدة لبناء وعرض المحتوى المختلف (محاكاة التنقل) ---

    // دالة لعرض قائمة المنتجات في الشبكة
    private void showProductsGrid() {
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
        ImageView bannerImage = loadImageView("banner_placeholder.png", 900, 350); // حجم مفضل للبانر
        bannerImage.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 20, 0, 0, 8); -fx-background-radius: 10; -fx-border-radius: 10;"); // ظل وظلال مستديرة للصورة

        Button bannerButton = new Button("اكتشف الآن");
        bannerButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        bannerButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;");
        // تأثير المرور على زر البانر
        bannerButton.setOnMouseEntered(e -> bannerButton.setStyle("-fx-background-color: #005bb5; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));
        bannerButton.setOnMouseExited(e -> bannerButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));
         // حدث عند الضغط على زر البانر (التمرير لقسم المنتجات)
         bannerButton.setOnMouseClicked(e -> scrollToProductsSection(mainContentArea));

        // إضافة عناصر البانر إلى حاويتها
        bannerSection.getChildren().addAll(bannerTitle, bannerSubtitle, bannerImage, bannerButton);


        // قسم عرض المنتجات في شبكة (Products Grid Section)
        VBox productsSection = new VBox(30); // مسافة بين عنوان القسم وشبكة المنتجات
        productsSection.setAlignment(Pos.TOP_CENTER);
        productsSection.setPadding(new Insets(0, 0, 0, 0));

        Label productsTitle = new Label("منتجاتنا");
        productsTitle.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // عنوان قسم المنتجات
        productsTitle.setStyle("-fx-text-fill: #1a1a1a;");


        // شبكة المنتجات الفعلية
        GridPane productGrid = new GridPane();
        productGrid.setHgap(40); // مسافة أفقية بين المنتجات
        productGrid.setVgap(40); // مسافة عمودية بين المنتجات
        productGrid.setPadding(new Insets(0, 50, 0, 50)); // هوامش أفقية للشبكة للحفاظ على المسافة من الحواف
        productGrid.setAlignment(Pos.TOP_CENTER);

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
        // تخزين ScrollPane الرئيسية في متغير الفئة للتبديل إليها لاحقاً
        mainScrollPane = new ScrollPane(mainContentArea); // تم تعيين mainScrollPane هنا
        mainScrollPane.setFitToWidth(true);
        mainScrollPane.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;"); // إزالة خلفية وحدود الـ ScrollPane

        root.setCenter(mainScrollPane); // عرض واجهة قائمة المنتجات في وسط الـ BorderPane
    }

     // دالة مساعدة للتمرير إلى قسم المنتجات (عند الضغط على زر البانر مثلاً)
     // تستقبل VBox المحتوى الرئيسي كمعامل
     private void scrollToProductsSection(VBox parentContentArea) {
         // هذا الحساب تقديري، ويعتمد على أن البانر هو أول عنصر في parentContentArea
         double bannerHeightEstimate = 350 + 40 + 22 + 15 + 12 + 60; // ارتفاع صورة البانر + ارتفاع العناوين والمسافات
         // نحتاج التأكد أن الـ parentContentArea قد تم تخطيطها لحساب ارتفاعها بشكل صحيح
         javafx.application.Platform.runLater(() -> {
              if(parentContentArea.getHeight() > 0) {
                  mainScrollPane.setVvalue(bannerHeightEstimate / parentContentArea.getHeight()); // التمرير إلى هذا الموضع التقريبي بناءً على ارتفاع المحتوى الكلي
              } else {
                  // محاولة تعيين قيمة ثابتة كحل بديل إذا لم يتم حساب الارتفاع بعد
                  mainScrollPane.setVvalue(0.5); // مثال: التمرير لمنتصف المحتوى
              }
         });

     }


    // دالة لعرض تفاصيل منتج محدد
    private void showProductDetails(Product product) {
        // VBox لتنظيم عناصر صفحة تفاصيل المنتج
        VBox productDetailView = new VBox(20); // مسافة 20 بكسل بين العناصر
        productDetailView.setAlignment(Pos.TOP_CENTER); // محاذاة المحتوى لأعلى وفي الوسط
        productDetailView.setPadding(new Insets(40, 50, 40, 50)); // هوامش داخلية كبيرة
        productDetailView.setStyle("-fx-background-color: #ffffff;"); // خلفية بيضاء لصفحة التفاصيل

        // زر العودة لقائمة المنتجات
        Button backButton = new Button("← العودة للمنتجات");
        backButton.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #007aff; -fx-border-color: transparent; -fx-cursor: hand;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #005bb5; -fx-underline: true; -fx-border-color: transparent; -fx-cursor: hand;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #007aff; -fx-underline: false; -fx-border-color: transparent; -fx-cursor: hand;"));
        backButton.setOnMouseClicked(e -> showProductsGrid()); // عند الضغط، أعد عرض قائمة المنتجات

        HBox backButtonContainer = new HBox(backButton);
        backButtonContainer.setAlignment(Pos.TOP_LEFT); // محاذاة زر العودة لليسار
         VBox.setMargin(backButtonContainer, new Insets(0,0,20,0)); // مسافة سفلية بعد زر العودة


        // تفاصيل المنتج (صورة، اسم، سعر، وصف)
        ImageView productImageView = loadImageView(product.imagePath, 350, 350); // صورة أكبر للمنتج
        productImageView.setStyle("-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 15, 0, 0, 5); -fx-background-radius: 8; -fx-border-radius: 8;");


        Label nameLabel = new Label(product.name);
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 36)); // اسم المنتج كبير جداً وعريض
        nameLabel.setStyle("-fx-text-fill: #1a1a1a;");
        nameLabel.setWrapText(true); // السماح بلف النص
        nameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);

        Label priceLabel = new Label(String.format("%.2f ر.س", product.price)); // السعر
        priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30)); // سعر كبير وعريض
        priceLabel.setStyle("-fx-text-fill: #007aff;");

        Label descriptionTitle = new Label("نظرة عامة:"); // عنوان لقسم الوصف
         descriptionTitle.setFont(Font.font("Arial", FontWeight.BOLD, 22));
         descriptionTitle.setStyle("-fx-text-fill: #333;");
         VBox.setMargin(descriptionTitle, new Insets(20,0,0,0)); // مسافة علوية قبل عنوان الوصف


        Label descriptionLabel = new Label(product.description); // الوصف
        descriptionLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18)); // وصف بحجم عادي
        descriptionLabel.setStyle("-fx-text-fill: #444;");
        descriptionLabel.setWrapText(true);
        descriptionLabel.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT); // محاذاة الوصف لليمين (مناسب للغة العربية)
        descriptionLabel.setMaxWidth(900); // تحديد عرض أقصى للوصف

        Button addToCartButton = new Button("أضف للسلة");
        addToCartButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        addToCartButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;");
         // تأثير المرور على زر أضف للسلة هنا أيضاً
         addToCartButton.setOnMouseEntered(e -> addToCartButton.setStyle("-fx-background-color: #005bb5; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));
         addToCartButton.setOnMouseExited(e -> addToCartButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));

         VBox buttonContainer = new VBox(addToCartButton);
         buttonContainer.setAlignment(Pos.CENTER); // توسيط الزر في حاويته
         VBox.setMargin(buttonContainer, new Insets(30,0,0,0)); // مسافة علوية قبل الزر


        // تجميع كل عناصر صفحة التفاصيل في ScrollPane للسماح بالتمرير إذا كان الوصف طويلاً
        VBox contentBox = new VBox(25); // مسافة بين الصورة ومربع التفاصيل
        contentBox.setAlignment(Pos.TOP_CENTER);
        contentBox.getChildren().addAll(productImageView, nameLabel, priceLabel, descriptionTitle, descriptionLabel, buttonContainer); // إضافة جميع العناصر هنا

        ScrollPane detailScrollPane = new ScrollPane(contentBox);
        detailScrollPane.setFitToWidth(true);
        detailScrollPane.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        detailScrollPane.setPadding(new Insets(0, 0, 0, 0));


        // إضافة زر العودة و ScrollPane التفاصيل إلى VBox الرئيسية لصفحة التفاصيل
        productDetailView.getChildren().addAll(backButtonContainer, detailScrollPane);


        // تعيين واجهة تفاصيل المنتج الجديدة كالمحتوى المركزي للـ BorderPane
        root.setCenter(productDetailView);
         // التأكد من التمرير لأعلى الصفحة الجديدة
         detailScrollPane.setVvalue(0.0);
    }

    // *** دالة جديدة لعرض واجهة سلة المشتريات (محاكاة) ***
    private void showCartView() {
        VBox cartView = new VBox(20); // مسافة بين العناصر في صفحة السلة
        cartView.setAlignment(Pos.TOP_CENTER); // محاذاة المحتوى لأعلى وفي الوسط
        cartView.setPadding(new Insets(40, 50, 40, 50)); // هوامش داخلية كبيرة
        cartView.setStyle("-fx-background-color: #ffffff;"); // خلفية بيضاء لصفحة السلة

        // زر العودة لقائمة المنتجات
        Button backButton = new Button("← العودة للمنتجات");
        backButton.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #007aff; -fx-border-color: transparent; -fx-cursor: hand;");
        backButton.setOnMouseEntered(e -> backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #005bb5; -fx-underline: true; -fx-border-color: transparent; -fx-cursor: hand;"));
        backButton.setOnMouseExited(e -> backButton.setStyle("-fx-background-color: transparent; -fx-text-fill: #007aff; -fx-underline: false; -fx-border-color: transparent; -fx-cursor: hand;"));
        backButton.setOnMouseClicked(e -> showProductsGrid()); // عند الضغط، أعد عرض قائمة المنتجات

        HBox backButtonContainer = new HBox(backButton);
        backButtonContainer.setAlignment(Pos.TOP_LEFT);
        VBox.setMargin(backButtonContainer, new Insets(0,0,20,0));


        Label cartTitle = new Label("سلة المشتريات"); // عنوان صفحة السلة
        cartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        cartTitle.setStyle("-fx-text-fill: #1a1a1a;");


        // بناء قائمة عناصر السلة (وهمية)
        VBox cartItemsList = new VBox(15); // مسافة بين عناصر السلة
        cartItemsList.setAlignment(Pos.TOP_CENTER);
        cartItemsList.setPadding(new Insets(20, 0, 20, 0));
        cartItemsList.setStyle("-fx-border-color: #eee; -fx-border-width: 1 0 1 0;"); // حد علوي وسفلي للقائمة

        double total = 0;
        if (sampleCartItems.length == 0) {
            Label emptyCartLabel = new Label("سلة المشتريات فارغة.");
            emptyCartLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 18));
            emptyCartLabel.setStyle("-fx-text-fill: #666;");
            cartItemsList.getChildren().add(emptyCartLabel);
        } else {
            for (int i = 0; i < sampleCartItems.length; i++) {
                Product item = sampleCartItems[i];
                int quantity = sampleCartQuantities[i];
                double itemTotal = item.price * quantity;
                total += itemTotal;

                // بناء صف لكل عنصر في السلة
                HBox cartItemRow = new HBox(20); // مسافة بين عناصر الصف الواحد
                cartItemRow.setAlignment(Pos.CENTER_LEFT);
                cartItemRow.setPrefWidth(600); // عرض مفضل لصف العنصر (يمكن تعديله)
                cartItemRow.setMaxWidth(800); // عرض أقصى لصف العنصر
                //cartItemRow.setStyle("-fx-border-color: #eee; -fx-border-width: 0 0 1 0;"); // حد سفلي لكل صف (اختياري)

                 ImageView itemImage = loadImageView(item.imagePath, 50, 50); // صورة مصغرة للمنتج في السلة

                 Label itemName = new Label(item.name);
                 itemName.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 16));
                 itemName.setStyle("-fx-text-fill: #333;");
                 itemName.setPrefWidth(200); // عرض مفضل لاسم المنتج
                 itemName.setWrapText(true);

                 Label itemQuantity = new Label("الكمية: " + quantity);
                 itemQuantity.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
                 itemQuantity.setStyle("-fx-text-fill: #555;");
                 itemQuantity.setPrefWidth(80);

                 Label itemPrice = new Label(String.format("%.2f ر.س", itemTotal));
                 itemPrice.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                 itemPrice.setStyle("-fx-text-fill: #007aff;");
                 HBox.setHgrow(itemPrice, Priority.ALWAYS); // يدفع السعر للأخير

                 // يمكنك إضافة أزرار لزيادة/تقليل الكمية أو إزالة العنصر هنا

                 cartItemRow.getChildren().addAll(itemImage, itemName, itemQuantity, itemPrice);
                 cartItemsList.getChildren().add(cartItemRow); // إضافة الصف للقائمة

            }
        }


        // ملخص السلة والمجموع الكلي
        VBox cartSummary = new VBox(10);
        cartSummary.setAlignment(Pos.CENTER_RIGHT); // محاذاة الملخص لليمين
        cartSummary.setPadding(new Insets(20, 0, 0, 0));

        Label totalLabel = new Label(String.format("المجموع الكلي: %.2f ر.س", total));
        totalLabel.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        totalLabel.setStyle("-fx-text-fill: #1a1a1a;");


        Button checkoutButton = new Button("إتمام الشراء"); // زر إتمام الشراء
        checkoutButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        checkoutButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"); // لون أخضر للموافقة/الشراء
        // تأثير المرور على زر إتمام الشراء
         checkoutButton.setOnMouseEntered(e -> checkoutButton.setStyle("-fx-background-color: #218838; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));
         checkoutButton.setOnMouseExited(e -> checkoutButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-padding: 12 30; -fx-border-radius: 8; -fx-background-radius: 8; -fx-cursor: hand;"));
         // يمكنك إضافة EventHandler هنا لعملية إتمام الشراء فعلياً


        cartSummary.getChildren().addAll(totalLabel, checkoutButton);


        // تجميع عناصر صفحة السلة في ScrollPane للسماح بالتمرير
        VBox cartContent = new VBox(30); // مسافة بين قائمة العناصر والملخص
        cartContent.setAlignment(Pos.TOP_CENTER);
        cartContent.getChildren().addAll(cartTitle, cartItemsList, cartSummary);

        ScrollPane cartScrollPane = new ScrollPane(cartContent);
        cartScrollPane.setFitToWidth(true);
        cartScrollPane.setStyle("-fx-background-color: transparent; -fx-border-color: transparent;");
        cartScrollPane.setPadding(new Insets(0, 0, 0, 0));


        // إضافة زر العودة و ScrollPane السلة إلى VBox الرئيسية لصفحة السلة
        cartView.getChildren().addAll(backButtonContainer, cartScrollPane);


        // تعيين واجهة السلة الجديدة كالمحتوى المركزي للـ BorderPane
        root.setCenter(cartView);
        // التأكد من التمرير لأعلى الصفحة الجديدة
        cartScrollPane.setVvalue(0.0);
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
             // لعرض مساحة بديلة بالحجم المطلوب حتى لو لم يتم تحميل الصورة
             imageView.setFitWidth(fitWidth);
             imageView.setFitHeight(fitHeight);
             imageView.setPreserveRatio(true);
             // يمكنك إضافة رسمة بسيطة أو نص هنا إذا أردت أن يظهر شيء في مكان الصورة المفقودة
             // imageView.setStyle("-fx-border-color: #ccc; -fx-border-width: 1;"); // مثال: إضافة حد لرؤية المساحة
        }

        return imageView; // إرجاع الـ ImageView (مع الصورة أو فارغة)
    }


    // دالة مساعدة لإنشاء بطاقة منتج فردية (تم إضافة حدث الضغط لعرض التفاصيل)
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

        // *** إضافة حدث عند الضغط على البطاقة لعرض تفاصيل المنتج ***
        // نستخدم runLater للتأكد أن التبديل للواجهة يحدث بعد اكتمال حدث الضغط
        card.setOnMouseClicked(e -> javafx.application.Platform.runLater(() -> showProductDetails(product)));


        // تحميل صورة المنتج باستخدام الدالة المساعدة loadImageView
        ImageView imageView = loadImageView(product.imagePath, 190, 190); // حجم مفضل لصورة المنتج داخل البطاقة
         VBox.setMargin(imageView, new Insets(0,0,5,0)); // مسافة سفلية صغيرة بعد الصورة

        Label nameLabel = new Label(product.name);
        nameLabel.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 18)); // خط شبه عريض وحجم أكبر قليلاً للاسم
        nameLabel.setStyle("-fx-text-fill: #333;");
        nameLabel.setWrapText(true); // السماح بلف النص
        nameLabel.setTextAlignment(javafx.scene.text.TextAlignment.CENTER); // محاذاة النص في الوسط
        nameLabel.setMaxHeight(45); // تحديد أقصى ارتفاع (2-3 أسطر تقريباً)
        VBox.setVgrow(nameLabel, Priority.NEVER); // الاسم لا يأخذ مساحة عمودية إضافية

        Label priceLabel = new Label(String.format("%.2f ر.س", product.price)); // تنسيق السعر مع عملة
        priceLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20)); // خط عريض وحجم أكبر للسعر
        priceLabel.setStyle("-fx-text-fill: #007aff;"); // لون أزرق مميز
         VBox.setMargin(priceLabel, new Insets(5,0,10,0)); // هوامش حول السعر
        VBox.setVgrow(priceLabel, Priority.ALWAYS); // يدفع زر "أضف للسلة" للأسفل إذا كان هناك مساحة إضافية


        // زر أضف للسلة (يبقى داخل الكرت أيضاً، ولكن الضغط على الكرت كله ينقلك للتفاصيل)
        Button addButton = new Button("أضف للسلة");
        addButton.setFont(Font.font("Arial", FontWeight.BOLD, 15)); // خط عريض وزر بحجم مناسب
        // أنماط الزر: خلفية زرقاء، نص أبيض، هوامش داخلية، زوايا مستديرة
        addButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 10 25; -fx-border-radius: 6; -fx-background-radius: 6; -fx-cursor: hand;");
        // تأثير المرور (Hover effect) على زر "أضف للسلة"
         addButton.setOnMouseEntered(e -> addButton.setStyle("-fx-background-color: #005bb5; -fx-text-fill: white; -fx-padding: 10 25; -fx-border-radius: 6; -fx-background-radius: 6; -fx-cursor: hand;")); // لون أزرق أغمق عند المرور
         addButton.setOnMouseExited(e -> addButton.setStyle("-fx-background-color: #007aff; -fx-text-fill: white; -fx-padding: 10 25; -fx-border-radius: 6; -fx-background-radius: 6; -fx-cursor: hand;")); // العودة للون الأصلي

         // إضافة EventHandler لعملية إضافة المنتج للسلة
         addButton.setOnMouseClicked(e -> {
             System.out.println("تم الضغط على زر 'أضف للسلة' للمنتج: " + product.name);
             // يمكنك إضافة منطق الإضافة للسلة هنا (مثلاً تحديث العداد في الرأس)
             // في مثالنا الوهمي هذا، لن نضيف المنتج فعلياً، فقط نحدث العداد في الرأس إذا أردت
             // لتحسين العداد، تحتاج لجعله متغير على مستوى الفئة وتحديثه هنا، ثم تحديث نص cartIcon
             e.consume(); // هام جداً: منع الحدث من الانتشار إلى الـ VBox الأب (البطاقة) التي ستنقلك لصفحة التفاصيل
         });


        // إضافة جميع عناصر البطاقة إلى حاوية البطاقة (VBox)
        card.getChildren().addAll(imageView, nameLabel, priceLabel, addButton);

        return card; // إرجاع بطاقة المنتج
    }

    // دالة main لبدء تطبيق JavaFX
    public static void main(String[] args) {
        launch(args); // هذا السطر ضروري لبدء دورة حياة تطبيق JavaFX
    }
}