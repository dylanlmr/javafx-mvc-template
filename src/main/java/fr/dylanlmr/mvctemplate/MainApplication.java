package fr.dylanlmr.mvctemplate;

import fr.dylanlmr.mvctemplate.controller.ExampleController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new ExampleController().getView(), 320, 240);
        stage.setTitle("MVC Template");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}