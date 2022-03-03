package com.calc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ParsingStringTest {
    @Test
    public void testParse() {
        List<String> result = new ArrayList<>();
        result.add("5");
        result.add("+");
        result.add("7");
        result.add("/");
        result.add("5");
        List<String> actualParseResult = (new ParsingString()).parse("5+7/5");
        assertEquals(5, actualParseResult.size());
        assertEquals(actualParseResult, result);
    }

    @Test
    public void testParsing() {
        ParsingString parsingString = new ParsingString();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("42");
        assertEquals(42.0, parsingString.parsing(stringList).doubleValue(), 0.0);
    }

    @Test
    public void testParsingInvalidCharacters() {
        ParsingString parsingString = new ParsingString();

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("5");
        stringList.add("42");
        stringList.add("foo");
        assertNull(parsingString.parsing(stringList));
    }

    @Test
    public void testGetPriority() {
        assertEquals(0, (new ParsingString()).getPriority("ABC123"));
        assertEquals(2, (new ParsingString()).getPriority("*"));
        assertEquals(1, (new ParsingString()).getPriority("+"));
        assertEquals(1, (new ParsingString()).getPriority("-"));
        assertEquals(2, (new ParsingString()).getPriority("/"));
    }

    @Test
    public void testIsNumber() {
        assertTrue((new ParsingString()).isNumber("42"));
        assertFalse((new ParsingString()).isNumber("Number"));
    }
}

