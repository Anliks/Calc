package com.calc.service;

import com.calc.exception.IncorrectInputCharacterException;

import java.util.List;

public interface ParsingStringImpl {

    public List<String> parse(String inputText);

    public  Double parsing(List<String> inputText) throws IncorrectInputCharacterException;

    public int getPriority(String token);

    public boolean isNumber(String number);
}
