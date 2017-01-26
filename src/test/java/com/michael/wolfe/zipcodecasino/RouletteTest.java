package com.michael.wolfe.zipcodecasino;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/25/17.
 */
public class RouletteTest {
    private Roulette roulette;

    @Before
    public void setup() {
        roulette = new Roulette(100.00);
    }

    @Test
    public void getPayoutTest() {

        Integer expected = 35;
        Integer actual = roulette.getPayout('A');
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals("I expect the result to be: 35", expected, actual);
    }
}