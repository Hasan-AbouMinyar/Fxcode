/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Accordion;
import javafx.stage.Stage;

public class AccordionExample extends Application {

    @Override
    public void start(Stage stage) {
        // استدعاء الدوال المساعدة لإنشاء كل لوحة TitledPane
        TitledPane generalPane = getGeneralPane();
        TitledPane addressPane = getAddressPane();
        TitledPane phonePane = getPhonePane();

        // 1. إنشاء الحاوية الرئيسية Accordion
        Accordion root = new Accordion();
        
        // 2. إضافة اللوحات الثلاث إلى Accordion
        root.getPanes().addAll(generalPane, addressPane, phonePane);

        // 3. تحديد اللوحة التي ستكون مفتوحة بشكل افتراضي
        root.setExpandedPane(generalPane);

        // إنشاء المشهد وعرضه
        Scene scene = new Scene(root);
        stage.setTitle("Using Accordion Controls");
        stage.setScene(scene);
        stage.show();
    }

    // دالة مساعدة لإنشاء لوحة المعلومات العامة
    public TitledPane getGeneralPane() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.addRow(0, new Label("First Name:"), new TextField());
        grid.addRow(1, new Label("Last Name:"), new TextField());
        grid.addRow(2, new Label("DOB:"), new DatePicker());

        TitledPane generalPane = new TitledPane("General", grid);
        return generalPane;
    }

    // دالة مساعدة لإنشاء لوحة العنوان
    public TitledPane getAddressPane() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.addRow(0, new Label("Street:"), new TextField());
        grid.addRow(1, new Label("City:"), new TextField());
        grid.addRow(2, new Label("State:"), new TextField());
        grid.addRow(3, new Label("ZIP:"), new TextField());

        TitledPane addressPane = new TitledPane("Address", grid);
        return addressPane;
    }

    // دالة مساعدة لإنشاء لوحة أرقام الهاتف
    public TitledPane getPhonePane() {
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.addRow(0, new Label("Home:"), new TextField());
        grid.addRow(1, new Label("Work:"), new TextField());
        grid.addRow(2, new Label("Cell:"), new TextField());

        TitledPane phonePane = new TitledPane("Phone", grid);
        return phonePane;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}