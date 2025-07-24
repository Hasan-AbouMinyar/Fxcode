/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAABBCCDD;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartList extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Preparing the data for the pie chart
        ObservableList<PieChart.Data> piechartData = FXCollections.observableArrayList(
            new PieChart.Data("Egypt", 98421139),
            new PieChart.Data("Iran", 81162788),
            new PieChart.Data("Tunisia", 11565038),
            new PieChart.Data("Libya", 6678559),
            new PieChart.Data("Morocco", 36029057));

        // creating pie chart
        PieChart pieChart = new PieChart(piechartData);

        // making labels of pie chart visible
        pieChart.setLabelsVisible(true);

        // setting length of label line
        pieChart.setLabelLineLength(10);

        // setting direction to arrange the data
        pieChart.setClockwise(true);

        // setting the start angle of the pie chart
        pieChart.setStartAngle(30);
        
        // setting position of legend
        // The line below is commented out in the source image
        // pieChart.setLegendSide(Side.LEFT);

        // setting title of pie chart
        pieChart.setTitle("List of Middle East countries by population");

        // setting title of stage
        primaryStage.setTitle("List of Arab countries by population");

        StackPane root = new StackPane(pieChart);
        Scene scene = new Scene(root, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}
