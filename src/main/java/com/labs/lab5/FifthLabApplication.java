package com.labs.lab5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FifthLabApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/com/labs/lab5/lab5-view.fxml")
        );

        Scene scene = new Scene(loader.load());
        stage.setTitle("Лабораторная работа 5 — Декоратор (машины)");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
