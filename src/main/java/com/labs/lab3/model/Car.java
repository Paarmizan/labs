package com.labs.lab3.model;

import java.awt.*;

public class Car extends Vehicle {
    public Car(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 60, 30); // кузов
        g.setColor(Color.BLACK);
        g.fillOval(x + 5, y + 25, 10, 10); // колёса
        g.fillOval(x + 45, y + 25, 10, 10);
    }
}
