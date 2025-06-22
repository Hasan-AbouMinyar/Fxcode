
package labday;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;


public class redbackground extends Application {
    
    @Override
    public void start(Stage st){
        Group go = new Group();
        Scene se = new Scene(go , 400,400);
        se.setFill(Color.GREEN);
        
        st.setScene(se);
        
        st.show();
        
        
    }
    
    public static void main (String[] args){
        launch();
    }
    
}
