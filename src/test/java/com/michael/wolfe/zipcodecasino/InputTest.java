package com.michael.wolfe.zipcodecasino;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/26/17.
 */
public class InputTest {
    private Input input;

    @Before
    public void setup() {
        input = new Input();
    }

    @Test
    public void parseToIntegerTest() {

        Integer expected = 8;
        Integer actual = input.parseToInteger("8");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals("I expect the result to be: 8", expected, actual);
    }
}
