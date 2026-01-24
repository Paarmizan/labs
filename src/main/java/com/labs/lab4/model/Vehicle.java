package com.labs.lab4.model;

import javafx.scene.paint.Color;

public abstract class Vehicle implements IVehicle {
    protected int x, y;
    protected Color color;

    public Vehicle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
