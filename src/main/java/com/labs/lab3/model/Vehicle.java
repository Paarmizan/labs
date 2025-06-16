package com.labs.lab3.model;

import java.awt.*;

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

