package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
//        ObjectIO oio = new ObjectIO("C:\\Users\\David\\Desktop\\test.txt"); // demonstrates usage with different file
        ObjectIO oio = new ObjectIO(AppConfig.filepath);
        Interface.generateGUI(primaryStage, oio.readFile(),oio);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
