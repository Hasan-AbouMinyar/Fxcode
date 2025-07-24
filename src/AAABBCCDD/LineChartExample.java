/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAABBCCDD;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

// The class name is not visible in the image, so it has been assumed.
public class LineChartExample extends Application {
    
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart");
        
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");

        //creating the chart
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Dollar increase rate, 2010");

        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Dollar $");

        //populating the series with data
        series.getData().add(new XYChart.Data(1, 3.5));
        series.getData().add(new XYChart.Data(2, 4.1));
        series.getData().add(new XYChart.Data(3, 4.3));
        series.getData().add(new XYChart.Data(4, 4.5));
        series.getData().add(new XYChart.Data(5, 5.0));
        series.getData().add(new XYChart.Data(6, 5.7));
        series.getData().add(new XYChart.Data(7, 6.2));
        series.getData().add(new XYChart.Data(8, 4.7));
        series.getData().add(new XYChart.Data(9, 4.8));
        series.getData().add(new XYChart.Data(10, 5.0));
        series.getData().add(new XYChart.Data(11, 5.9));
        series.getData().add(new XYChart.Data(12, 6.0));
        
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}