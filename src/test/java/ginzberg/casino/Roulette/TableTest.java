package ginzberg.casino.Roulette;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/25/17.
 */
public class TableTest {
    private Table table;

    @Before
    public void setup() {
        table = new Table();
    }

    @Test
    public void getNumberTest() {

        String expected = "00";
        String actual = table.getNumber(37);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("int 1 : " + table.getNumber(1));
        System.out.println("str 1 : " + table.getNumber("1"));
        assertEquals("I expect the result to be: 00", expected, actual);
    }
}