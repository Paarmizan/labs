package com.labs.lab4.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Car extends Vehicle {

    public Car(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, 60, 30); // кузов

        gc.setFill(Color.BLACK);
        gc.fillOval(x + 5, y + 25, 10, 10); // колёса
        gc.fillOval(x + 45, y + 25, 10, 10);
    }
}
