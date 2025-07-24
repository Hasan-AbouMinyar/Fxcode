/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AAABBCCDD;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Side;

public class PieChartExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PieChart pieChart = new PieChart();

        PieChart.Data slice1 = new PieChart.Data("Egypt", 98421139);
        PieChart.Data slice2 = new PieChart.Data("Algeria", 42227376);
        PieChart.Data slice3 = new PieChart.Data("Tunisia", 11565038);
        PieChart.Data slice4 = new PieChart.Data("Libya", 6678435);
        PieChart.Data slice5 = new PieChart.Data("Morocco", 36028537);

        pieChart.getData().addAll(slice1, slice2, slice3, slice4, slice5);

        // بعد إضافة البيانات، ننتظر قليلاً حتى يُبنى الـ Nodes
            slice1.getNode().setOnMouseClicked(e -> {
                // غير لون الخلفية عند الضغط
                slice1.getNode().setStyle("-fx-pie-color: black;"); // لون طماطم مثلاً
            });
        

        pieChart.setLegendSide(Side.LEFT);
        primaryStage.setTitle("List of Arab countries by population");
        StackPane root = new StackPane(pieChart);
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
