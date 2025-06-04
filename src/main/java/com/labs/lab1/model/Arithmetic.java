package com.labs.lab1.model;

public class Arithmetic {
    private double A;
    private double B;
    private double res;
    private int operationType;

    public Arithmetic(String A, String B, int operationType) throws NumberFormatException {
        this.A = Double.parseDouble(A);
        this.B = Double.parseDouble(B);
        this.operationType = operationType;
    }

    public double calculate() throws ArithmeticException {
        switch (operationType) {
            case 0: res = A + B; break;
            case 1: res = A - B; break;
            case 2: res = A * B; break;
            case 3:
                if (B == 0) throw new ArithmeticException();
                res = A / B;
                break;
            default: throw new IllegalArgumentException();
        }
        return res;
    }

    public String getResult() {
        calculate();
        return String.format("= %.2f", res);
    }
}