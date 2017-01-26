package ginzberg.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ryangross on 1/25/17.
 */
public class BlackJackTest {
    BlackJack testBJ;
    Card anAce = new Card(Ranks.ACE, Suits.CLUBS);
    Card aFive = new Card(Ranks.FIVE, Suits.CLUBS);
    Card aFour = new Card(Ranks.FOUR, Suits.CLUBS);
    Card aNine = new Card(Ranks.NINE, Suits.CLUBS);
    Card aTen = new Card(Ranks.TEN, Suits.CLUBS);

    @Before
    public void setUp() {
        testBJ = new BlackJack();
    }

    @Test
    public void dealCards() {
        testBJ.dealCards();
        Assert.assertEquals(2, testBJ.userHand.size());
        Assert.assertEquals(2, testBJ.dealerHand.size());
        Assert.assertEquals(48, testBJ.cardDeck.getCardDeck().size());
    }

    @Test
    public void regularScoreTest() {
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(anAce);
        testHand.add(anAce);
        testHand.add(aTen);
        Assert.assertEquals(32, testBJ.regularScore(testHand));
    }

    @Test
    public void findAllAcesTest() {
        Card anAce = new Card(Ranks.ACE, Suits.CLUBS);
        Card aFive = new Card(Ranks.FIVE, Suits.CLUBS);
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(anAce);
        testHand.add(anAce);
        testHand.add(aFive);
        Assert.assertEquals(2, testBJ.findAllAces(testHand));
    }

    @Test
    public void calculateScoreTest() {
        Card anotherTen = new Card(Ranks.TEN, Suits.CLUBS);
        ArrayList<Card> testHand = new ArrayList<Card>();
        testHand.add(anAce);
        testHand.add(aTen);
        testHand.add(anotherTen);
        Assert.assertEquals(21, testBJ.calculateScore(testHand));

        ArrayList<Card> testHandTwo = new ArrayList<Card>();
        testHandTwo.add(aTen);
        testHandTwo.add(aFour);
        testHandTwo.add(aFour);
        testHandTwo.add(anAce);
        Assert.assertEquals(19, testBJ.calculateScore(testHandTwo));
    }

}
