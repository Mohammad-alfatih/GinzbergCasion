package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.Poker.PokerInputParser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by anthonypajerowski on 1/27/17.
 */
public class PokerInputParserTest {
    PokerInputParser parser;

    @Before
    public void setup() {
        parser = new PokerInputParser();
    }

    @Test
    public void parseUserInputFiveTest (){
        int[] expected =  new int[]{0,1,2,3,4};
        int[] actual = parser.parseUserInput("0,1,2,3,4");
        assertArrayEquals(expected,actual);
    }

    @Test
    public void parseInputFourTest() {
        int[] expected = new int[]{0,1,2,3};
        int[] actual = parser.parseUserInput("0,1,2,3");
        assertArrayEquals(expected,actual);
    }

    @Test
    public void parseInputThreeTest() {
        int[] expected = new int[]{0,1,2};
        int[] actual = parser.parseUserInput("0,1,2");
        assertArrayEquals(expected,actual);
    }

    @Test
    public void parseInputTwoTest() {
        int[] expected = new int[]{0,1};
        int[] actual = parser.parseUserInput("0,1");
        assertArrayEquals(expected,actual);
    }

    @Test
    public void parseInputOneTest() {
        int[] expected = new int[]{0};
        int[] actual = parser.parseUserInput("0");
        assertArrayEquals(expected,actual);
    }

    @Test
    public void parseInputFalseTest() {
        int expected = new int[]{0,1}.length;
        int actual = parser.parseUserInput("0").length;
        assertNotEquals(expected,actual);
    }



}
