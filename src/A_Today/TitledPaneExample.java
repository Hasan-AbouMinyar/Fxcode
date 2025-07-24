/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package A_Today;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// The class name is not visible in the image, so I've named it TitledPaneExample
public class TitledPaneExample extends Application {
    @Override
    public void start(Stage stage) {
        TextField firstNameFld = new TextField();
        firstNameFld.setPrefColumnCount(8);
        TextField lastNameFld = new TextField();
        lastNameFld.setPrefColumnCount(8);
        DatePicker dob = new DatePicker();
        dob.setPrefWidth(150);

        GridPane grid = new GridPane();
        grid.addRow(0, new Label("First Name:"), firstNameFld);
        grid.addRow(1, new Label("Last Name:"), lastNameFld);
        grid.addRow(2, new Label("DOB:"), dob);
        grid.setVgap(10);

//        TitledPane infoPane = new TitledPane();
//        infoPane.setText("Personal Info");
//        infoPane.setContent(grid);
            TitledPane go  = new TitledPane();
            go.setText("fuct it ");
            go.setContent(grid);
            
            
            

        // Load the image and set it as a graphic for the TitledPane
//        Image image = new Image(getClass().getResourceAsStream("icon.png"));
//        ImageView iv = new ImageView(image);
//        infoPane.setGraphic(iv);

        go.setCollapsible(true);
        go.setExpanded(false);

        HBox root = new HBox(go);
        Scene scene = new Scene(root, 250, 187);

        stage.setScene(scene);
        stage.setTitle("Using TitledPane Controls");
        stage.show();
    }

    // Standard main method to launch the application
    public static void main(String[] args) {
        launch(args);
    }
}