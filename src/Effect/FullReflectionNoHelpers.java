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
import javafx.scene.effect.Reflection;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FullReflectionNoHelpers extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox mainLayout = new VBox(50);
        mainLayout.setPadding(new Insets(40));
        mainLayout.setAlignment(Pos.CENTER);

        // --- 1. شرح خاصية topOffset ---
        Label section1Label = new Label("1. تأثير خاصية topOffset (المسافة)");
        section1Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        section1Label.setPadding(new Insets(20, 0, 10, 0));
        mainLayout.getChildren().add(section1Label);
        
        HBox topOffsetBox = new HBox(50);
        topOffsetBox.setAlignment(Pos.CENTER);

        // مثال التداخل (offset سالب)
        VBox titledNode1 = new VBox(5, new Label("topOffset = -5"));
        titledNode1.setAlignment(Pos.CENTER);
        Text text1 = new Text("Reflection Effect");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        text1.setFill(Color.CORNFLOWERBLUE);
        Reflection r1 = new Reflection();
        r1.setTopOffset(-5);
        r1.setFraction(0.8);
        r1.setTopOpacity(0.5);
        r1.setBottomOpacity(0.1);
        text1.setEffect(r1);
        titledNode1.getChildren().add(text1);

        // مثال الفجوة (offset موجب)
        VBox titledNode2 = new VBox(5, new Label("topOffset = 5"));
        titledNode2.setAlignment(Pos.CENTER);
        Text text2 = new Text("Reflection Effect");
        text2.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        text2.setFill(Color.CORNFLOWERBLUE);
        Reflection r2 = new Reflection();
        r2.setTopOffset(5);
        r2.setFraction(0.8);
        r2.setTopOpacity(0.5);
        r2.setBottomOpacity(0.0);
        text2.setEffect(r2);
        titledNode2.getChildren().add(text2);

        topOffsetBox.getChildren().addAll(titledNode1, titledNode2);
        mainLayout.getChildren().add(topOffsetBox);

        // --- 2. شرح خاصية fraction ---
        Label section2Label = new Label("2. تأثير خاصية fraction (حجم الانعكاس)");
        section2Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        section2Label.setPadding(new Insets(20, 0, 10, 0));
        mainLayout.getChildren().add(section2Label);

        HBox fractionBox = new HBox(50);
        fractionBox.setAlignment(Pos.CENTER);

        VBox titledNode3 = new VBox(5, new Label("fraction = 0.3"));
        titledNode3.setAlignment(Pos.CENTER);
        Text text3 = new Text("Reflection");
        text3.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        text3.setFill(Color.CORNFLOWERBLUE);
        Reflection r3 = new Reflection();
        r3.setFraction(0.3);
        text3.setEffect(r3);
        titledNode3.getChildren().add(text3);

        VBox titledNode4 = new VBox(5, new Label("fraction = 0.9"));
        titledNode4.setAlignment(Pos.CENTER);
        Text text4 = new Text("Reflection");
        text4.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        text4.setFill(Color.CORNFLOWERBLUE);
        Reflection r4 = new Reflection();
        r4.setFraction(0.9);
        text4.setEffect(r4);
        titledNode4.getChildren().add(text4);
        
        fractionBox.getChildren().addAll(titledNode3, titledNode4);
        mainLayout.getChildren().add(fractionBox);

        // --- 3. شرح خصائص الشفافية (Opacity) ---
        Label section3Label = new Label("3. تأثير خصائص الشفافية (Opacity)");
        section3Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        section3Label.setPadding(new Insets(20, 0, 10, 0));
        mainLayout.getChildren().add(section3Label);
        
        HBox opacityBox = new HBox(50);
        opacityBox.setAlignment(Pos.CENTER);

        VBox titledNode5 = new VBox(5, new Label("Fade Out (0.6 -> 0.0)"));
        titledNode5.setAlignment(Pos.CENTER);
        Text text5 = new Text("Fade Out");
        text5.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        text5.setFill(Color.CORNFLOWERBLUE);
        Reflection r5 = new Reflection();
        r5.setTopOpacity(0.6);
        r5.setBottomOpacity(0.0);
        text5.setEffect(r5);
        titledNode5.getChildren().add(text5);

        VBox titledNode6 = new VBox(5, new Label("Solid (0.8 -> 0.5)"));
        titledNode6.setAlignment(Pos.CENTER);
        Text text6 = new Text("Solid");
        text6.setFont(Font.font("Arial", FontWeight.BOLD, 36));
        text6.setFill(Color.CORNFLOWERBLUE);
        Reflection r6 = new Reflection();
        r6.setTopOpacity(0.8);
        r6.setBottomOpacity(0.5);
        text6.setEffect(r6);
        titledNode6.getChildren().add(text6);

        opacityBox.getChildren().addAll(titledNode5, titledNode6);
        mainLayout.getChildren().add(opacityBox);

        // --- 4. تطبيق المثال من الصورة الثالثة ---
        Label section4Label = new Label("4. تطبيق المثال من الصورة الثالثة");
        section4Label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        section4Label.setPadding(new Insets(20, 0, 10, 0));
        mainLayout.getChildren().add(section4Label);

        Text text7 = new Text("Welcome to Lecture 7");
        text7.setFont(Font.font(null, FontWeight.BOLD, 40));
        text7.setFill(Color.DARKRED);
        
        Reflection reflectionFromImage = new Reflection();
        reflectionFromImage.setTopOffset(5);
        reflectionFromImage.setFraction(0.7);
        reflectionFromImage.setTopOpacity(0.5);
        text7.setEffect(reflectionFromImage);
        
        mainLayout.getChildren().add(text7);

        // --- الإعداد النهائي للعرض ---
        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 750, 850);
        primaryStage.setTitle("Reflection Effect (No Helpers)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}