/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package diglobetal;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static javafx.application.Application.launch;

public class DigitalStoreApp extends Application {

    // نموذج البيانات
    public static class Product {
        private String id;
        private String name;
        private double price;
        private String imagePath;
        private String description;

        public Product(String id, String name, double price, String imagePath, String description) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.imagePath = imagePath;
            this.description = description;
        }

        // Getters and Setters
        public String getId() { return id; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getImagePath() { return imagePath; }
        public String getDescription() { return description; }
    }

    // عناصر واجهة المستخدم
    private FlowPane productListFlowPane = new FlowPane();
    private HBox headerBox = new HBox();
    private Button cartButton = new Button("السلة (0)");
    private Button searchButton = new Button("بحث");
    private List<Product> mockProducts = new ArrayList<>();
    private List<Product> cartItems = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        try {
            // إعداد الواجهة الرئيسية
            VBox root = new VBox();
            root.setSpacing(10);
            root.setPadding(new Insets(15));
            
            // إعداد الهيدر
            setupHeader();
            
            // إعداد قائمة المنتجات
            productListFlowPane.setHgap(20);
            productListFlowPane.setVgap(20);
            productListFlowPane.setPadding(new Insets(15));
            
            // تحميل البيانات وعرضها
            loadMockProducts();
            displayProducts();
            
            // إضافة العناصر إلى الجذر
            root.getChildren().addAll(headerBox, productListFlowPane);
            
            // إعداد المشهد
            Scene scene = new Scene(root, 900, 700);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
            
            // إعداد النافذة
            primaryStage.setTitle("متجر ديقلوبيتال");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupHeader() {
        headerBox.setSpacing(20);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setPadding(new Insets(10));
        headerBox.setStyle("-fx-background-color: #f8f9fa; -fx-border-color: #dee2e6; -fx-border-width: 0 0 1 0;");
        
        Label title = new Label("ديقلوبيتال");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        
        HBox spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        
        searchButton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #ced4da;");
        cartButton.setStyle("-fx-background-color: #007bff; -fx-text-fill: white;");
        
        headerBox.getChildren().addAll(title, spacer, searchButton, cartButton);
    }

    private void loadMockProducts() {
        // استخدام صور افتراضية من الإنترنت لتجنب مشاكل المسارات
        mockProducts.add(new Product("1", "آيفون 15 برو", 4599.00, 
            "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-15-pro-finish-select-202309-6-1inch?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1693009279096",
            "أحدث وأقوى آيفون بتصميم احترافي"));
        
        mockProducts.add(new Product("2", "ماك بوك اير M3", 5500.00, 
            "https://www.apple.com/v/macbook-air/s/images/overview/design/color/design_side_midnight__flnancj2vlme_medium.jpg",
            "لابتوب نحيف وخفيف بأداء فائق"));
        
        mockProducts.add(new Product("3", "آيباد اير", 2500.00, 
            "https://www.apple.com/v/ipad-air/h/images/overview/design/colors_blue__f0b4ekl3x4uq_medium.jpg",
            "شاشة Liquid Retina مذهلة"));
        
        mockProducts.add(new Product("4", "ساعة أبل", 1800.00, 
            "https://www.apple.com/v/apple-watch-series-9/a/images/overview/hero/hero__ghk6f7v4mteq_medium.jpg",
            "تتبع لياقتك وصحتك بأناقة"));
    }

    private void displayProducts() {
        productListFlowPane.getChildren().clear();
        
        for (Product product : mockProducts) {
            VBox productCard = createProductCard(product);
            productListFlowPane.getChildren().add(productCard);
        }
    }

    private VBox createProductCard(Product product) {
        VBox card = new VBox(10);
        card.setAlignment(Pos.TOP_CENTER);
        card.setPadding(new Insets(15));
        card.setStyle("-fx-background-color: white; -fx-border-radius: 10; -fx-background-radius: 10; " +
                     "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");
        
        // صورة المنتج
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(product.getImagePath(), 150, 150, true, true);
            imageView.setImage(image);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            imageView.setStyle("-fx-background-color: #e9ecef; -fx-min-width: 150; -fx-min-height: 150;");
            Label errorLabel = new Label("No Image");
            
        }
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(150);
        
        // معلومات المنتج
        Label nameLabel = new Label(product.getName());
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16;");
        
        Label priceLabel = new Label(String.format("%.2f ر.س", product.getPrice()));
        priceLabel.setStyle("-fx-text-fill: #2a5885; -fx-font-size: 14;");
        
        Button addButton = new Button("أضف إلى السلة");
        addButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        addButton.setOnAction(e -> addToCart(product));
        
        card.getChildren().addAll(imageView, nameLabel, priceLabel, addButton);
        
        return card;
    }

    private void addToCart(Product product) {
        cartItems.add(product);
        cartButton.setText("السلة (" + cartItems.size() + ")");
        System.out.println("تمت إضافة " + product.getName() + " إلى السلة");
    }

    public static void main(String[] args) {
        launch(args);
    }
}