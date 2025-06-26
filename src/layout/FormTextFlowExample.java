/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layout;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class FormTextFlowExample extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء عناصر التحكم المختلفة
        Text txt1 = new Text("I, ");
        RadioButton rb1 = new RadioButton("Mr.");
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Ms.");
        
        // ربط أزرار الراديو معًا
        ToggleGroup group = new ToggleGroup();
        rb1.setToggleGroup(group);
        rb2.setToggleGroup(group);

        TextField nameFld = new TextField();
        nameFld.setPromptText("Your Name");

        Text txt2 = new Text(", acknowledge the receipt of this letter...\n\n");
        
        CheckBox cb1 = new CheckBox("Acknowledge");

        Text txt3 = new Text("\n\nSincerely, \n\n");
        
        Button submitFormBtn = new Button("Submit Form");

        // إنشاء حاوية TextFlow وإضافة كل العناصر (نصوص وعناصر تحكم) بالترتيب
        TextFlow root = new TextFlow(
            txt1, rb1, rb2, nameFld, txt2, cb1, txt3, submitFormBtn
        );

        root.setPrefWidth(350);
        root.setLineSpacing(5);

        // إنشاء المشهد وعرضه
        Scene scene = new Scene(root);
        stage.setTitle("Creating Forms Using TextFlow");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}