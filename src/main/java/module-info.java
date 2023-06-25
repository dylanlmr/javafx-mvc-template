module fr.dylanlmr.mvctemplate {
    requires javafx.controls;
    requires javafx.fxml;


    exports fr.dylanlmr.mvctemplate;
    exports fr.dylanlmr.mvctemplate.view.controller;
    opens fr.dylanlmr.mvctemplate.view.controller to javafx.fxml;
    exports fr.dylanlmr.mvctemplate.model;
}