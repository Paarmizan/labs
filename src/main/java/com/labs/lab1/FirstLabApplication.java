package com.labs.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstLabApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//      Задание 1
//        FXMLLoader fxmlLoader = new FXMLLoader(com.labs.lab1.FirstLabApplication.class.getResource("first-lab.fxml"));
//      Задание 2
        FXMLLoader fxmlLoader = new FXMLLoader(com.labs.lab1.FirstLabApplication.class.getResource("first-lab-individual-task.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Лабораторная работа 1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}