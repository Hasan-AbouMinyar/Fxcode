package A_Today;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;

public class exppto extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField tf = new TextField();
        Button btn = new Button();
        btn.setText("Add");
        TextField tf2 = new TextField();
        Button btn2 = new Button();
        btn2.setText("Mul");
        Text t = new Text("Result:");
        Text here = new Text("");
     
        

        // Add button event handler with error handling
        btn.setOnAction(e -> {
            try {
                double f = Double.parseDouble(tf.getText());
                double s = Double.parseDouble(tf2.getText());
                double sum = f + s;
                here.setText(String.valueOf(sum));
            } catch (NumberFormatException ex) {
                // This block runs if the text is not a valid number
                here.setText("Please enter valid numbers");
            }
        });

        // Multiply button event handler with error handling
        btn2.setOnAction(e -> {
            try {
                double f = Double.parseDouble(tf.getText());
                double s = Double.parseDouble(tf2.getText());
                double mul = f * s;
                here.setText(String.valueOf(mul));
            } catch (NumberFormatException ex) {
                // This block runs if the text is not a valid number
                here.setText("Please enter valid numbers");
            }
        });

        HBox one = new HBox();
        one.getChildren().addAll(tf, btn);
        HBox two = new HBox();
        two.getChildren().addAll(tf2, btn2);
        HBox three = new HBox();
        three.getChildren().addAll(t, here);

        one.setSpacing(10);
        two.setSpacing(10);
        three.setSpacing(10);

        VBox form = new VBox(10); // الفورم فقط
        form.getChildren().addAll(one, two, three);
        form.setAlignment(Pos.CENTER);

        StackPane root = new StackPane(form); // نخلي الفورم داخل StackPane

        Scene scene = new Scene(root, 300, 150); // Adjusted height for better fit
        primaryStage.setTitle("Simple Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
