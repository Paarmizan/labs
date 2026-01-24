package com.labs.lab5.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class CarBase implements VehicleComponent {

    @Override
    public void operation(Pane pane) {

        pane.getChildren().clear(); // чтобы не рисовалась поверх старой

        // кузов
        Rectangle body = new Rectangle(100, 150, 120, 40);
        body.setFill(Color.RED);
        body.setStroke(Color.BLACK);

        // кабина
        Rectangle cabin = new Rectangle(160, 120, 50, 30);
        cabin.setFill(Color.DARKRED);
        cabin.setStroke(Color.BLACK);

        // колёса
        Circle wheel1 = new Circle(120, 195, 10);
        Circle wheel2 = new Circle(200, 195, 10);
        wheel1.setFill(Color.BLACK);
        wheel2.setFill(Color.BLACK);

        pane.getChildren().addAll(body, cabin, wheel1, wheel2);
    }

    @Override
    public String decorate() {
        return "Базовая машина";
    }

    @Override
    public float cost() {
        return 10000;
    }
}
