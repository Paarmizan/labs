package com.labs.lab2.controller;

import com.labs.lab2.model.ExpCalculator;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SecondLabController {
    @FXML private TextField numberAField;
    @FXML private TextField precisionField;
    @FXML private Label resultLabel;

    @FXML
    public void actionCalculateExp() {
        try {
            double x = Double.parseDouble(numberAField.getText());
            double epsilon = Double.parseDouble(precisionField.getText());

            double result = ExpCalculator.calculate(x, epsilon);

            resultLabel.setText(String.format("e^%.2f ≈ %.10f", x, result));
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: введите корректные числа");
        } catch (Exception e) {
            resultLabel.setText("Ошибка вычисления");
        }
    }
}