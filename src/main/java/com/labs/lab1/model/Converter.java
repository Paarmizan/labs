package com.labs.lab1.model;

public class Converter {
    private double input;
    private int operationType;
    private int precision;

    public Converter(double input, int operationType, int precision) {
        this.input = input;
        this.operationType = operationType;
        this.precision = precision;
    }

    public String calculate() {
        double result;
        String unitFrom, unitTo;

        switch (operationType) {
            case 0 -> {
                result = input * 1.852;
                unitFrom = "миль";
                unitTo = "км";
            }
            case 1 -> {
                result = input / 1.852;
                unitFrom = "км";
                unitTo = "миль";
            }
            default -> throw new IllegalArgumentException("Неизвестная операция");
        }

        String format = "%." + precision + "f %s = %." + precision + "f %s";
        return String.format(format, input, unitFrom, result, unitTo);
    }
}
