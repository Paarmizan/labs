package com.labs.lab1.model;

public class Arithmetic {
    private double A;
    private double B;
    private double result;
    private int operationType;
    private String operationSymbol;

    public Arithmetic(String A, String B, int operationType) throws NumberFormatException {
        this.A = Double.parseDouble(A);
        this.B = Double.parseDouble(B);
        this.operationType = operationType;
        this.operationSymbol = getOperationSymbol();
    }

    public String calculate() throws ArithmeticException {
        switch (operationType) {
            case 0: result = A + B; break;
            case 1: result = A - B; break;
            case 2: result = A * B; break;
            case 3:
                if (B == 0) throw new ArithmeticException("Деление на ноль");
                result = A / B;
                break;
            default: throw new IllegalArgumentException("Неизвестная операция");
        }
        return formatResult();
    }

    private String getOperationSymbol() {
        return switch (operationType) {
            case 0 -> "+";
            case 1 -> "-";
            case 2 -> "*";
            case 3 -> "/";
            default -> throw new IllegalArgumentException("Неизвестная операция");
        };
    }

    private String formatResult() {
        return String.format("%.2f %s %.2f = %.2f", A, operationSymbol, B, result);
    }
}