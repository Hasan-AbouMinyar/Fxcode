/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FullPerspectiveTransformExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox mainLayout = new VBox(50);
        mainLayout.setPadding(new Insets(40));
        mainLayout.setAlignment(Pos.CENTER);

        // --- 1. تطبيق المثال الرئيسي من الصورة (مشاركة التأثير) ---
        mainLayout.getChildren().add(createSectionLabel("1. المثال الرئيسي من الصورة (مشاركة التأثير)"));
        
        // إنشاء التأثير كما في الصورة
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(10.0); pt.setUly(10.0);
        pt.setUrx(310.0); pt.setUry(40.0);
        pt.setLrx(310.0); pt.setLry(60.0);
        pt.setLlx(10.0); pt.setLly(90.0);

        // إنشاء المستطيل والنص
        Rectangle rect1 = new Rectangle(0, 0, 280, 50);
        rect1.setFill(Color.LIGHTBLUE);
        Text text1 = new Text("JavaFX");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        text1.setX(60.0);
        text1.setY(40.0);

        // تطبيق نفس التأثير على كلا العنصرين
        rect1.setEffect(pt);
        text1.setEffect(pt);
        
        Group group1 = new Group(rect1, text1);
        mainLayout.getChildren().add(group1);

        // --- 2. تطبيق المثال الثاني من الصورة ---
        mainLayout.getChildren().add(createSectionLabel("2. المثال الثاني من الصورة"));
        Rectangle rect2 = new Rectangle(200, 100, Color.LIGHTGREEN);
        
        PerspectiveTransform effect = new PerspectiveTransform();
        effect.setUlx(20.0); effect.setUly(50.0);
        effect.setUrx(180.0); effect.setUry(40.0);
        effect.setLrx(219.0); effect.setLry(109.0);
        effect.setLlx(0.0); effect.setLly(120.0);
        
        rect2.setEffect(effect);
        mainLayout.getChildren().add(rect2);
        
        // --- 3. مثال توضيحي لإنشاء منظور حاد (تأثير الطريق) ---
        mainLayout.getChildren().add(createSectionLabel("3. مثال توضيحي لإنشاء منظور حاد"));
        Rectangle rect3 = new Rectangle(250, 100, Color.GRAY);
        
        PerspectiveTransform roadEffect = new PerspectiveTransform();
        // تقريب الزوايا العلوية من بعضها ودفعها للأسفل
        roadEffect.setUlx(75); roadEffect.setUly(0);
        roadEffect.setUrx(175); roadEffect.setUry(0);
        // إبعاد الزوايا السفلية عن بعضها
        roadEffect.setLlx(-20); roadEffect.setLly(100);
        roadEffect.setLrx(270); roadEffect.setLry(100);
        
        rect3.setEffect(roadEffect);
        mainLayout.getChildren().add(rect3);

        // --- الإعداد النهائي للعرض ---
        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 600, 800);
        primaryStage.setTitle("PerspectiveTransform Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // --- دالة مساعدة لإنشاء عنوان للقسم ---
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