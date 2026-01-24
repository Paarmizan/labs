package com.labs.lab5.controller;

import com.labs.lab5.model.*;
import com.labs.lab5.model.decorator.*;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class FifthLabController implements Initializable {

    public Pane paintPane;
    public Label statusLabel;

    private VehicleComponent vehicle;
    private VehicleComponent decoratedVehicle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // 1️⃣ создаём базовую машину
        vehicle = new CarBase();

        // 2️⃣ на старте декоров нет
        decoratedVehicle = vehicle;

        // 3️⃣ рисуем СРАЗУ
        decoratedVehicle.operation(paintPane);
    }

    public void addHeadlights(ActionEvent e) {
        paintPane.getChildren().clear();

        decoratedVehicle = (decoratedVehicle == null)
                ? new HeadlightsDecorator(vehicle)
                : new HeadlightsDecorator(decoratedVehicle);

        redraw();
    }

    public void addSpoiler(ActionEvent e) {
        paintPane.getChildren().clear();

        decoratedVehicle = (decoratedVehicle == null)
                ? new SpoilerDecorator(vehicle)
                : new SpoilerDecorator(decoratedVehicle);

        redraw();
    }

    private void redraw() {
        decoratedVehicle.operation(paintPane);
        statusLabel.setText(
                decoratedVehicle.decorate() +
                        " | Стоимость: " + decoratedVehicle.cost()
        );
    }
}
