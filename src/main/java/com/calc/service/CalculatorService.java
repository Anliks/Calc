package com.calc.service;



public class CalculatorService implements CalculationServiceImpl {


    @Override
    public Double count(double char1, double char2, String operator)  {


        switch (operator) {
            case ("+"):
                return char1 + char2;
            case ("-"):
                return char2 - char1;
            case ("*"):
                return char1 * char2;
            case ("/"):
                if(char1 == 0) {
                    throw new IllegalArgumentException("делить на ноль нельзя");
                }
                return char2 / char1;
        }
        return null;
    }
}