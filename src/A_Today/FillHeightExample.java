/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FillHeightExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");

//        // السماح بالأزرار تتمدد عموديًا
//        btn1.setMaxHeight(Double.MAX_VALUE);
//        btn2.setMaxHeight(Double.MAX_VALUE);

        // السماح للزر الثاني يتمدد أفقيًا
        btn2.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(btn2, Priority.ALWAYS);

       
        // إعداد الحاوية
        HBox hbox = new HBox(50, btn1, btn2);
        hbox.setPrefHeight(200);
        hbox.setPadding(new Insets(10));

        Scene scene = new Scene(hbox, 300, 200);
        primaryStage.setTitle("HBox: setHgrow + setFillHeight");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

