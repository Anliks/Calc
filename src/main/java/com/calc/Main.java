package com.calc;



import com.calc.service.ConsoleInWriteInOut;
import com.calc.service.ParsingString;
import com.calc.service.Validator;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        ConsoleInWriteInOut inWrite = new ConsoleInWriteInOut();
        String stringChecked = new Validator().checkValidation(inWrite.consoleWrite());
        List<String> list = new ParsingString().parse(stringChecked);
        new ConsoleInWriteInOut().outInConsole(new ParsingString().parsing(list));
    }

}
