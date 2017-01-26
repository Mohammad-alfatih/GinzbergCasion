package com.michael.wolfe.zipcodecasino;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/26/17.
 */
public class MinimumBetTest {
    private MinimumBet minimumBet;

    @Before
    public void setup() {
        minimumBet = new MinimumBet();
    }

    @Test
    public void getMinimumBetTest() {

        Integer expected = 0;
        Integer actual = minimumBet.getMinimum();
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals("I expect the result to be: 0", expected, actual);
    }
}