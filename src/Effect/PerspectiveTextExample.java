/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Effect;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PerspectiveTextExample extends Application {
    @Override
    public void start(Stage stage) {
        // إنشاء نص
        Text text = new Text("JavaFX 3D Text");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        text.setFill(Color.DARKBLUE);

        // تأثير PerspectiveTransform
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(20);    // الزاوية العلوية اليسرى X
        pt.setUly(20);    // الزاوية العلوية اليسرى Y
        pt.setUrx(400);   // الزاوية العلوية اليمنى X
        pt.setUry(0);     // الزاوية العلوية اليمنى Y
        pt.setLlx(0);     // الزاوية السفلية اليسرى X
        pt.setLly(100);   // الزاوية السفلية اليسرى Y
        pt.setLrx(420);   // الزاوية السفلية اليمنى X
        pt.setLry(120);   // الزاوية السفلية اليمنى Y

//        text.setEffect(pt);
         PerspectiveTransform t = new PerspectiveTransform();
         t.setUrx(20);
         t.setUry(20);
         t.setUlx(300);
         t.setUly(60);
         t.setLrx(20);
         t.setLry(100);
         t.setLlx(200);
         t.setLry(100);
              text.setEffect(t);

        // عرض في نافذة
        StackPane root = new StackPane(text);
        Scene scene = new Scene(root, 600, 300, Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.setTitle("PerspectiveTransform on Text");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
