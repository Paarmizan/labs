package com.labs.lab4.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Motorcycle extends Vehicle {

    public Motorcycle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(color);
        gc.fillRect(x, y, 40, 15); // корпус

        gc.setFill(Color.BLACK);
        gc.fillOval(x, y + 10, 10, 10);      // колёса
        gc.fillOval(x + 30, y + 10, 10, 10);
    }
}
