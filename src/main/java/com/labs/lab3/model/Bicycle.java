package com.labs.lab3.model;

import java.awt.*;

public class Bicycle extends Vehicle {
    public Bicycle(int x, int y) {
        super(x, y);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x, y, x + 30, y + 15); // рама
        g.setColor(Color.BLACK);
        g.fillOval(x, y + 10, 10, 10); // колёса
        g.fillOval(x + 30, y + 10, 10, 10);
    }
}

