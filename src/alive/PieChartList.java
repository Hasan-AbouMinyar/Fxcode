/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alive;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PieChartList extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // الخطوة 1: تجهيز البيانات
        // preparing Observablelist object
        
        ObservableList<PieChart.Data> fullname = FXCollections.observableArrayList(
                new PieChart.Data("Hasan",50),
                new PieChart.Data("Ahmed",17),
                new PieChart.Data("Boulqasme", 17),
                new PieChart.Data("AbouMinyar",17)
        );
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Egypt", 98421139),       //
                new PieChart.Data("Algeria", 42227376),     //
                new PieChart.Data("Tunisia", 11565038),     //
                new PieChart.Data("Libya", 6678435),        //
                new PieChart.Data("Morocco", 36028537));    //

        // الخطوة 2: إنشاء الرسم البياني
        // creating pie chart
        PieChart pieChart = new PieChart(fullname);

        // الخطوة 3: تخصيص مظهر الرسم البياني
        // setting visible labels of pie chart
        pieChart.setLabelsVisible(true);
        // setting visible Legend of pie chart
        pieChart.setLegendVisible(true);
        // setting lenght of label line
        pieChart.setLabelLineLength(20);
        // setting direction to arrange the data
        pieChart.setClockwise(true);
        // setting startangle of pre chart
        pieChart.setStartAngle(90);
        // setting position of legend
        pieChart.setLegendSide(Side.RIGHT);
        // setting title of pie chart
        pieChart.setTitle("List of Middle East countries by population");

        // الخطوة 4: عرض الرسم البياني على النافذة
        StackPane root = new StackPane(pieChart); //
        Scene scene = new Scene(root, 400, 200); //
        // setting title of stage
        primaryStage.setTitle("List of Arab countries by population");
        primaryStage.setScene(scene); //
        primaryStage.show(); //
    }

    public static void main(String[] args) {
        launch(args);
    }
}