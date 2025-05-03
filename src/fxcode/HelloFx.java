package fxcode;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // إنشاء مجموعة وScene
        Group first = new Group();
        Scene sacand = new Scene(first, Color.YELLOW);

        // إضافة الأيقونة
        Image logo = new Image("/fxcode/logo.png");
        stage.getIcons().add(logo);

        // تعيين المشهد أولاً
        stage.setScene(sacand);
        stage.setTitle("yellow scene");
        
        
//        stage.setWidth(600);
//        stage.setHeight(600);
//      
//        stage.setX(50);
//        stage.setY(50);

        

        // تعيين إعدادات الخروج من fullscreen
        stage.setFullScreenExitHint("You have to hit H key on your keyboard");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("H"));

        // تفعيل fullscreen بعد تعيين المشهد
        stage.setFullScreen(true);

        // إظهار الشاشة
        stage.show();
    }
}
