package com.labs.lab4.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bicycle extends Vehicle {

    public Bicycle(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeLine(x, y, x + 30, y + 15); // рама

        gc.setFill(Color.BLACK);
        gc.fillOval(x, y + 10, 10, 10);      // колёса
        gc.fillOval(x + 30, y + 10, 10, 10);
    }
}
