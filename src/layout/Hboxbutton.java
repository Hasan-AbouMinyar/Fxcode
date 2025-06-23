
package layout;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Hboxbutton extends Application {

    @Override
    public void start(Stage stage) {
        // Create two buttons
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        
        okBtn.setOnAction((ActionEvent event) -> {
    System.out.println("ok");
});

    

        
        HBox hbox = new HBox(10);

          
        hbox.getChildren().addAll(okBtn, cancelBtn);

        
        hbox.setAlignment(Pos.BOTTOM_RIGHT);

        
        Scene scene = new Scene(hbox, 300, 150);
        stage.setScene(scene);
        stage.setTitle("Using HBox Alignment Property");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}