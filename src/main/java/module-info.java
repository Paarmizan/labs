module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.labs.lab1 to javafx.fxml, javafx.graphics;
    exports com.labs.lab1;
    exports com.labs.lab1.controller;
    opens com.labs.lab1.controller to javafx.fxml, javafx.graphics;
}