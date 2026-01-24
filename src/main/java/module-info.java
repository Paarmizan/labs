module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.labs.lab2.controller to javafx.fxml;
    exports com.labs.lab2;

    opens com.labs.lab3 to javafx.fxml, javafx.graphics;
    exports com.labs.lab3;
}