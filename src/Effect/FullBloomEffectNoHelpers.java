
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FullBloomEffectNoHelpers extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- الإعداد العام ---
        VBox mainLayout = new VBox(40);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #333;"); // خلفية داكنة لإظهار التوهج

        // --- الجزء الأول: شرح تأثير عتبة التوهج (Threshold) ---
        
        // إنشاء عنوان للجزء الأول
        Label section1Label = new Label("1. تأثير تغيير عتبة التوهج (Threshold)");
        section1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        section1Label.setTextFill(Color.WHITE);
        section1Label.setPadding(new Insets(15, 0, 5, 0));
        mainLayout.getChildren().add(section1Label);
        
        HBox thresholdBox = new HBox(30);
        thresholdBox.setAlignment(Pos.CENTER);

        // --- Threshold = 0.0 ---
        VBox box1 = new VBox(5);
        box1.setAlignment(Pos.CENTER);
        box1.setStyle("-fx-border-color: white; -fx-padding: 10;");
        Label title1 = new Label("Threshold: 0.0");
        title1.setTextFill(Color.WHITE);
        Text text1 = new Text("Bloom Effect");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        text1.setFill(Color.WHITE);
        Bloom b1 = new Bloom();
        b1.setThreshold(.0);
        text1.setEffect(b1);
        box1.getChildren().addAll(title1, text1);
        
        // --- Threshold = 0.3 ---
        VBox box2 = new VBox(5);
        box2.setAlignment(Pos.CENTER);
        box2.setStyle("-fx-border-color: white; -fx-padding: 10;");
        Label title2 = new Label("Threshold: 0.3");
        title2.setTextFill(Color.WHITE);
        Text text2 = new Text("Bloom Effect");
        text2.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        text2.setFill(Color.WHITE);
        Bloom b2 = new Bloom();
        b2.setThreshold(0.3);
        text2.setEffect(b2);
        box2.getChildren().addAll(title2, text2);

        // --- Threshold = 0.8 ---
        VBox box3 = new VBox(5);
        box3.setAlignment(Pos.CENTER);
        box3.setStyle("-fx-border-color: white; -fx-padding: 10;");
        Label title3 = new Label("Threshold: 0.8");
        title3.setTextFill(Color.WHITE);
        Text text3 = new Text("Bloom Effect");
        text3.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        text3.setFill(Color.WHITE);
        Bloom b3 = new Bloom();
        b3.setThreshold(0.8);
        text3.setEffect(b3);
        box3.getChildren().addAll(title3, text3);

        thresholdBox.getChildren().addAll(box1, box2, box3);
        mainLayout.getChildren().add(thresholdBox);


        // --- الجزء الثاني: تطبيق المثال الثاني من الصورة ---
        
        // إنشاء عنوان للجزء الثاني
        Label section2Label = new Label("2. تطبيق المثال الثاني (مشاركة التأثير)");
        section2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        section2Label.setTextFill(Color.WHITE);
        section2Label.setPadding(new Insets(15, 0, 5, 0));
        mainLayout.getChildren().add(section2Label);
        
        VBox example2Box = new VBox(20);
        example2Box.setAlignment(Pos.CENTER);
        
        Text textNew = new Text("Welcome to Tutorialspoint");
        textNew.setFont(Font.font(null, FontWeight.BOLD, 40));
        textNew.setFill(Color.DARKSEAGREEN);

        Rectangle rectangle = new Rectangle(500, 50);
        rectangle.setFill(Color.TEAL);
        
        Bloom bloom = new Bloom();
        bloom.setThreshold(0.1);
        
        // تطبيق نفس التأثير على النص والمستطيل
        textNew.setEffect(bloom);
        rectangle.setEffect(bloom);
        
        example2Box.getChildren().addAll(textNew, rectangle);
        mainLayout.getChildren().add(example2Box);


        // --- الإعداد النهائي للعرض ---
        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 700, 700);
        primaryStage.setTitle("Bloom Effect Example (No Helpers)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}