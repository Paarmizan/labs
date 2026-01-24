package com.labs.lab5.model;

import javafx.scene.layout.Pane;

public interface VehicleComponent {
    void operation(Pane pane);
    String decorate();
    float cost();
}
