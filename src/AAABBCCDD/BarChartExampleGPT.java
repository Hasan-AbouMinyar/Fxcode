/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAABBCCDD;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartExampleGPT extends Application {

    @Override
    public void start(Stage stage) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("البلد");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("عدد السكان");

        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        barChart.setTitle("عدد سكان بعض الدول");
        
        BarChart<String ,Number> goo = new BarChart<String, Number>(xAxis,yAxis);
        
        XYChart.Series<String ,Number> fuck = new XYChart.Series<>();
        fuck.setName("fuck");
        fuck.getData().add(new XYChart.Data<>("you",253535));

        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        dataSeries.setName("2025");

        dataSeries.getData().add(new XYChart.Data<>("مصر", 98421139));
        dataSeries.getData().add(new XYChart.Data<>("الجزائر", 42227376));
        dataSeries.getData().add(new XYChart.Data<>("تونس", 11565038));
        XYChart.Series<String, Number> y = new XYChart.Series<>();
        y.setName("fuck");

        y.getData().add(new XYChart.Data<>("d", 98421449));
        y.getData().add(new XYChart.Data<>("c", 46787376));
        y.getData().add(new XYChart.Data<>("m", 115678938));

        barChart.getData().addAll(dataSeries,y);

        Scene scene = new Scene(barChart, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Bar Chart Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
