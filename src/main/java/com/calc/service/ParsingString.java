package com.calc.service;



import java.util.*;

public class ParsingString implements ParsingStringImpl {

    CalculationServiceImpl calculationService = new CalculatorService();

    public  List<String> parse(String inputText) {

        List<String> list = new ArrayList<>();
        String[] stringMas = inputText.split("(?=[/*+-])|(?<=[/*+-])");
        Collections.addAll(list, stringMas);
        return list;

    }

    @Override
    public Double parsing(List<String> inputText) {
        Stack<String> operations = new Stack<>();
        Stack<Double> numbers = new Stack<>();

        for (String string : inputText) {
            if (isNumber(string)) {
                numbers.push(Double.parseDouble(string));
            } else {
                if (operations.empty()) {
                    operations.push(string);
                } else if (getPriority(operations.peek()) < getPriority(string)) {
                    operations.push(string);
                } else if (getPriority(operations.peek()) >= getPriority(string)) {
                    numbers.push(calculationService.count(numbers.pop(), numbers.pop(), operations.pop()));
                    operations.push(string);
                }
            }
        }
        while (!operations.empty()) {
            numbers.push(calculationService.count(numbers.pop(), numbers.pop(), operations.pop()));
        }
        return numbers.pop();
    }

    @Override
    public int getPriority(String token) {

        switch (token) {
            case ("+"):
            case ("-"):
                return 1;
            case ("*"):
            case ("/"):
                return 2;
        }
        return 0;
        }


    @Override
    public boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        }catch (NumberFormatException ex) {
            return false;
        }
    }
}
