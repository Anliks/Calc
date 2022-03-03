package com.calc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.calc.exception.EmptyStringChecked;
import com.calc.exception.IncorrectInputCharacterException;
import com.calc.exception.NegativeNumberChecked;
import org.junit.Test;

public class ValidatorTest {
    @Test
    public void testCheckValidation()
            throws EmptyStringChecked, IncorrectInputCharacterException, NegativeNumberChecked, ArithmeticException {
        assertThrows(IncorrectInputCharacterException.class, () -> (new Validator()).checkValidation("Input String"));
        assertThrows(IllegalArgumentException.class, () -> (new Validator()).checkValidation("/0"));
        assertEquals("42", (new Validator()).checkValidation("42"));
        assertThrows(EmptyStringChecked.class, () -> (new Validator()).checkValidation(""));

    }
}

