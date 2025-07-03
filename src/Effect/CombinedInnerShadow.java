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
        
        // --- الإعداد العام للحاوية الرئيسية ---
        // VBox لترتيب المثالين بشكل عمودي مع تباعد بينهما
        VBox root = new VBox(80); 
        root.setPadding(new Insets(50)); // هوامش داخلية
        root.setAlignment(Pos.CENTER); // محاذاة العناصر في المنتصف

        // --- المثال الأول: الظل الداخلي المفصل على النص ---
        
        [cite_start]// إنشاء عنصر النص [cite: 1]
        Text t1 = new Text();
        t1.setText("InnerShadow Effect"); [cite_start]// تحديد النص [cite: 1]
        t1.setFont(Font.font("Arial", FontWeight.BOLD, 40)); [cite_start]// تحديد الخط [cite: 1]
        t1.setFill(Color.RED); [cite_start]// تحديد لون النص [cite: 1]

        [cite_start]// إنشاء كائن الظل الداخلي [cite: 1]
        InnerShadow iseffect = new InnerShadow();
        
        [cite_start]// تحديد خصائص الظل الداخلي كما في الصورة [cite: 1]
        iseffect.setRadius(5); [cite_start]// نصف قطر التمويه [cite: 1]
        iseffect.setColor(Color.BLUE); [cite_start]// لون الظل [cite: 1]
        iseffect.setOffsetX(7); [cite_start]// الإزاحة الأفقية للظل [cite: 1]
        iseffect.setOffsetY(7); [cite_start]// الإزاحة العمودية للظل [cite: 1]
        iseffect.setChoke(0.2); [cite_start]// تحديد مدى "اختناق" أو كثافة الظل قبل التمويه [cite: 1]
        iseffect.setBlurType(BlurType.THREE_PASS_BOX); [cite_start]// تحديد خوارزمية التمويه [cite: 1]

        [cite_start]// تطبيق التأثير على النص [cite: 1]
        t1.setEffect(iseffect);

        // --- المثال الثاني: مشاركة نفس تأثير الظل الداخلي ---
        
        // Group لوضع العناصر التي لها إحداثيات محددة
        Group sharedEffectGroup = new Group();

        [cite_start]// إنشاء عنصر النص الثاني [cite: 1]
        Text textShared = new Text(10, 50, "Welcome to Lecture 7");
        textShared.setFont(Font.font(null, FontWeight.BOLD, 40)); [cite_start]// تحديد الخط [cite: 1]
        textShared.setFill(Color.RED); [cite_start]// تحديد اللون [cite: 1]

        [cite_start]// إنشاء عنصر الدائرة [cite: 1]
        Circle circleShared = new Circle(150.0F, 150.0F, 50.0F);
        circleShared.setFill(Color.CORNFLOWERBLUE); [cite_start]// تحديد لون التعبئة [cite: 1]
        
        [cite_start]// إنشاء كائن ظل داخلي واحد فقط لمشاركته [cite: 1]
        InnerShadow innerShadowShared = new InnerShadow();
        innerShadowShared.setOffsetX(4); [cite_start]// الإزاحة الأفقية [cite: 1]
        innerShadowShared.setOffsetY(4); [cite_start]// الإزاحة العمودية [cite: 1]
        innerShadowShared.setColor(Color.GRAY); [cite_start]// لون الظل [cite: 1]

        [cite_start]// تطبيق نفس كائن الظل على كلا العنصرين [cite: 1]
        textShared.setEffect(innerShadowShared);
        circleShared.setEffect(innerShadowShared);
        
        // إضافة العناصر إلى حاوية Group
        sharedEffectGroup.getChildren().addAll(textShared, circleShared);

        // --- إضافة كل الأمثلة إلى الحاوية الرئيسية ---
        root.getChildren().addAll(t1, sharedEffectGroup);

        // --- إعداد وعرض النافذة ---
        Scene scene = new Scene(root, 650, 500);
        primaryStage.setTitle("Combined InnerShadow Examples");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}