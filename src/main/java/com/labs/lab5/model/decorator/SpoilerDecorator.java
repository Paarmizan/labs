package com.labs.lab5.model.decorator;

import com.labs.lab5.model.VehicleComponent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SpoilerDecorator extends VehicleDecorator {

    public SpoilerDecorator(VehicleComponent vehicle) {
        super(vehicle);
    }

    @Override
    public void operation(Pane pane) {
        super.operation(pane);

        Rectangle spoiler = new Rectangle(
                70,
                140,
                60,
                8
        );
        spoiler.setFill(Color.BLACK);
        pane.getChildren().add(spoiler);
    }

    @Override
    public String decorate() {
        return vehicle.decorate() + ", спойлер";
    }

    @Override
    public float cost() {
        return vehicle.cost() + 1200;
    }
}
