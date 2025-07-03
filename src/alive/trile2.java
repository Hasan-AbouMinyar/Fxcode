/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alive;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Marwa
 */
public class trile2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // الخطوة 1: تحديد المحاور
        // Defining the x axis
       NumberAxis y = new NumberAxis(100,300,10);
       y.setLabel(" radiation");
       NumberAxis x = new NumberAxis(2000,2025,5);
       x.setLabel("years");
       
       LineChart lc = new LineChart(x,y);
       
       
       XYChart.Series red = new XYChart.Series();
       
        red.setName("Libya");
        
        // تم تغيير الإحداثيات لرسم الشكل المطلوب
        red.getData().add(new XYChart.Data(2002, 150)); // نقطة البداية المنخفضة على اليسار
        red.getData().add(new XYChart.Data(2006, 150)); // نهاية الجزء المسطح الأيسر وبداية الصعود
        red.getData().add(new XYChart.Data(2008, 280)); // الوصول إلى القمة
        red.getData().add(new XYChart.Data(2013, 280)); // نهاية الجزء المسطح العلوي وبداية الهبوط
        red.getData().add(new XYChart.Data(2015, 150)); // الوصول إلى الجزء المنخفض على اليمين
        red.getData().add(new XYChart.Data(2022, 150)); // نهاية الجزء المسطح الأيمن

        lc.getData().add(red);
       
       lc.getData().add(red);
       
        // Creating a Group object
        Group root = new Group(lc);

        // Creating a scene object
        Scene scene = new Scene(root, 600, 400);

        // Setting title to the Stage
        primaryStage.setTitle("Line Chart");
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