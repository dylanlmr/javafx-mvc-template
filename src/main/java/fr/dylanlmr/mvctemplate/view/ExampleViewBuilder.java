package fr.dylanlmr.mvctemplate.view;

import fr.dylanlmr.mvctemplate.model.ExampleModel;
import fr.dylanlmr.mvctemplate.view.controller.ExampleViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;
import javafx.util.Builder;

import java.io.IOException;
import java.util.function.Consumer;

public class ExampleViewBuilder implements Builder<Region> {
    private final ExampleModel.PresentationModel pModel;
    private final Consumer<Runnable> longTaskHandler;

    public ExampleViewBuilder(ExampleModel.PresentationModel pModel, Consumer<Runnable> longTaskHandler) {
        this.pModel = pModel;
        this.longTaskHandler = longTaskHandler;
    }

    @Override
    public Region build() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/dylanlmr/mvctemplate/example-view.fxml"));
        fxmlLoader.setController(new ExampleViewController(pModel, longTaskHandler));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
