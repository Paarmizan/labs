package com.labs.lab5.model.decorator;

import com.labs.lab5.model.VehicleComponent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HeadlightsDecorator extends VehicleDecorator {

    public HeadlightsDecorator(VehicleComponent vehicle) {
        super(vehicle);
    }

    @Override
    public void operation(Pane pane) {
        super.operation(pane);

        Circle left = new Circle(95, 165, 5, Color.YELLOW);
        Circle right = new Circle(225, 165, 5, Color.YELLOW);

        pane.getChildren().addAll(left, right);
    }

    @Override
    public String decorate() {
        return vehicle.decorate() + ", фары";
    }

    @Override
    public float cost() {
        return vehicle.cost() + 500;
    }
}
