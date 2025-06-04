package com.labs.lab1.controller;

import com.labs.lab1.model.Arithmetic;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FirstLabController {
    @FXML private TextField numberAField;
    @FXML private ComboBox<String> operationComboBox;
    @FXML private TextField numberBField;
    @FXML private Label resultLabel;

    @FXML
    public void initialize() {
        operationComboBox.getSelectionModel().selectFirst();
    }

    @FXML
    private void actionCalculate() {
        try {
            Arithmetic calculator = new Arithmetic(
                    numberAField.getText(),
                    numberBField.getText(),
                    operationComboBox.getSelectionModel().getSelectedIndex()
            );

            resultLabel.setText(calculator.calculate());
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: введите корректные числа");
        } catch (ArithmeticException e) {
            resultLabel.setText("Ошибка: деление на ноль");
        } catch (Exception e) {
            resultLabel.setText("Ошибка вычисления");
        }
    }
}