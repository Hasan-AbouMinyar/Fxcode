
package layout;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxTest extends Application {

    @Override
    public void start(Stage stage) {
        // إنشاء العناصر
        Label nameLbl = new Label("Name:");
        TextField nameFld = new TextField();
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");

        // إنشاء حاوية VBox مع تحديد مسافة 10 بكسل بين العناصر
        VBox root = new VBox(10);
        
        // إضافة جميع العناصر إلى حاوية VBox بالترتيب
        root.getChildren().addAll(nameLbl, nameFld, okBtn, cancelBtn);

        // إنشاء المشهد ووضعه في النافذة
        Scene scene = new Scene(root);
        stage.setTitle("Using VBox");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}