package com.labs.lab4.controller;

import com.labs.lab4.model.Bicycle;
import com.labs.lab4.model.Car;
import com.labs.lab4.model.Motorcycle;
import com.labs.lab4.model.Vehicle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class FourthLabController {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;
    private int y = 50; // чтобы фигуры не накладывались

    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
    }

    @FXML
    private void drawCar() {
        Vehicle car = new Car(50, y);
        car.setColor(Color.RED);
        car.draw(gc);
        y += 70;
    }

    @FXML
    private void drawMotorcycle() {
        Vehicle moto = new Motorcycle(50, y);
        moto.setColor(Color.BLUE);
        moto.draw(gc);
        y += 70;
    }

    @FXML
    private void drawBicycle() {
        Vehicle bike = new Bicycle(50, y);
        bike.setColor(Color.GREEN);
        bike.draw(gc);
        y += 70;
    }

    @FXML
    private void clearCanvas() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        y = 50;
    }
}
