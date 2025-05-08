package normalJava; // يمكنك تغيير اسم الحزمة حسب مشروعك

import javafx.application.Application;
import javafx.beans.property.*; // لاستخدام JavaFX Properties في نماذج البيانات
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart; // مثال لرسم بياني
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*; // Button, Label, TableView, TableColumn, ListView, ScrollPane
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority; // للتحكم في تمدد العناصر
import javafx.scene.layout.StackPane; // لتغيير المحتوى في المركز بسهولة
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate; // لاستخدام التواريخ في البيانات
import java.util.Arrays;
import java.util.List;

// ======================================================================
// 1. نماذج البيانات الوهمية (Dummy Data Models)
//    في تطبيق حقيقي، هذه الفئات قد تكون مرتبطة بقاعدة بيانات.
// ======================================================================

class Product {
    private final StringProperty name;
    private final StringProperty category;
    private final IntegerProperty stock;
    private final DoubleProperty price;

    public Product(String name, String category, int stock, double price) {
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.stock = new SimpleIntegerProperty(stock);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }

    public String getCategory() { return category.get(); }
    public StringProperty categoryProperty() { return category; }

    public int getStock() { return stock.get(); }
    public IntegerProperty stockProperty() { return stock; }

    public double getPrice() { return price.get(); }
    public DoubleProperty priceProperty() { return price; }
}

class Order {
    private final IntegerProperty orderId;
    private final StringProperty customerName;
    private final LocalDate orderDate;
    private final DoubleProperty totalAmount;
    private final StringProperty status;

    public Order(int orderId, String customerName, LocalDate orderDate, double totalAmount, String status) {
        this.orderId = new SimpleIntegerProperty(orderId);
        this.customerName = new SimpleStringProperty(customerName);
        this.orderDate = orderDate;
        this.totalAmount = new SimpleDoubleProperty(totalAmount);
        this.status = new SimpleStringProperty(status);
    }

    public int getOrderId() { return orderId.get(); }
    public IntegerProperty orderIdProperty() { return orderId; }

    public String getCustomerName() { return customerName.get(); }
    public StringProperty customerNameProperty() { return customerName; }

    public LocalDate getOrderDate() { return orderDate; }
    // لا يوجد Property لـ LocalDate مباشرة في SimpleLocalDateProperty،
    // يمكنك استخدام ObjectProperty<LocalDate> إذا احتجت للربط المباشر في TableView
    // أو الحصول على القيمة كما هنا.

    public double getTotalAmount() { return totalAmount.get(); }
    public DoubleProperty totalAmountProperty() { return totalAmount; }

    public String getStatus() { return status.get(); }
    public StringProperty statusProperty() { return status; }
}

// ======================================================================
// 2. كلاس التطبيق الرئيسي (Main Application Class)
// ======================================================================

public class MainDashboardApp extends Application {

    // 3. البيانات الوهمية (Dummy Data)
    private ObservableList<Product> products = FXCollections.observableArrayList(
            new Product("لابتوب محمول", "إلكترونيات", 50, 3500.00),
            new Product("هاتف ذكي", "إلكترونيات", 120, 2800.00),
            new Product("ساعة ذكية", "إلكترونيات", 80, 750.00),
            new Product("قميص قطني", "ملابس", 200, 85.00),
            new Product("بنطلون جينز", "ملابس", 150, 120.00),
            new Product("حذاء رياضي", "أحذية", 90, 300.00),
            new Product("كتاب برمجة", "كتب", 60, 150.00)
    );

    private ObservableList<Order> orders = FXCollections.observableArrayList(
            new Order(1001, "أحمد علي", LocalDate.of(2023, 10, 25), 4250.00, "تم التنفيذ"),
            new Order(1002, "فاطمة الزهراء", LocalDate.of(2023, 10, 26), 2920.00, "قيد التجهيز"),
            new Order(1003, "محمد خالد", LocalDate.of(2023, 10, 26), 385.00, "بانتظار الدفع"),
            new Order(1004, "ليلى سعيد", LocalDate.of(2023, 10, 27), 1600.00, "تم التنفيذ"),
            new Order(1005, "علي حسن", LocalDate.of(2023, 10, 27), 750.00, "قيد التجهيز")
    );

    // 4. تضمين محتوى CSS بالكامل كـ String
    // (تم توسيع الستايل ليشمل مكونات جديدة مثل TableView)
    private static final String DASHBOARD_CSS = """
        /* ملف dashboard.css مضمّن */

        .root {
            -fx-background-color: #f4f4f4;
        }

        .sidebar {
            -fx-background-color: #2c3e50; /* لون أزرق داكن */
            -fx-padding: 20px;
            -fx-spacing: 10px;
        }

        .sidebar-title {
            -fx-text-fill: #ecf0f1; /* لون رمادي فاتح */
            -fx-font-size: 20px;
            -fx-font-weight: bold;
            -fx-padding-bottom: 10px;
            -fx-border-color: #34495e;
            -fx-border-width: 0 0 1px 0;
        }

        .sidebar .button {
            -fx-background-color: #34495e;
            -fx-text-fill: #ecf0f1;
            -fx-font-size: 14px;
            -fx-padding: 10px;
            -fx-alignment: CENTER_LEFT;
            -fx-background-radius: 4px;
        }

        .sidebar .button:hover {
            -fx-background-color: #41697e; /* لون أغمق قليلا عند التحويم */
        }

         /* ستايل للزر النشط في الشريط الجانبي */
        .sidebar .button:default { /* يمكنك تعريف كلاس نشط بدلاً من default */
             -fx-background-color: #1abc9c; /* لون أخضر مائل للأزرق */
             -fx-font-weight: bold;
        }


        .main-content {
            -fx-padding: 20px;
            -fx-spacing: 20px;
             -fx-background-color: #ecf0f1; /* لون خلفية فاتح للمحتوى */
        }

        /* ستايل لقسم الملخصات السريعة */
        .summary-cards {
            -fx-spacing: 20px;
            -fx-alignment: CENTER_LEFT; /* محاذاة البطاقات لليسار */
        }

        /* ستايل لبطاقة الملخص الواحدة */
        .summary-card {
            -fx-background-color: #fff;
            -fx-padding: 20px; /* هامش داخلي أكبر */
            -fx-border-radius: 8px; /* زوايا أكثر استدارة */
            -fx-background-radius: 8px;
            -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 10, 0, 0, 5);
            -fx-min-width: 200px;
            -fx-grow: always;
             -fx-spacing: 8px; /* مسافة بين العنوان والقيمة داخل البطاقة */
        }

        .summary-card-title {
            -fx-font-size: 15px;
            -fx-text-fill: #7f8c8d; /* لون رمادي متوسط */
             -fx-font-weight: bold;
        }

        .summary-card-value {
            -fx-font-size: 28px; /* حجم خط أكبر للقيمة */
            -fx-font-weight: bold;
            -fx-text-fill: #2c3e50; /* لون أزرق داكن */
        }

        /* ستايل لعناوين الأقسام */
        .section-title {
            -fx-font-size: 18px;
            -fx-font-weight: bold;
            -fx-padding-bottom: 10px;
            -fx-border-color: #bdc3c7; /* لون رمادي أفتح للخط الفاصل */
            -fx-border-width: 0 0 1px 0;
             -fx-text-fill: #333;
        }

        /* ستايل للرسوم البيانية */
        .dashboard-chart {
             -fx-background-color: #fff; /* خلفية بيضاء للرسم البياني */
             -fx-padding: 15px;
             -fx-border-radius: 8px;
             -fx-background-radius: 8px;
             -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0, 0, 4);
        }

        /* ستايل للـ TableView */
        .table-view {
            -fx-base: #ecf0f1; /* لون خلفية أساسي للجدول */
            -fx-background-color: #fff; /* خلفية بيضاء للجزء الرئيسي */
            -fx-border-color: #bdc3c7;
            -fx-border-width: 1px;
             -fx-border-radius: 8px;
             -fx-background-radius: 8px;
             -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0, 0, 4);
        }

        /* رأس الجدول */
        .table-view .column-header-background {
            -fx-background-color: #bdc3c7; /* لون رأس الجدول */
            -fx-padding: 10px;
        }

        .table-view .column-header .label{
            -fx-text-fill: #333; /* لون نص رأس الجدول */
            -fx-font-weight: bold;
        }

        /* خلايا الجدول */
        .table-view .table-cell {
            -fx-border-color: #ecf0f1; /* لون الخط الفاصل بين الخلايا */
            -fx-border-width: 0 0 1px 0;
            -fx-padding: 10px;
        }

        /* صفوف الجدول عند التحويم */
        .table-view .table-row-cell:hover {
            -fx-background-color: #f0f4f7; /* لون الخلفية عند التحويم على الصف */
        }

        /* صفوف الجدول الزوجية */
         .table-view .table-row-cell:even {
             -fx-background-color: #f9fbfb; /* لون خلفية للصفوف الزوجية */
         }

         /* صفوف الجدول الفردية */
         .table-view .table-row-cell:odd {
             -fx-background-color: #fff; /* لون خلفية للصفوف الفردية */
         }


        /* ستايل لقوائم بسيطة مثل أحدث الطلبات في الملخص */
        .recent-orders-list {
             -fx-border-color: #bdc3c7;
             -fx-border-width: 1px;
             -fx-background-color: #fff;
             -fx-border-radius: 8px;
             -fx-background-radius: 8px;
             -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.08), 8, 0, 0, 4);
        }

        .recent-orders-list .list-cell {
            -fx-padding: 10px;
            -fx-border-color: #ecf0f1;
            -fx-border-width: 0 0 1px 0;
        }

        .recent-orders-list .list-cell:last-child {
             -fx-border-width: 0;
        }
        """; // نهاية الـ String المتعدد الأسطر (يتطلب Java 15+)

    // 5. StackPane لتغيير المحتوى في المركز
    private StackPane contentPane;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("متجر قوي - لوحة التحكم"); // عنوان النافذة

        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");

        // 6. الشريط الجانبي (Sidebar) مع أزرار التفاعل
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(20));
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.getStyleClass().add("sidebar");
        sidebar.setPrefWidth(200); // عرض ثابت للشريط الجانبي

        Label dashboardTitle = new Label("المتجر");
        dashboardTitle.getStyleClass().add("sidebar-title");

        Button btnOverview = createSidebarButton("الرئيسية");
        Button btnOrders = createSidebarButton("الطلبات");
        Button btnProducts = createSidebarButton("المنتجات");
        Button btnCustomers = createSidebarButton("العملاء"); // يمكنك إضافة شاشة للعملاء لاحقاً
        Button btnSettings = createSidebarButton("الإعدادات"); // يمكنك إضافة شاشة للإعدادات لاحقاً

        sidebar.getChildren().addAll(dashboardTitle, btnOverview, btnOrders, btnProducts, btnCustomers, btnSettings);
        root.setLeft(sidebar);

        // 7. منطقة المحتوى الرئيسية القابلة للتغيير (Content Area)
        contentPane = new StackPane(); // نستخدم StackPane لوضع المحتويات فوق بعضها وتغييرها
        contentPane.getStyleClass().add("main-content");
        root.setCenter(contentPane);

        // 8. تعريف محتويات الصفحات المختلفة (كمتغيرات VBox)
        VBox overviewPage = createOverviewPage();
        VBox ordersPage = createOrdersPage();
        VBox productsPage = createProductsPage();

        // إضافة الصفحات إلى StackPane (واحدة فقط ستكون مرئية في كل مرة)
        // نضيفها جميعاً ثم نتحكم في visibility أو نستخدم bind
        contentPane.getChildren().addAll(overviewPage, ordersPage, productsPage);


        // 9. ربط الأزرار بعرض الصفحات المناسبة
        btnOverview.setOnAction(e -> showPage(overviewPage, btnOverview));
        btnOrders.setOnAction(e -> showPage(ordersPage, btnOrders));
        btnProducts.setOnAction(e -> showPage(productsPage, btnProducts));
        //btnCustomers.setOnAction(e -> showPage(customersPage, btnCustomers)); // تحتاج لإنشاء صفحات العملاء والإعدادات

        // 10. عرض الصفحة الرئيسية عند بدء التطبيق
        showPage(overviewPage, btnOverview);


        // إعداد المشهد (Scene)
        Scene scene = new Scene(root, 1200, 800); // حجم نافذة أكبر
        // تطبيق الـ String الذي يحتوي على CSS مباشرة على المشهد
        scene.getStylesheets().add(DASHBOARD_CSS);

        primaryStage.setScene(scene); // تعيين المشهد للمرحلة (النافذة)
        primaryStage.show(); // عرض النافذة
    }

    // ======================================================================
    // 11. دوال مساعدة لإنشاء مكونات الواجهة والأقسام المختلفة
    // ======================================================================

    // دالة لإنشاء زر للشريط الجانبي
    private Button createSidebarButton(String text) {
        Button button = new Button(text);
        button.setMaxWidth(Double.MAX_VALUE);
        // يمكن إضافة أيقونات هنا Button graphic = new ImageView(...)
        return button;
    }

     // دالة لتحديث الستايل للزر النشط في الشريط الجانبي
    private void setActiveButton(Button activeBtn) {
        // إزالة الستايل من جميع الأزرار أولاً
        for (javafx.scene.Node node : ((VBox)activeBtn.getParent()).getChildren()) {
            if (node instanceof Button) {
                node.getStyleClass().remove("active-button"); // نستخدم كلاس مخصص بدلاً من default
                ((Button)node).setDefaultButton(false); // إزالة DefaultButton property إذا استخدمت
            }
        }
        // إضافة الستايل للزر النشط
        activeBtn.getStyleClass().add("active-button");
        // activeBtn.setDefaultButton(true); // يمكن استخدام DefaultButton property إذا ناسبك
    }


    // دالة لعرض صفحة معينة في منطقة المحتوى المركزية وتحديث الزر النشط
    private void showPage(VBox pageToShow, Button activeBtn) {
        // إخفاء جميع الصفحات الأخرى
        for (javafx.scene.Node page : contentPane.getChildren()) {
            page.setVisible(false);
        }
        // عرض الصفحة المطلوبة
        pageToShow.setVisible(true);

        // تحديث الستايل للزر النشط في الشريط الجانبي
        setActiveButton(activeBtn);
    }

    // دالة لإنشاء بطاقة الملخص
    private VBox createSummaryCard(String title, String value) {
        VBox card = new VBox(5);
        card.getStyleClass().add("summary-card");
        card.setAlignment(Pos.CENTER_LEFT);
        card.setPadding(new Insets(15));
        HBox.setHgrow(card, Priority.ALWAYS); // للسماح للبطاقة بالتمدد أفقياً

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("summary-card-title");

        Label valueLabel = new Label(value);
        valueLabel.getStyleClass().add("summary-card-value");

        card.getChildren().addAll(titleLabel, valueLabel);
        return card;
    }

    // ======================================================================
    // 12. دوال لإنشاء محتوى الصفحات المختلفة في الداشبورد
    // ======================================================================

    // إنشاء صفحة النظرة العامة (Overview)
    private VBox createOverviewPage() {
        VBox overviewLayout = new VBox(20);
        overviewLayout.setPadding(new Insets(20));
        // ليس لها ستايل main-content لأن contentPane هو الذي يملكه

        // قسم الملخصات السريعة
        Label summaryTitle = new Label("ملخص الأداء");
        summaryTitle.getStyleClass().add("section-title");

        // حساب الملخصات من البيانات الوهمية
        double totalSales = orders.stream().mapToDouble(Order::getTotalAmount).sum();
        long totalOrders = orders.size();
        long totalProducts = products.size();
        int totalStock = products.stream().mapToInt(Product::getStock).sum();


        HBox summaryCards = new HBox(20);
        summaryCards.getStyleClass().add("summary-cards"); // استخدام نفس ستايل البطاقات
        summaryCards.getChildren().addAll(
                createSummaryCard("إجمالي المبيعات", String.format("%,.2f ر.س", totalSales)),
                createSummaryCard("إجمالي الطلبات", String.valueOf(totalOrders)),
                createSummaryCard("إجمالي المنتجات", String.valueOf(totalProducts)),
                 createSummaryCard("إجمالي المخزون", String.valueOf(totalStock))
        );
         VBox.setVgrow(summaryCards, Priority.NEVER); // لا تسمح للبطاقات بالتمدد عمودياً

        // قسم الرسوم البيانية (مثال: مبيعات الأشهر الأخيرة)
        Label chartTitle = new Label("المبيعات الشهرية (وهمي)");
        chartTitle.getStyleClass().add("section-title");

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> monthlySalesChart = new BarChart<>(xAxis, yAxis);
        monthlySalesChart.setTitle(""); // العنوان سيكون في Label
        monthlySalesChart.getStyleClass().add("dashboard-chart");
        monthlySalesChart.setLegendVisible(false); // إخفاء وسيلة الإيضاح إذا كان هناك سلسلة واحدة

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        // بيانات وهمية للمبيعات الشهرية
        series.getData().add(new XYChart.Data<>("يناير", 5000));
        series.getData().add(new XYChart.Data<>("فبراير", 7000));
        series.getData().add(new XYChart.Data<>("مارس", 6500));
        series.getData().add(new XYChart.Data<>("أبريل", 8000));
        series.getData().add(new XYChart.Data<>("مايو", totalSales)); // نفترض أن مايو هو الشهر الحالي

        monthlySalesChart.getData().add(series);
        VBox.setVgrow(monthlySalesChart, Priority.ALWAYS); // اسمح للرسم البياني بالتمدد عمودياً

        // قسم أحدث الطلبات (عرض بسيط باستخدام ListView)
        Label recentOrdersTitle = new Label("أحدث الطلبات");
        recentOrdersTitle.getStyleClass().add("section-title");

        ObservableList<String> recentOrderStrings = FXCollections.observableArrayList();
        orders.stream()
              .sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate())) // ترتيب تنازلي حسب التاريخ
              .limit(5) // عرض آخر 5 طلبات فقط
              .forEach(order -> recentOrderStrings.add(
                      "#" + order.getOrderId() + " - " + order.getCustomerName() +
                      " (" + String.format("%.2f ر.س", order.getTotalAmount()) + ") - " + order.getStatus()
              ));

        ListView<String> recentOrdersList = new ListView<>(recentOrderStrings);
        recentOrdersList.setPrefHeight(150); // ارتفاع ثابت مع شريط تمرير إذا لزم الأمر
        recentOrdersList.getStyleClass().add("recent-orders-list");
         VBox.setVgrow(recentOrdersList, Priority.NEVER); // لا تسمح للقائمة بالتمدد عمودياً

        overviewLayout.getChildren().addAll(summaryTitle, summaryCards, chartTitle, monthlySalesChart, recentOrdersTitle, recentOrdersList);
        return overviewLayout;
    }

    // إنشاء صفحة الطلبات (Orders)
    private VBox createOrdersPage() {
        VBox ordersLayout = new VBox(20);
        ordersLayout.setPadding(new Insets(20));
        //ordersLayout.getStyleClass().add("main-content"); // لا حاجة لإضافة ستايل الـ main-content هنا

        Label title = new Label("قائمة الطلبات");
        title.getStyleClass().add("section-title");

        TableView<Order> ordersTable = new TableView<>();
        ordersTable.getStyleClass().add("table-view");

        // تعريف أعمدة الجدول
        TableColumn<Order, Integer> idColumn = new TableColumn<>("رقم الطلب");
        idColumn.setCellValueFactory(cellData -> cellData.getValue().orderIdProperty().asObject()); // ربط بـ Property
        idColumn.setPrefWidth(100);

        TableColumn<Order, String> customerColumn = new TableColumn<>("العميل");
        customerColumn.setCellValueFactory(cellData -> cellData.getValue().customerNameProperty());
        customerColumn.setPrefWidth(200);

        // لربط التاريخ، نستخدم ObjectProperty<LocalDate> أو ننسق String
        TableColumn<Order, String> dateColumn = new TableColumn<>("التاريخ");
         dateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOrderDate().toString())); // عرض التاريخ كـ String
         dateColumn.setPrefWidth(120);

        TableColumn<Order, Double> totalColumn = new TableColumn<>("الإجمالي");
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().totalAmountProperty().asObject());
         // يمكنك إضافة تنسيق للعملة
         totalColumn.setCellFactory(column -> new TableCell<Order, Double>() {
             @Override
             protected void updateItem(Double item, boolean empty) {
                 super.updateItem(item, empty);
                 if (empty || item == null) {
                     setText(null);
                 } else {
                     setText(String.format("%.2f ر.س", item));
                 }
             }
         });
        totalColumn.setPrefWidth(120);

        TableColumn<Order, String> statusColumn = new TableColumn<>("الحالة");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        statusColumn.setPrefWidth(150);

        // إضافة الأعمدة للجدول
        ordersTable.getColumns().addAll(idColumn, customerColumn, dateColumn, totalColumn, statusColumn);

        // ربط البيانات الوهمية بالجدول
        ordersTable.setItems(orders);

        // جعل الجدول يتمدد لملء المساحة المتاحة
        VBox.setVgrow(ordersTable, Priority.ALWAYS);

        ordersLayout.getChildren().addAll(title, ordersTable);
         ordersLayout.setVisible(false); // تبدأ الصفحة غير مرئية
        return ordersLayout;
    }

     // إنشاء صفحة المنتجات (Products)
    private VBox createProductsPage() {
        VBox productsLayout = new VBox(20);
        productsLayout.setPadding(new Insets(20));
        //productsLayout.getStyleClass().add("main-content"); // لا حاجة لإضافة ستايل الـ main-content هنا

        Label title = new Label("قائمة المنتجات");
        title.getStyleClass().add("section-title");

        TableView<Product> productsTable = new TableView<>();
        productsTable.getStyleClass().add("table-view");

        // تعريف أعمدة الجدول
        TableColumn<Product, String> nameColumn = new TableColumn<>("اسم المنتج");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        nameColumn.setPrefWidth(200);

        TableColumn<Product, String> categoryColumn = new TableColumn<>("التصنيف");
        categoryColumn.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        categoryColumn.setPrefWidth(150);

        TableColumn<Product, Integer> stockColumn = new TableColumn<>("المخزون");
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        stockColumn.setPrefWidth(100);

        TableColumn<Product, Double> priceColumn = new TableColumn<>("السعر");
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
         // يمكنك إضافة تنسيق للعملة
         priceColumn.setCellFactory(column -> new TableCell<Product, Double>() {
             @Override
             protected void updateItem(Double item, boolean empty) {
                 super.updateItem(item, empty);
                 if (empty || item == null) {
                     setText(null);
                 } else {
                     setText(String.format("%.2f ر.س", item));
                 }
             }
         });
        priceColumn.setPrefWidth(120);


        // إضافة الأعمدة للجدول
        productsTable.getColumns().addAll(nameColumn, categoryColumn, stockColumn, priceColumn);

        // ربط البيانات الوهمية بالجدول
        productsTable.setItems(products);

         // جعل الجدول يتمدد لملء المساحة المتاحة
        VBox.setVgrow(productsTable, Priority.ALWAYS);

        productsLayout.getChildren().addAll(title, productsTable);
        productsLayout.setVisible(false); // تبدأ الصفحة غير مرئية
        return productsLayout;
    }


    public static void main(String[] args) {
        launch(args); // تشغيل تطبيق JavaFX
    }
}