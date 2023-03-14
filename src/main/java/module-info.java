module app.spacerunner {
    requires javafx.controls;
    requires javafx.fxml;


    opens app.spacerunner to javafx.fxml;
    exports app.spacerunner;
}