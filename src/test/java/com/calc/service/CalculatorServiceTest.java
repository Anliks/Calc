package com.calc.service;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CalculatorServiceTest {
    @Test
    public void testCount() {
        assertNull((new CalculatorService()).count(10.0, 10.0, "Operator"));
        assertEquals(100.0, (new CalculatorService()).count(10.0, 10.0, "*").doubleValue(), 0.0);
        assertEquals(19.0, (new CalculatorService()).count(9.0, 10.0, "+").doubleValue(), 0.0);
        assertEquals(0.0, (new CalculatorService()).count(10.0, 10.0, "-").doubleValue(), 0.0);
        assertEquals(1.0, (new CalculatorService()).count(10.0, 10.0, "/").doubleValue(), 0.0);
        assertThrows(IllegalArgumentException.class, () -> new CalculatorService().count(0,10,"/"));
    }
}

