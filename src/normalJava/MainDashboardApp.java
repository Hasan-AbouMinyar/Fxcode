package normalJava; // يمكنك تغيير اسم الحزمة حسب مشروعك

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart; // مثال لاستخدام الرسوم البيانية
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView; // مثال لاستخدام قائمة
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections; // لاستخدام PieChart
import javafx.collections.ObservableList; // لاستخدام PieChart

public class MainDashboardApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Powerful Store Dashboard"); // عنوان النافذة

        // الهيكل الرئيسي: BorderPane
        BorderPane root = new BorderPane();
        root.getStyleClass().add("root"); // إضافة ستايل CSS

        // 1. الشريط الجانبي (Sidebar)
        VBox sidebar = new VBox(10); // المسافة بين العناصر 10px
        sidebar.setPadding(new Insets(20)); // هامش داخلي
        sidebar.setAlignment(Pos.TOP_CENTER); // محاذاة العناصر للوسط في الأعلى
        sidebar.getStyleClass().add("sidebar"); // إضافة ستايل CSS

        Label dashboardTitle = new Label("لوحة التحكم");
        dashboardTitle.getStyleClass().add("sidebar-title");

        Button btnHome = new Button("الرئيسية");
        Button btnOrders = new Button("الطلبات");
        Button btnProducts = new Button("المنتجات");
        Button btnCustomers = new Button("العملاء");
        Button btnSettings = new Button("الإعدادات");

        // يمكنك إضافة أحداث للأزرار هنا (مثلاً: الانتقال لصفحات أخرى)
        // btnOrders.setOnAction(e -> loadOrdersPage());

        btnHome.setMaxWidth(Double.MAX_VALUE); // جعل الأزرار تأخذ أقصى عرض متاح
        btnOrders.setMaxWidth(Double.MAX_VALUE);
        btnProducts.setMaxWidth(Double.MAX_VALUE);
        btnCustomers.setMaxWidth(Double.MAX_VALUE);
        btnSettings.setMaxWidth(Double.MAX_VALUE);

        sidebar.getChildren().addAll(dashboardTitle, btnHome, btnOrders, btnProducts, btnCustomers, btnSettings);
        root.setLeft(sidebar); // وضع الشريط الجانبي في الجهة اليسرى

        // 2. منطقة المحتوى الرئيسية (Main Content Area)
        VBox mainContent = new VBox(20); // المسافة بين الأقسام 20px
        mainContent.setPadding(new Insets(20)); // هامش داخلي
        mainContent.getStyleClass().add("main-content"); // إضافة ستايل CSS

        // قسم الملخصات السريعة (Summary Cards)
        HBox summaryCards = new HBox(20); // المسافة بين البطاقات 20px
        summaryCards.getStyleClass().add("summary-cards");

        // مثال لبطاقة ملخص
        VBox salesCard = createSummaryCard("إجمالي المبيعات", "15,500 ر.س");
        VBox ordersCard = createSummaryCard("عدد الطلبات", "350");
        VBox customersCard = createSummaryCard("العملاء الجدد", "45");
        VBox stockCard = createSummaryCard("المنتجات المتاحة", "1200");

        summaryCards.getChildren().addAll(salesCard, ordersCard, customersCard, stockCard);

        // قسم الرسوم البيانية (Charts Area)
        Label chartsTitle = new Label("ملخص الأداء");
        chartsTitle.getStyleClass().add("section-title");

        // مثال بسيط جداً لرسم بياني دائري
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("المنتج أ", 200),
                        new PieChart.Data("المنتج ب", 150),
                        new PieChart.Data("المنتج ج", 100));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("مبيعات المنتجات حسب الصنف");
        chart.getStyleClass().add("dashboard-chart");


        // قسم أحدث الطلبات (Recent Orders Area)
        Label recentOrdersTitle = new Label("أحدث الطلبات");
        recentOrdersTitle.getStyleClass().add("section-title");

        // مثال بسيط لقائمة (يمكن استبدالها بـ TableView لبيانات جدولية)
        ListView<String> recentOrdersList = new ListView<>(FXCollections.observableArrayList(
                "طلب #101 - تم التنفيذ",
                "طلب #102 - قيد التجهيز",
                "طلب #103 - بانتظار الدفع"
        ));
        recentOrdersList.setPrefHeight(150); // تحديد ارتفاع القائمة
        recentOrdersList.getStyleClass().add("recent-orders-list");


        mainContent.getChildren().addAll(summaryCards, chartsTitle, chart, recentOrdersTitle, recentOrdersList);

        root.setCenter(mainContent); // وضع منطقة المحتوى الرئيسية في المنتصف

        // إعداد المشهد (Scene)
        Scene scene = new Scene(root, 1000, 700); // حجم النافذة
        // تحميل ملف CSS
        scene.getStylesheets().add(getClass().getResource("/dashboard.css").toExternalForm());


        primaryStage.setScene(scene); // تعيين المشهد للمرحلة (النافذة)
        primaryStage.show(); // عرض النافذة
    }

    // دالة مساعدة لإنشاء بطاقة الملخص
    private VBox createSummaryCard(String title, String value) {
        VBox card = new VBox(5); // مسافة 5px بين العناصر
        card.getStyleClass().add("summary-card"); // إضافة ستايل CSS
        card.setAlignment(Pos.CENTER_LEFT); // محاذاة العناصر لليسار
        card.setPadding(new Insets(15)); // هامش داخلي

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("summary-card-title");

        Label valueLabel = new Label(value);
        valueLabel.getStyleClass().add("summary-card-value");

        card.getChildren().addAll(titleLabel, valueLabel);
        return card;
    }


    public static void main(String[] args) {
        launch(args); // تشغيل تطبيق JavaFX
    }
}