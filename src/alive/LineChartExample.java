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
public class LineChartExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // الخطوة 1: تحديد المحاور
        // Defining the x axis
        NumberAxis xAxis = new NumberAxis(2000, 2025, 5);
        xAxis.setLabel("Years");

        // Defining the y axis
        NumberAxis yAxis = new NumberAxis(0, 180, 20);
        yAxis.setLabel("height");

        // الخطوة 2: إنشاء الرسم البياني
        // Creating the line chart
        LineChart linechart = new LineChart(xAxis, yAxis);

        // الخطوة 3: تجهيز سلسلة البيانات
        // Prepare XYChart.Series objects by setting data
        XYChart.Series series = new XYChart.Series();
        series.setName("No of schools in an year");

        series.getData().add(new XYChart.Data(2000, 50));
        series.getData().add(new XYChart.Data(2005, 90));
        series.getData().add(new XYChart.Data(2013, 130));
        series.getData().add(new XYChart.Data(2016, 155));
        series.getData().add(new XYChart.Data(2019, 167));
        series.getData().add(new XYChart.Data(2026, 174));

        // الخطوة 4: إضافة البيانات وعرض الرسم البياني
        // Setting the data to Line chart
        linechart.getData().add(series);

        // Creating a Group object
        Group root = new Group(linechart);

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