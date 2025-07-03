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
import javafx.scene.effect.Shadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FullShadowEffectExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // --- الإعداد العام ---
        VBox mainLayout = new VBox(40);
        mainLayout.setPadding(new Insets(30));
        mainLayout.setAlignment(Pos.CENTER);

        // --- 1. المثال الأول: الظل الأساسي وتأثير نصف القطر (radius) ---
        mainLayout.getChildren().add(createSectionLabel("1. الظل الأساسي (باستخدام Radius و Color)"));
        
        // استخدام المُنشئ: Shadow(radius, color)
        Shadow basicShadow = new Shadow(20, Color.DEEPPINK);
        Rectangle rect1 = createStyledRectangle(Color.LIGHTGRAY);
        rect1.setEffect(basicShadow);
        mainLayout.getChildren().add(createTitledNode(rect1, "Shadow(20, Color.DEEPPINK)"));

        // --- 2. المثال الثاني: المقارنة بين أنواع التمويه (BlurType) ---
        mainLayout.getChildren().add(createSectionLabel("2. المقارنة بين أنواع التمويه (BlurType)"));
        HBox blurTypeBox = new HBox(40);
        blurTypeBox.setAlignment(Pos.CENTER);

        Rectangle r1 = createStyledRectangle(Color.LIGHTGRAY);
        Shadow shadowGaussian = new Shadow(15, Color.GREEN);
        shadowGaussian.setBlurType(BlurType.GAUSSIAN);
        r1.setEffect(shadowGaussian);

        Rectangle r2 = createStyledRectangle(Color.LIGHTGRAY);
        Shadow shadowOnePass = new Shadow(15, Color.GREEN);
        shadowOnePass.setBlurType(BlurType.ONE_PASS_BOX);
        r2.setEffect(shadowOnePass);

        blurTypeBox.getChildren().addAll(
            createTitledNode(r1, "BlurType.GAUSSIAN"),
            createTitledNode(r2, "BlurType.ONE_PASS_BOX")
        );
        mainLayout.getChildren().add(blurTypeBox);

        // --- 3. المثال الثالث: تطبيق المثال من الصورة ---
        mainLayout.getChildren().add(createSectionLabel("3. تطبيق المثال من الصورة"));
        
        Text t1 = new Text("Shadow Effect");
        t1.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        
        Shadow sh = new Shadow();
        sh.setRadius(10);
        sh.setColor(Color.BLUE);
        sh.setHeight(100);
        sh.setBlurType(BlurType.ONE_PASS_BOX);
        
        t1.setEffect(sh);
        mainLayout.getChildren().add(t1);

        // --- الإعداد النهائي للعرض ---
        ScrollPane scrollPane = new ScrollPane(mainLayout);
        scrollPane.setFitToWidth(true);
        Scene scene = new Scene(scrollPane, 600, 600);
        primaryStage.setTitle("Shadow Effect Comprehensive Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // --- دوال مساعدة ---
    private Rectangle createStyledRectangle(Color color) {
        return new Rectangle(120, 70, color);
    }
    private VBox createTitledNode(Node node, String title) {
        VBox box = new VBox(5, new Label(title), node);
        box.setAlignment(Pos.CENTER);
        return box;
    }
    private Label createSectionLabel(String title) {
        Label label = new Label(title);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        label.setPadding(new Insets(15, 0, 5, 0));
        return label;
    }

    public static void main(String[] args) {
        launch(args);
    }
}