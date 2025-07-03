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
public class traile extends Application {

    @Override
    public void start(Stage primaryStage) {
         
        
        NumberAxis x = new NumberAxis(2000,2026,5);
        x.setLabel("Years");
        NumberAxis y = new NumberAxis(100,200,5);
        y.setLabel("radiation");
        
        
        LineChart radiation = new LineChart(x,y);
        
        XYChart.Series point = new XYChart.Series();
        
        point.getData().add(new XYChart.Data(2001,105));
        point.getData().add(new XYChart.Data(2003,140));
        point.getData().add(new XYChart.Data(2006,144));
        point.getData().add(new XYChart.Data(2009,147));
        point.getData().add(new XYChart.Data(2011,155));
        point.getData().add(new XYChart.Data(2017,159));
        point.getData().add(new XYChart.Data(2020,160));
        point.getData().add(new XYChart.Data(2022,130));
        point.getData().add(new XYChart.Data(2025,110));
        point.setName("Libya");
        
        radiation.getData().add(point);
        radiation.setTitle(" Radiation Measured");
       
        // Creating a Group object
        Group root = new Group(radiation);

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