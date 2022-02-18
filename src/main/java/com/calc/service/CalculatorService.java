package com.calc.service;

public class CalculatorService implements CalculationServiceImpl {

    @Override
    public Double count(Double char1, Double char2, String operator) {

        switch (operator) {
            case ("+"):
                return char1 + char2;
            case ("-"):
                return char2 - char1;
            case ("*"):
                return char1 * char2;
            case ("/"):
                return char2 / char1;
        }
        return null;
    }
}