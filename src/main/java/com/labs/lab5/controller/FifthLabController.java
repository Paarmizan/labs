package com.labs.lab5.controller;

import com.labs.lab5.model.*;
import com.labs.lab5.model.decorator.*;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class FifthLabController implements Initializable {

    public Pane paintPane;
    public Label statusLabel;

    public CheckBox spoilerCheckBox;
    public CheckBox headlightsCheckBox;

    private VehicleComponent baseVehicle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        baseVehicle = new CarBase();

        rebuildAndRedraw();
    }

    public void onOptionsChanged() {
        rebuildAndRedraw();
    }

    private void rebuildAndRedraw() {

        VehicleComponent decoratedVehicle = baseVehicle;

        if (headlightsCheckBox.isSelected()) {
            decoratedVehicle = new HeadlightsDecorator(decoratedVehicle);
        }

        if (spoilerCheckBox.isSelected()) {
            decoratedVehicle = new SpoilerDecorator(decoratedVehicle);
        }

        paintPane.getChildren().clear();
        decoratedVehicle.operation(paintPane);

        statusLabel.setText(
                decoratedVehicle.decorate() +
                        " | Стоимость: " + decoratedVehicle.cost()
        );
    }
}
