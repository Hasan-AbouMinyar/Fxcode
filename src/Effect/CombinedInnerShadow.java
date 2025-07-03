/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;
// اسم البكج، قد يختلف لديك

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * هذا الكلاس يجمع مثالين لتأثير الظل الداخلي (InnerShadow) في نافذة واحدة.
 */
public class CombinedInnerShadow extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        VBox root = new VBox(80); 
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);

        // --- المثال الأول: الظل الداخلي المفصل على النص ---
        
        Text t1 = new Text();
        t1.setText("InnerShadow Effect");
        t1.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        t1.setFill(Color.RED);

        InnerShadow iseffect = new InnerShadow();
        iseffect.setRadius(5);
        iseffect.setColor(Color.BLUE);
        iseffect.setOffsetX(7);
        iseffect.setOffsetY(7);
        iseffect.setChoke(0.2);
        iseffect.setBlurType(BlurType.THREE_PASS_BOX);

        t1.setEffect(iseffect);

        // --- المثال الثاني: مشاركة نفس تأثير الظل الداخلي ---
        
        Group sharedEffectGroup = new Group();

        Text textShared = new Text(10, 50, "Welcome to Lecture 7");
        textShared.setFont(Font.font(null, FontWeight.BOLD, 40));
        textShared.setFill(Color.RED);

        Circle circleShared = new Circle(150.0F, 150.0F, 50.0F);
        circleShared.setFill(Color.CORNFLOWERBLUE);
        
        InnerShadow innerShadowShared = new InnerShadow();
        innerShadowShared.setOffsetX(4);
        innerShadowShared.setOffsetY(4);
        innerShadowShared.setColor(Color.GRAY);

        textShared.setEffect(innerShadowShared);
        circleShared.setEffect(innerShadowShared);
        
        sharedEffectGroup.getChildren().addAll(textShared, circleShared);

        // --- إضافة كل الأمثلة إلى الحاوية الرئيسية ---
        root.getChildren().addAll(t1, sharedEffectGroup);

        // --- إعداد وعرض النافذة ---
        Scene scene = new Scene(root, 650, 500);
        primaryStage.setTitle("Combined InnerShadow Examples");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}