module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.labs.lab1 to javafx.fxml, javafx.graphics;
    exports com.labs.lab1;
    exports com.labs.lab1.controller;
    opens com.labs.lab1.controller to javafx.fxml, javafx.graphics;

    opens com.labs.lab2 to javafx.fxml, javafx.graphics;
    exports com.labs.lab2;
    exports com.labs.lab2.controller;
    opens com.labs.lab2.controller to javafx.fxml, javafx.graphics;

    opens com.labs.lab3 to javafx.fxml, javafx.graphics;
    exports com.labs.lab3;
}