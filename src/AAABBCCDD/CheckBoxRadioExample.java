package AAABBCCDD;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxRadioExample extends Application {

    @Override
    public void start(Stage stage) {
        // ✅ CheckBoxes
        CheckBox cb1 = new CheckBox("Java");
        CheckBox cb2 = new CheckBox("Python");
        CheckBox cb3 = new CheckBox("C++");
        cb3.setSelected(true);

        // 🔘 RadioButtons (مع Group عشان يكون اختيار واحد فقط)
        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        RadioButton rb3 = new RadioButton("Monkey");

        ToggleGroup genderGroup = new ToggleGroup();
        rb1.setToggleGroup(genderGroup);
        rb2.setToggleGroup(genderGroup);
        rb3.setToggleGroup(genderGroup);

        // زر لتأكيد الاختيارات
        Button submitBtn = new Button("Submit");
        Label result = new Label();

        submitBtn.setOnAction(e -> {
            StringBuilder output = new StringBuilder("Selected languages: ");

            if (cb1.isSelected()) output.append("Java ");
            if (cb2.isSelected()) output.append("Python ");
            if (cb3.isSelected()) output.append("C++ ");

            output.append("\nSelected gender: ");
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            if (selectedGender != null) {
                output.append(selectedGender.getText());
            } else {
                output.append("None");
            }

            result.setText(output.toString());
        });

        // تنظيم العناصر
        VBox root = new VBox(10, new Label("Choose languages:"), cb1, cb2, cb3,
                new Label("Select gender:"), rb1, rb2, rb3,
                submitBtn, result);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 350);
        stage.setScene(scene);
        stage.setTitle("CheckBox and RadioButton Example");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
