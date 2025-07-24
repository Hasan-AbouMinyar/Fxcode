/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAABBCCDD;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ScatterChartExampleGPT extends Application {

    @Override
    public void start(Stage stage) {
        NumberAxis xAxis = new NumberAxis(2010, 2030, 5);
        xAxis.setLabel("السنة");

        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        yAxis.setLabel("النسبة (%)");

        ScatterChart<Number, Number> scatterChart = new ScatterChart<>(xAxis, yAxis);
        scatterChart.setTitle("نسبة النمو السكاني");

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("مصر");

        series.getData().add(new XYChart.Data<>(2015, 90));
        series.getData().add(new XYChart.Data<>(2020, 92));
        series.getData().add(new XYChart.Data<>(2025, 95));

        scatterChart.getData().add(series);

        Scene scene = new Scene(scatterChart, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Scatter Chart Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
