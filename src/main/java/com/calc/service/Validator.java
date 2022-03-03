package com.calc.service;


import com.calc.exception.EmptyStringChecked;
import com.calc.exception.IncorrectInputCharacterException;
import com.calc.exception.NegativeNumberChecked;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {


       public String checkValidation(String inputString) throws IncorrectInputCharacterException, ArithmeticException, NegativeNumberChecked, EmptyStringChecked {

           if (inputString.isEmpty()) {
               throw new EmptyStringChecked("Пустая строка");
           }
           Pattern pattern = Pattern.compile("[^\\s.0123456789*+/-]");
            Matcher matcher = pattern.matcher(inputString);

            if (matcher.find()) {
                throw new IncorrectInputCharacterException("Выражение содержит недопустимые символы!(Допустимы только положительные числа и операторы /, *, -, +)");
            }

            if (inputString.contains("/0")) {
                throw new IllegalArgumentException("Выражение содержит деление на ноль!");
            }

            if (inputString.charAt(0) == '-') {
                throw new NegativeNumberChecked("Выражение содержит отрицательное число!");
            }
           //проверка на два операнда или более подряд.
            Pattern pattern1 = Pattern.compile("([^0-9])\\1+");
            Matcher matcher1 = pattern1.matcher(inputString);
            if(matcher1.find()) {
                throw new IncorrectInputCharacterException("Избегайте повторяющихся операндов");
            }

         return inputString;

        }
}
