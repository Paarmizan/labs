package com.labs.lab4;

import com.labs.lab4.model.Bicycle;
import com.labs.lab4.model.Car;
import com.labs.lab4.model.Motorcycle;
import com.labs.lab4.model.Vehicle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FourthLabApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/labs/lab4/fourth-lab.fxml")
        );

        stage.setScene(new Scene(loader.load()));
        stage.setTitle("Лабораторная работа 4 (JavaFX)");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
