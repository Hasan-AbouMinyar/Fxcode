/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FullDropShadowExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- الإعداد العام ---
        VBox mainLayout = new VBox(30);
        mainLayout.setPadding(new Insets(25));
        mainLayout.setAlignment(Pos.CENTER);

        // --- 1. شرح خاصية الانتشار (Spread) ---
        mainLayout.getChildren().add(createSectionLabel("1. تأثير خاصية Spread"));
        HBox spreadBox = new HBox(40);
        spreadBox.setAlignment(Pos.CENTER);
        
        // Spread = 0.0
        Rectangle r1 = createStyledRectangle(Color.LIGHTGRAY);
        DropShadow s1 = new DropShadow(15, Color.BLACK);
        s1.setSpread(0.0);
        r1.setEffect(s1);
        
        // Spread = 0.5
        Rectangle r2 = createStyledRectangle(Color.LIGHTGRAY);
        DropShadow s2 = new DropShadow(15, Color.BLACK);
        s2.setSpread(0.5);
        r2.setEffect(s2);

        // Spread = 1.0
        Rectangle r3 = createStyledRectangle(Color.LIGHTGRAY);
        DropShadow s3 = new DropShadow(15, Color.BLACK);
        s3.setSpread(1.0);
        r3.setEffect(s3);

        spreadBox.getChildren().addAll(
            createTitledNode(r1, "spread = 0.0"),
            createTitledNode(r2, "spread = 0.5"),
            createTitledNode(r3, "spread = 1.0")
        );
        mainLayout.getChildren().add(spreadBox);

        // --- 2. شرح خاصية نوع التمويه (BlurType) ---
        mainLayout.getChildren().add(createSectionLabel("2. تأثير خاصية BlurType"));
        HBox blurTypeBox = new HBox(20);
        blurTypeBox.setAlignment(Pos.CENTER);
        
        DropShadow baseShadow = new DropShadow(10, 5, 5, Color.BLACK);

        Rectangle b1 = createStyledRectangle(Color.SKYBLUE);
        baseShadow.setBlurType(BlurType.ONE_PASS_BOX);
        b1.setEffect(new DropShadow(10, 5, 5, Color.BLACK){{setBlurType(BlurType.ONE_PASS_BOX);}});

        Rectangle b2 = createStyledRectangle(Color.SKYBLUE);
        b2.setEffect(new DropShadow(10, 5, 5, Color.BLACK){{setBlurType(BlurType.TWO_PASS_BOX);}});
        
        Rectangle b3 = createStyledRectangle(Color.SKYBLUE);
        b3.setEffect(new DropShadow(10, 5, 5, Color.BLACK){{setBlurType(BlurType.THREE_PASS_BOX);}});
        
        Rectangle b4 = createStyledRectangle(Color.SKYBLUE);
        b4.setEffect(new DropShadow(10, 5, 5, Color.BLACK){{setBlurType(BlurType.GAUSSIAN);}});

        blurTypeBox.getChildren().addAll(
            createTitledNode(b1, "ONE_PASS_BOX"),
            createTitledNode(b2, "TWO_PASS_BOX"),
            createTitledNode(b3, "THREE_PASS_BOX"),
            createTitledNode(b4, "GAUSSIAN")
        );
        mainLayout.getChildren().add(blurTypeBox);

        // --- 3. شرح أمثلة الصورة ---
        mainLayout.getChildren().add(createSectionLabel("3. أمثلة من الصور"));
        
        // المثال الأول من الصورة
        Rectangle rectNew = new Rectangle(120, 70, Color.BLUEVIOLET);
        DropShadow dseffect = new DropShadow();
        dseffect.setRadius(10);
        dseffect.setOffsetX(8);
        dseffect.setOffsetY(10);
        dseffect.setSpread(0.2);
        dseffect.setBlurType(BlurType.TWO_PASS_BOX);
        rectNew.setEffect(dseffect);
        mainLayout.getChildren().add(createTitledNode(rectNew, "المثال الأول من الصورة"));
        
        // المثال الثاني من الصورة (مشاركة التأثير)
        Pane sharedEffectPane = new Pane();
        sharedEffectPane.setPrefSize(300, 200);
        
        Text textNew = new Text(50, 50, "Welcome to Lecture 7");
        textNew.setFont(Font.font("null", FontWeight.BOLD, 40));
        textNew.setFill(Color.DARKGREEN);
        
        Circle circleNew = new Circle(100, 150, 50, Color.DARKSLATEGRAY);
        
        DropShadow sharedDropShadow = new DropShadow();
        sharedDropShadow.setRadius(5);
        sharedDropShadow.setOffsetX(8);
        sharedDropShadow.setOffsetY(4);
        sharedDropShadow.setColor(Color.CORNSILK);
        
        textNew.setEffect(sharedDropShadow);
        circleNew.setEffect(sharedDropShadow);
        
        sharedEffectPane.getChildren().addAll(circleNew, textNew);
        mainLayout.getChildren().add(createTitledNode(sharedEffectPane, "المثال الثاني (مشاركة التأثير)"));

        // --- الإعداد النهائي للعرض ---
        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 800, 700);
        primaryStage.setTitle("DropShadow Comprehensive Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // دالة مساعدة لإنشاء مستطيل منسق
    private Rectangle createStyledRectangle(Color color) {
        Rectangle r = new Rectangle(80, 50, color);
        r.setStroke(Color.BLACK);
        return r;
    }
    
    // دالة مساعدة لوضع عنوان فوق الشكل
    private VBox createTitledNode(Node node, String title) {
        VBox box = new VBox(5, new Label(title), node);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    // دالة مساعدة لإنشاء عنوان قسم
    private Label createSectionLabel(String title) {
        Label label = new Label(title);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        label.setPadding(new Insets(20, 0, 10, 0));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}