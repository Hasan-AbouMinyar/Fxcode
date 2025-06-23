/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class BasicTextFlowExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء ثلاثة عناصر Text بتنسيقات مختلفة
        Text txt1 = new Text("TextFlow layout pane is cool! ");
        txt1.setFill(Color.RED); // اللون أحمر

        Text txt2 = new Text("It supports rich text display.");
        txt2.setFont(Font.font("Arial", FontWeight.BOLD, 12)); // خط عريض

        Text txt3 = new Text("\nThis is a new paragraph, which was " +
                            "created using the \\n newline character.");
        txt3.setFill(Color.BLUE); // اللون أزرق

        // إنشاء حاوية TextFlow ووضع عناصر النص بداخلها
        TextFlow root = new TextFlow(txt1, txt2, txt3);
        root.setPrefWidth(300);   // تحديد عرض مفضل للحاوية (يسبب التفاف النص)
        root.setLineSpacing(5);   // تحديد المسافة بين السطور

        // إنشاء المشهد وعرضه
        Scene scene = new Scene(root);
        stage.setTitle("Using TextFlow");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}