package com.labs.lab1.controller;

import com.labs.lab1.model.Arithmetic;
import com.labs.lab1.model.Converter;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FirstLabController {
    @FXML private TextField numberAField;
    @FXML private ComboBox<String> operationComboBox;
    @FXML private ComboBox<Integer> precisionComboBox;
    @FXML private TextField numberBField;
    @FXML private Label resultLabel;

    @FXML
    public void initialize() {
//        Задание 1
//        operationComboBox.getSelectionModel().selectFirst();
//        Задание 2
        operationComboBox.getSelectionModel().selectFirst();
        precisionComboBox.getSelectionModel().select(1);
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

    @FXML
    private void actionConverte() {
        try {
            double input = Double.parseDouble(numberAField.getText());
            int operation = operationComboBox.getSelectionModel().getSelectedIndex();
            int precision = precisionComboBox.getSelectionModel().getSelectedItem();

            Converter converter = new Converter(input, operation, precision);
            resultLabel.setText(converter.calculate());
        } catch (NumberFormatException e) {
            resultLabel.setText("Ошибка: введите число");
        } catch (Exception e) {
            resultLabel.setText("Ошибка конвертации");
        }
    }

}