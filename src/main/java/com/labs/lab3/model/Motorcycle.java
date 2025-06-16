package com.labs.lab3.model;

import java.awt.*;

public class Motorcycle extends Vehicle {
    public Motorcycle(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 40, 15); // корпус
        g.setColor(Color.BLACK);
        g.fillOval(x, y + 10, 10, 10); // колёса
        g.fillOval(x + 30, y + 10, 10, 10);
    }
}

