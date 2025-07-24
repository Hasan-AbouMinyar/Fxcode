/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء FlowPane مع الاتجاه الأفقي (default)
        FlowPane flowPane = new FlowPane();
        
        // ضبط المسافات بين العناصر
        flowPane.setHgap(10); // المسافة الأفقية 10 بكسل
        flowPane.setVgap(10); // المسافة الرأسية 10 بكسل
        
        // إضافة حشو (Padding) داخلي 20 بكسل حول المحتوى
        flowPane.setPadding(new Insets(20));
        
        // إضافة أزرار إلى FlowPane
        for (int i = 1; i <= 15; i++) {
            Button button = new Button("Button " + i);
            flowPane.getChildren().add(button);
        }
        
        // إنشاء المشهد ووضعه على المسرح
        Scene scene = new Scene(flowPane, 100, 200);
        stage.setTitle("FlowPane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
