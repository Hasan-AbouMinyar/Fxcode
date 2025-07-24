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

public class PieChartExampleGPT extends Application {

    @Override
    public void start(Stage stage) {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
            new PieChart.Data("مصر", 98421139),
            new PieChart.Data("الجزائر", 42227376),
            new PieChart.Data("تونس", 11565038)
        );

        PieChart pieChart = new PieChart(pieChartData);
        pieChart.setTitle("توزيع السكان");

        StackPane root = new StackPane(pieChart);
        Scene scene = new Scene(root, 600, 400);

        stage.setScene(scene);
        stage.setTitle("Pie Chart Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
