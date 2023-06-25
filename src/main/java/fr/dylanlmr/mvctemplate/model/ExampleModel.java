package fr.dylanlmr.mvctemplate.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExampleModel {
    private final PresentationModel presentationModel = new PresentationModel();
    private String welcomeText = "Click the button and wait !";

    public ExampleModel() {
        presentationModel.setWelcomeText(welcomeText);
    }

    public void doSomethingLong() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        welcomeText = "Welcome to JavaFX Application !";
    }

    public void integrateLongTaskResults() {
        presentationModel.setWelcomeText(welcomeText);
    }

    public PresentationModel getPresentationModel() {
        return presentationModel;
    }

    public static class PresentationModel {
        private StringProperty welcomeText = new SimpleStringProperty();

        public String getWelcomeText() {
            return welcomeText.get();
        }

        public StringProperty welcomeTextProperty() {
            return welcomeText;
        }

        public void setWelcomeText(String welcomeText) {
            this.welcomeText.set(welcomeText);
        }
    }
}
