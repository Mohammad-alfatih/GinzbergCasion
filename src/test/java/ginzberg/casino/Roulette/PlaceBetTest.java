package ginzberg.casino.Roulette;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/26/17.
 */
public class PlaceBetTest {
    private PlaceBet placeBet;

    @Before
    public void setup() {
        placeBet = new PlaceBet();
    }

    @Test
    public void getStraightUpTest() {

        Integer expected = 0;
        Integer actual = placeBet.getStraightUp("00");
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'00' : '" + placeBet.getStraightUp("00") + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getColumnTest() {

        Integer expected = 0;
        Integer actual = placeBet.getColumn(3);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'3' : '" + placeBet.getColumn(3) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getDozenTest() {

        Integer expected = null;
        Integer actual = placeBet.getDozen(3);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'3' : '" + placeBet.getDozen(3) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }

    @Test
    public void getRedBlackTest() {

        Integer expected = null;
        Integer actual = placeBet.getRedBlack(3);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'3' : '" + placeBet.getRedBlack(3) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }

    @Test
    public void getHighLowTest() {

        Integer expected = null;
        Integer actual = placeBet.getHighLow(3);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'3' : '" + placeBet.getHighLow(3) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }

    @Test
    public void getEvenOddTest() {

        Integer expected = null;
        Integer actual = placeBet.getEvenOdd(3);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'3' : '" + placeBet.getEvenOdd(3) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }

    @Test
    public void getSplitRightTest() {

        Integer expected = 0;
        Integer actual = placeBet.getSplitRight(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getSplitRight(2) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getSplitDownTest() {

        Integer expected = 0;
        Integer actual = placeBet.getSplitDown(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getSplitDown(2) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getStreetTest() {

        Integer expected = 0;
        Integer actual = placeBet.getStreet(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getStreet(2) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getCornerTest() {

        Integer expected = 0;
        Integer actual = placeBet.getCorner(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getCorner(2) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getToplineTest() {

        Integer expected = null;
        Integer actual = placeBet.getTopline(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getTopline(2) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }

    @Test
    public void getLineTest() {

        Integer expected = 0;
        Integer actual = placeBet.getLine(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getLine(2) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getZeroDoubleZeroTest() {

        Integer expected = null;
        Integer actual = placeBet.getZeroDoubleZero(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getZeroDoubleZero(2) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }

    @Test
    public void getCourtesyTest() {

        Integer expected = null;
        Integer actual = placeBet.getCourtesy(2);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n'2' : '" + placeBet.getCourtesy(2) + "'");
        assertEquals("I expect the result to be: null", expected, actual);
    }
}
