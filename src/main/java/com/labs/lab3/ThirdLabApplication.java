package com.labs.lab3;

import com.labs.lab3.model.Bicycle;
import com.labs.lab3.model.Car;
import com.labs.lab3.model.Motorcycle;
import com.labs.lab3.model.Vehicle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ThirdLabApplication extends JComponent {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Лабораторная работа 3");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ThirdLabApplication());
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Vehicle car = new Car(50, 50);
        car.setColor(Color.RED);
        car.draw(g);

        Vehicle moto = new Motorcycle(50, 120);
        moto.setColor(Color.BLUE);
        moto.draw(g);

        Vehicle bike = new Bicycle(50, 190);
        bike.setColor(Color.GREEN);
        bike.draw(g);
    }
}
