package fr.dylanlmr.mvctemplate.view.controller;

import fr.dylanlmr.mvctemplate.model.ExampleModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class ExampleViewController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button welcomeButton;

    private final ExampleModel.PresentationModel pModel;
    private final Consumer<Runnable> longTaskHandler;

    public ExampleViewController(ExampleModel.PresentationModel pModel, Consumer<Runnable> longTaskHandler) {
        this.pModel = pModel;
        this.longTaskHandler = longTaskHandler;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        welcomeText.textProperty().bind(pModel.welcomeTextProperty());
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeButton.setDisable(true);
        longTaskHandler.accept(() -> welcomeButton.setDisable(false));
    }
}