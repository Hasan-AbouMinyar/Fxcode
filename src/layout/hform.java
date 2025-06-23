
package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class hform extends Application {

    @Override
    public void start(Stage stage) {
        
        
        
        Label des = new Label("des");
        TextArea desc = new TextArea();
        
        desc.setPrefColumnCount(10);
        desc.setPrefRowCount(3);
        
        CheckBox fill = new CheckBox("Fill h");
        fill.setSelected(true);
        
        
        Button ok = new Button("ok");
        Button cn = new Button("cnacel");
        
        cn.setMaxHeight(Double.MAX_VALUE);
        HBox line = new HBox(10);
        
        line.getChildren().addAll(des,desc,fill,ok,cn);
        
        Scene e = new Scene(line);
        stage.setScene(e);
        stage.show();
     }

    public static void main(String[] args) {
        launch(args);
    }
}
       
//        HBox root = new HBox(10);
//
//        
//        Label descLbl = new Label("Description:");
//        TextArea desc = new TextArea();
//
//        
//        desc.setPrefColumnCount(10); // تحديد عدد الأعمدة المفضل
//        desc.setPrefRowCount(3);     // تحديد عدد الصفوف المفضل
//
//        Button okBtn = new Button("OK");
//        Button cancelBtn = new Button("Cancel");
//        cancelBtn.setMaxHeight(Double.MAX_VALUE);
//
//        CheckBox fillHeightCbx = new CheckBox("Fill Height");
//
//       
//        fillHeightCbx.setSelected(true);
//
//        
//        root.getChildren().addAll(descLbl, desc, fillHeightCbx, okBtn, cancelBtn);
//        
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.setTitle("Using HBox Alignment Property"); // العنوان يمكن تغييره ليعكس المحتوى
//        stage.show();
