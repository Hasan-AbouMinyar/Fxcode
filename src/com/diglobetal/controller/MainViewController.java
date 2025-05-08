package ecommerce.store;

import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

class Product {
    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty category;
    private final DoubleProperty price;
    private final StringProperty description;
    private final StringProperty imageUrl;
    private final IntegerProperty stock;
    private final DoubleProperty rating;

    public Product(String id, String name, String category, double price, 
                  String description, String imageUrl, int stock, double rating) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.price = new SimpleDoubleProperty(price);
        this.description = new SimpleStringProperty(description);
        this.imageUrl = new SimpleStringProperty(imageUrl);
        this.stock = new SimpleIntegerProperty(stock);
        this.rating = new SimpleDoubleProperty(rating);
    }

    // Getters and property methods
    public String getId() { return id.get(); }
    public StringProperty idProperty() { return id; }

    public String getName() { return name.get(); }
    public StringProperty nameProperty() { return name; }

    public String getCategory() { return category.get(); }
    public StringProperty categoryProperty() { return category; }

    public double getPrice() { return price.get(); }
    public DoubleProperty priceProperty() { return price; }

    public String getDescription() { return description.get(); }
    public StringProperty descriptionProperty() { return description; }

    public String getImageUrl() { return imageUrl.get(); }
    public StringProperty imageUrlProperty() { return imageUrl; }

    public int getStock() { return stock.get(); }
    public IntegerProperty stockProperty() { return stock; }

    public double getRating() { return rating.get(); }
    public DoubleProperty ratingProperty() { return rating; }
}

class CartItem {
    private final Product product;
    private final IntegerProperty quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = new SimpleIntegerProperty(quantity);
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity.get(); }
    public IntegerProperty quantityProperty() { return quantity; }
    
    public void increaseQuantity() { quantity.set(quantity.get() + 1); }
    public void decreaseQuantity() { if (quantity.get() > 1) quantity.set(quantity.get() - 1); }
}

public class AppleStyleStore extends Application {
    private ObservableList<Product> products = FXCollections.observableArrayList(
        new Product("P1001", "iPhone 15 Pro", "Phones", 3999.00, 
                   "iPhone 15 Pro with A17 Pro chip, 6.1-inch Super Retina XDR display", 
                   "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/iphone-15-pro-finish-select-202309-6-1inch?wid=5120&hei=2880&fmt=p-jpg&qlt=80&.v=1693009279096",
                   50, 4.8),
        new Product("P1002", "MacBook Pro 14\"", "Laptops", 7999.00, 
                   "MacBook Pro 14-inch with M3 Pro chip, 16GB RAM, 512GB SSD", 
                   "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp14-spacegray-select-202310?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1697230830949",
                   30, 4.9),
        new Product("P1003", "Apple Watch Series 9", "Watches", 1799.00, 
                   "Apple Watch Series 9 GPS, 45mm Midnight Aluminum Case", 
                   "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MPUY3ref_VW_34FR+watch-49-titanium-ultra_VW_34FR_WF_CO+watch-face-49-alpine-ultra_VW_34FR_WF_CO_GEO_AE?wid=750&hei=712&trim=1%2C0&fmt=p-jpg&qlt=95&.v=1683224241054",
                   40, 4.7),
        new Product("P1004", "iPad Pro 12.9\"", "Tablets", 5499.00, 
                   "iPad Pro 12.9-inch with M2 chip, Wi-Fi, 128GB", 
                   "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/ipad-pro-finish-select-202212-12-9inch-space-gray-wifi_FMT_WHH?wid=1280&hei=720&fmt=p-jpg&qlt=95&.v=1670865949317",
                   25, 4.8),
        new Product("P1005", "AirPods Pro (2nd Gen)", "Accessories", 1099.00, 
                   "AirPods Pro (2nd generation) with MagSafe Charging Case", 
                   "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MQD83?wid=572&hei=572&fmt=jpeg&qlt=95&.v=1660803962361",
                   60, 4.6),
        new Product("P1006", "iMac 24\"", "Desktops", 5999.00, 
                   "iMac 24-inch with 4.5K Retina display, M3 chip, 8GB RAM, 256GB SSD", 
                   "https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/imac-24-blue-selection-hero-202104?wid=904&hei=840&fmt=jpeg&qlt=90&.v=1617760312000",
                   20, 4.7)
    );

    private ObservableList<CartItem> cartItems = FXCollections.observableArrayList();
    private StackPane contentPane;
    private Label cartBadge;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("متجر Apple الإلكتروني");

        BorderPane root = new BorderPane();
        root.getStyleClass().add("root");

        // Create header with logo and cart
        HBox header = createHeader();
        root.setTop(header);

        // Create category navigation
        HBox categories = createCategories();
        root.setCenter(categories);

        // Create product grid
        ScrollPane productGrid = createProductGrid();
        contentPane = new StackPane(productGrid);
        root.setCenter(contentPane);

        // Apply CSS
        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createHeader() {
        HBox header = new HBox(20);
        header.setPadding(new Insets(15));
        header.setAlignment(Pos.CENTER);
        header.getStyleClass().add("header");

        // Apple logo
        ImageView logo = new ImageView(new Image("https://www.apple.com/ac/globalnav/7/en_SA/images/be15095f-5a20-57d0-ad14-cf4c638e223a/globalnav_apple_image__b5er5ngrzxqq_large.svg"));
        logo.setFitHeight(30);
        logo.setPreserveRatio(true);

        // Navigation links
        HBox navLinks = new HBox(25);
        navLinks.setAlignment(Pos.CENTER);
        
        List<String> links = Arrays.asList("المتجر", "Mac", "iPad", "iPhone", "Watch", "AirPods", "TV & Home", "الترفيه", "الاكسسوارات", "الدعم");
        for (String link : links) {
            Label navLink = new Label(link);
            navLink.getStyleClass().add("nav-link");
            navLinks.getChildren().add(navLink);
        }

        // Cart button with badge
        HBox cartBox = new HBox();
        cartBox.setAlignment(Pos.CENTER);
        
        Button cartButton = new Button();
        ImageView cartIcon = new ImageView(new Image("https://www.apple.com/ac/globalnav/7/en_SA/images/be15095f-5a20-57d0-ad14-cf4c638e223a/globalnav_bag_image__yzte50i47ciu_large.svg"));
        cartIcon.setFitHeight(20);
        cartIcon.setPreserveRatio(true);
        cartButton.setGraphic(cartIcon);
        cartButton.getStyleClass().add("cart-button");
        cartButton.setOnAction(e -> showCart());
        
        cartBadge = new Label("0");
        cartBadge.getStyleClass().add("cart-badge");
        cartBadge.setVisible(false);
        
        StackPane cartStack = new StackPane(cartButton, cartBadge);
        StackPane.setAlignment(cartBadge, Pos.TOP_RIGHT);
        
        cartBox.getChildren().add(cartStack);

        header.getChildren().addAll(logo, navLinks, cartBox);
        HBox.setHgrow(navLinks, Priority.ALWAYS);
        
        return header;
    }

    private HBox createCategories() {
        HBox categories = new HBox(15);
        categories.setPadding(new Insets(20, 0, 20, 0));
        categories.setAlignment(Pos.CENTER);
        categories.getStyleClass().add("categories");

        List<String> categoryList = Arrays.asList("الكل", "iPhone", "Mac", "iPad", "Watch", "AirPods", "الاكسسوارات");
        
        for (String category : categoryList) {
            Button categoryBtn = new Button(category);
            categoryBtn.getStyleClass().add("category-btn");
            categoryBtn.setOnAction(e -> filterProducts(category.equals("الكل") ? null : category));
            categories.getChildren().add(categoryBtn);
        }
        
        return categories;
    }

    private ScrollPane createProductGrid() {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.getStyleClass().add("product-scroll");

        FlowPane productGrid = new FlowPane();
        productGrid.setPadding(new Insets(20));
        productGrid.setHgap(20);
        productGrid.setVgap(20);
        productGrid.setAlignment(Pos.TOP_CENTER);

        for (Product product : products) {
            VBox productCard = createProductCard(product);
            productGrid.getChildren().add(productCard);
        }

        scrollPane.setContent(productGrid);
        return scrollPane;
    }

    private VBox createProductCard(Product product) {
        VBox card = new VBox(10);
        card.getStyleClass().add("product-card");
        card.setAlignment(Pos.TOP_CENTER);
        card.setPadding(new Insets(15));
        card.setPrefWidth(280);

        // Product image
        ImageView productImage = new ImageView(new Image(product.getImageUrl()));
        productImage.setFitWidth(220);
        productImage.setFitHeight(220);
        productImage.setPreserveRatio(true);

        // Product name
        Label nameLabel = new Label(product.getName());
        nameLabel.getStyleClass().add("product-name");
        nameLabel.setWrapText(true);
        nameLabel.setMaxWidth(220);

        // Product price
        Label priceLabel = new Label(String.format("%,.2f ر.س", product.getPrice()));
        priceLabel.getStyleClass().add("product-price");

        // Rating stars
        HBox ratingBox = new HBox(5);
        ratingBox.setAlignment(Pos.CENTER);
        
        int fullStars = (int) product.getRating();
        boolean hasHalfStar = product.getRating() - fullStars >= 0.5;
        
        for (int i = 0; i < 5; i++) {
            ImageView star;
            if (i < fullStars) {
                star = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/3/34/Red_star.svg"));
            } else if (i == fullStars && hasHalfStar) {
                star = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/3/32/Half_Star.svg/1024px-Half_Star.svg.png"));
            } else {
                star = new ImageView(new Image("https://upload.wikimedia.org/wikipedia/commons/4/4a/Star_rating_0_of_5.png"));
            }
            star.setFitWidth(15);
            star.setFitHeight(15);
            ratingBox.getChildren().add(star);
        }

        // Add to cart button
        Button addToCartBtn = new Button("أضف إلى السلة");
        addToCartBtn.getStyleClass().add("add-to-cart");
        addToCartBtn.setOnAction(e -> addToCart(product));

        card.getChildren().addAll(productImage, nameLabel, priceLabel, ratingBox, addToCartBtn);
        return card;
    }

    private void filterProducts(String category) {
        ScrollPane productGrid = createProductGrid();
        if (category != null) {
            FlowPane flowPane = (FlowPane) productGrid.getContent();
            flowPane.getChildren().clear();
            
            products.stream()
                   .filter(p -> p.getCategory().equals(category))
                   .forEach(p -> flowPane.getChildren().add(createProductCard(p)));
        }
        
        contentPane.getChildren().set(0, productGrid);
    }

    private void addToCart(Product product) {
        boolean found = false;
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.increaseQuantity();
                found = true;
                break;
            }
        }
        
        if (!found) {
            cartItems.add(new CartItem(product, 1));
        }
        
        updateCartBadge();
        showToast("تمت إضافة المنتج إلى السلة");
    }

    private void updateCartBadge() {
        int totalItems = cartItems.stream().mapToInt(CartItem::getQuantity).sum();
        cartBadge.setText(String.valueOf(totalItems));
        cartBadge.setVisible(totalItems > 0);
    }

    private void showCart() {
        VBox cartView = new VBox(20);
        cartView.setPadding(new Insets(20));
        cartView.getStyleClass().add("cart-view");

        Label title = new Label("سلة التسوق");
        title.getStyleClass().add("cart-title");

        if (cartItems.isEmpty()) {
            Label emptyLabel = new Label("سلة التسوق فارغة");
            emptyLabel.getStyleClass().add("empty-cart");
            cartView.getChildren().addAll(title, emptyLabel);
        } else {
            double total = cartItems.stream()
                                   .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                                   .sum();

            TableView<CartItem> cartTable = new TableView<>();
            cartTable.getStyleClass().add("cart-table");
            cartTable.setItems(cartItems);

            // Product column
            TableColumn<CartItem, String> productCol = new TableColumn<>("المنتج");
            productCol.setCellValueFactory(cell -> cell.getValue().getProduct().nameProperty());
            productCol.setPrefWidth(200);

            // Price column
            TableColumn<CartItem, String> priceCol = new TableColumn<>("السعر");
            priceCol.setCellValueFactory(cell -> 
                new SimpleStringProperty(String.format("%,.2f ر.س", cell.getValue().getProduct().getPrice())));
            priceCol.setPrefWidth(100);

            // Quantity column
            TableColumn<CartItem, Integer> quantityCol = new TableColumn<>("الكمية");
            quantityCol.setCellValueFactory(cell -> cell.getValue().quantityProperty().asObject());
            quantityCol.setPrefWidth(100);

            // Total column
            TableColumn<CartItem, String> totalCol = new TableColumn<>("الإجمالي");
            totalCol.setCellValueFactory(cell -> 
                new SimpleStringProperty(String.format("%,.2f ر.س", 
                    cell.getValue().getProduct().getPrice() * cell.getValue().getQuantity())));
            totalCol.setPrefWidth(120);

            cartTable.getColumns().addAll(productCol, priceCol, quantityCol, totalCol);

            // Checkout section
            HBox checkoutBox = new HBox(20);
            checkoutBox.setAlignment(Pos.CENTER_RIGHT);
            
            Label totalLabel = new Label(String.format("المجموع: %,d منتجات - %,d ر.س", 
                cartItems.stream().mapToInt(CartItem::getQuantity).sum(), 
                (int) Math.round(total)));
            totalLabel.getStyleClass().add("total-label");
            
            Button checkoutBtn = new Button("إتمام الشراء");
            checkoutBtn.getStyleClass().add("checkout-btn");
            
            checkoutBox.getChildren().addAll(totalLabel, checkoutBtn);

            cartView.getChildren().addAll(title, cartTable, checkoutBox);
        }

        // Back button
        Button backBtn = new Button("العودة إلى المتجر");
        backBtn.getStyleClass().add("back-btn");
        backBtn.setOnAction(e -> contentPane.getChildren().set(0, createProductGrid()));

        cartView.getChildren().add(backBtn);
        contentPane.getChildren().set(0, cartView);
    }

    private void showToast(String message) {
        Label toast = new Label(message);
        toast.getStyleClass().add("toast");
        toast.setAlignment(Pos.CENTER);
        toast.setPadding(new Insets(10));
        
        StackPane toastPane = new StackPane(toast);
        toastPane.setAlignment(Pos.BOTTOM_CENTER);
        toastPane.setPadding(new Insets(0, 0, 30, 0));
        
        StackPane rootPane = (StackPane) contentPane;
        rootPane.getChildren().add(toastPane);
        
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                javafx.application.Platform.runLater(() -> rootPane.getChildren().remove(toastPane));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}