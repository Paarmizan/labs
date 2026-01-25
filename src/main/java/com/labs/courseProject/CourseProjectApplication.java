package com.labs.courseProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CourseProjectApplication extends Application {

    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/com/labs/course-project/course-project-view.fxml"
                )
        );

        Scene scene = new Scene(loader.load(), 1500, 600);

        stage.setTitle("Course Project — Учет задач и ресурсов");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
