/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneOrientationExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء الأزرار
        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");

        // إنشاء حاوية FlowPane
        FlowPane flowPane = new FlowPane();

        // تحديد الفجوات الأفقية والعمودية
        flowPane.setHgap(25);
        flowPane.setVgap(25);

        // تحديد هامش للزر الأول فقط
        flowPane.setMargin(button1, new Insets(20, 0, 20, 20));

        // إضافة الأزرار إلى الحاوية
        flowPane.getChildren().addAll(button1, button2, button3, button4);
        
        // إنشاء المشهد وعرضه
        Scene scene = new Scene(flowPane);
        stage.setTitle("Flow Pane Example");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}