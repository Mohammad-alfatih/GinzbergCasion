package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.Card;
import ginzberg.casino.CardGames.Poker.PokerCardHandler;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by anthonypajerowski on 1/25/17.
 */
public class PokerCardHandlerTest {

    PokerCardHandler handler;

    int[] testArr;

    @Before
    public void setup() {
        handler = new PokerCardHandler();
        testArr= new int[5];
    }

    @Test
    public void setCardsToReplaceFalseTest() {
        boolean expected = false;
        handler.setCardsToReplace(testArr);
        boolean actual = handler.cardsToReplace.get(1);
        assertEquals("I expect that the value for position '1' should remain false", expected, actual);
    }

    @Test
    public void setCardsToReplaceTrueTest() {
        boolean expected = true;
        testArr[0] = 1;
        handler.setCardsToReplace(testArr);
        boolean actual = handler.cardsToReplace.get(1);
        assertEquals("I expect that the value for position '2' should be changed from false to true", expected,actual);
    }

    @Test
    public void replaceCardsTest() {
        Card expected = handler.playerHand.get(1);
        testArr[0] = 1;
        handler.setCardsToReplace(testArr);
        handler.replaceCards();
        Card actual = handler.playerHand.get(1);
        assertFalse(expected == actual);
    }
}


