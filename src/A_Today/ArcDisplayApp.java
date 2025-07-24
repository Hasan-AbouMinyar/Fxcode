/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class ArcDisplayApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(" Arc Stage with 2D ");
        
        // Arc 1: Filled
        Arc A1 = new Arc(0, 0, 50, 100, 0, 90);
        A1.setFill(Color.LIGHTGRAY);

        // Arc 2: Stroked (Open)
        Arc A2 = new Arc(0, 0, 50, 100, 0, 90);
        A2.setFill(Color.TRANSPARENT);
        A2.setStroke(Color.BLACK);

        // Arc 3: Chord Type
        Arc A3 = new Arc(0, 0, 50, 100, 0, 90);
        A3.setFill(Color.TRANSPARENT);
        A3.setStroke(Color.BLACK);
        A3.setType(ArcType.CHORD);

        // Arc 4: Round Type
        Arc A4 = new Arc(0, 0, 50, 100, 0, 90);
        A4.setFill(Color.TRANSPARENT);
        A4.setStroke(Color.BLACK);
        A4.setType(ArcType.ROUND);

        // Arc 5: Filled and Stroked (Round)
        Arc A5 = new Arc(0, 0, 50, 100, 0, 90);
        A5.setFill(Color.GRAY);
        A5.setStroke(Color.BLACK);
        A5.setType(ArcType.ROUND);

        // Layout container
        HBox root = new HBox();
        root.getChildren().addAll(A1, A2, A3, A4, A5);
        
        
        Group amg = new Group();
        Arc amd = new Arc(0, 0, 50, 100, 0, 90);
        amd.setFill(Color.LIGHTGRAY);
        amg.getChildren().addAll(amd,root);
        
        root.setSpacing(20);
        
        // Scene setup
        Scene scene = new Scene(amg, 600, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main method to launch the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}