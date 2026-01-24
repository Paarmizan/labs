package com.labs.lab5.model.decorator;

import com.labs.lab5.model.VehicleComponent;
import javafx.scene.layout.Pane;

public abstract class VehicleDecorator implements VehicleComponent {

    protected VehicleComponent vehicle;

    public VehicleDecorator(VehicleComponent vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void operation(Pane pane) {
        vehicle.operation(pane);
    }
}
