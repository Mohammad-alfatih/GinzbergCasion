package com.michael.wolfe.zipcodecasino;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/25/17.
 */
public class WheelTest {
    private Wheel wheel;

    @Before
    public void setup() {
        wheel = new Wheel();
    }

    @Test
    public void getWinningNumberFromPocketSequenceTest() {

        int expected = 8;
        int actual = wheel.getWinningNumberFromPocketSequence(25);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Number '" + wheel.getWinningNumberFromPocketSequence(0) + "'");
        System.out.println("'00' Test  : Number '" + wheel.getWinningNumberFromPocketSequence(37) + "'");
        System.out.println("'34' Test  : Number '" + wheel.getWinningNumberFromPocketSequence(34) + "'");
        System.out.println("'35' Test  : Number '" + wheel.getWinningNumberFromPocketSequence(35) + "'");
        System.out.println("'36' Test  : Number '" + wheel.getWinningNumberFromPocketSequence(36) + "'");
        assertEquals("I expect the result to be: 8", expected, actual);
    }
}