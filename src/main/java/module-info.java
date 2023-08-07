module bmr.maati.bmdjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens bmr.maati to javafx.fxml;
    exports bmr.maati.Main;
    opens bmr.maati.Main to javafx.fxml;
}