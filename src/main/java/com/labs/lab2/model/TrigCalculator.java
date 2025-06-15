package com.labs.lab2.model;

public class TrigCalculator {

    public static double calculateSin(double x, double epsilon) {
        double term = x;
        double sum = x;
        int n = 1;

        while (Math.abs(term) > epsilon) {
            term *= -1 * x * x / (2 * n * (2 * n + 1));
            sum += term;
            n++;
        }

        return sum;
    }
}
