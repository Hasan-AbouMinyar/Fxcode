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
       red.getData().add(new XYChart.Data(2001,110));
       red.getData().add(new XYChart.Data(2006,150));
       red.getData().add(new XYChart.Data(2009 , 170));
       red.getData().add(new XYChart.Data(2012,200 ));
       red.getData().add(new XYChart.Data(2024, 110));
       
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