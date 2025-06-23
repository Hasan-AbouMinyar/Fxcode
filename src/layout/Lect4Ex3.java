/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Lect4Ex3 extends Application {

    @Override
    public void start(Stage stage) {

        // إنشاء حاوية BorderPane
        BorderPane bPane = new BorderPane();
       

        // وضع العناصر في المناطق الخمس للحاوية
        // Setting the top, bottom, center, right and left nodes to the pane
        bPane.setTop(new TextField("Top"));           // المنطقة العلوية
        bPane.setBottom(new TextField("Bottom"));     // المنطقة السفلية
        bPane.setLeft(new TextField("Left"));         // المنطقة اليسرى
        bPane.setRight(new TextField("Right"));       // المنطقة اليمنى
        bPane.setCenter(new TextField("Center"));     // منطقة الوسط

        // إنشاء مشهد بحجم 600x300 ووضع الحاوية فيه
        Scene scene = new Scene(bPane, 600, 300);
        
        // تعديل العنوان ليعكس المحتوى بشكل أفضل
        stage.setTitle("BorderPane Example"); 
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}