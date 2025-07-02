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

public class trile extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // الخطوة 1: تجهيز البيانات
        // preparing Observablelist object
        
        ObservableList<PieChart.Data> tutorial = FXCollections.observableArrayList(
                new PieChart.Data("sleep", 5),
                new PieChart.Data("coding", 55),
                new PieChart.Data("Gym", 30),
                new PieChart.Data("study", 10)
        );
        
        PieChart cc = new PieChart(tutorial);
        cc.setTitle("This is a fucking life");
        cc.setLegendVisible(true);
        cc.setLegendSide(Side.RIGHT);
        cc.setLabelLineLength(50);
        cc.setStartAngle(0);
        cc.setClockwise(true);

        // الخطوة 4: عرض الرسم البياني على النافذة
        StackPane root = new StackPane(cc); //
        Scene scene = new Scene(root, 400, 400); //
        // setting title of stage
        primaryStage.setTitle("List of Arab countries by population");
        primaryStage.setScene(scene); //
        primaryStage.show(); //
    }

    public static void main(String[] args) {
        launch(args);
    }
}