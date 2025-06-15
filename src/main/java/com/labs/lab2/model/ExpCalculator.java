package com.labs.lab2.model;

public class ExpCalculator {

    public static double calculate(double x, double epsilon) {
        double term = 1.0;
        double sum = 1.0;
        int i = 1;

        while (Math.abs(term) > epsilon) {
            term *= x / i;
            sum += term;
            i++;
        }

        return sum;
    }
}
