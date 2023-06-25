package fr.dylanlmr.mvctemplate.controller;

import fr.dylanlmr.mvctemplate.model.ExampleModel;
import fr.dylanlmr.mvctemplate.view.ExampleViewBuilder;
import javafx.concurrent.Task;
import javafx.scene.layout.Region;

public class ExampleController {
    private final ExampleViewBuilder view;
    private final ExampleModel model = new ExampleModel();

    public ExampleController() {
        view = new ExampleViewBuilder(model.getPresentationModel(), this::startLongTask);
    }

    private void startLongTask(Runnable runnable) {
        Task<Void> task = new Task<>() {
            @Override
            protected Void call() throws Exception {
                model.doSomethingLong();
                return null;
            }
        };
        task.setOnSucceeded(event -> {
            model.integrateLongTaskResults();
            runnable.run();
        });
        new Thread(task).start();
    }

    public Region getView() {
        return view.build();
    }
}
