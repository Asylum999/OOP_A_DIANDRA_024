package Task.Module4.gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        LoginPane.show(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}