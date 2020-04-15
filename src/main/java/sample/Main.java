package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {
        ObjectIO oio = new ObjectIO();
        Interface.generateGUI(primaryStage, oio.readFile());

    }

    public static void main(String[] args) {
        launch(args);
    }
}
