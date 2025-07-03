/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AllOne;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class RadialGradientExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // إنشاء حاوية
        Group G = new Group();

        // إنشاء كائن التدرج اللوني الدائري
        // Radial gradient color 
        RadialGradient gradient1 = new RadialGradient(
                90,
                .5,
                .5,
                .5,
                1,
                true,
                CycleMethod.NO_CYCLE,
                new Stop(0, Color.RED),
                new Stop(1, Color.BLACK)); 

        // إنشاء دائرة وتطبيق التدرج عليها
        Circle c1 = new Circle(150, 150, 50); 
        c1.setFill(gradient1);

        G.getChildren().add(c1); 

        // إعداد وعرض النافذة
        Scene scene = new Scene(G, 300, 300);
        primaryStage.setTitle("Radial Gradient!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}