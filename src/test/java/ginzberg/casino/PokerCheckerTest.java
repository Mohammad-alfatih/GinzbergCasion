package ginzberg.casino;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by williammattern on 1/25/17.
 */
public class PokerCheckerTest {
    Card aceOfSpades = new Card(Ranks.ACE,Suits.SPADES);
    Card aceOfClubs = new Card(Ranks.ACE,Suits.CLUBS);
    Card aceOfDiamonds = new Card(Ranks.ACE,Suits.DIAMONDS);
    Card twoOfClubs = new Card(Ranks.TWO, Suits.CLUBS);
    Card threeOfHearts = new Card(Ranks.THREE, Suits.HEARTS);
    Card kingOfHearts = new Card(Ranks.KING,Suits.HEARTS);
    Card kingOfSpades = new Card(Ranks.KING,Suits.SPADES);
    Card kingOfDiamonds = new Card(Ranks.KING,Suits.DIAMONDS);
    Card kingOfClubs = new Card(Ranks.KING,Suits.CLUBS);
    Card fourOfDiamonds = new Card(Ranks.FOUR, Suits.DIAMONDS);
    Card fiveOfSpades = new Card(Ranks.FIVE, Suits.SPADES);
    Card fiveOfDiamonds = new Card(Ranks.FIVE,Suits.DIAMONDS);
    Card threeOfDiamonds = new Card(Ranks.THREE, Suits.DIAMONDS);
    Card sixOfDiamonds = new Card(Ranks.SIX,Suits.DIAMONDS);
    Card tenOfSpades = new Card(Ranks.TEN, Suits.SPADES);
    Card jackOfSpades = new Card(Ranks.JACK, Suits.SPADES);
    Card queenOfSpades = new Card(Ranks.QUEEN, Suits.SPADES);
    Card nineOfSpades = new Card(Ranks.NINE, Suits.SPADES);

    public HashMap<Integer, Card> loadPlayerHandWithFiveCards(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,cardOne);
        deck.cards.add(1,cardTwo);
        deck.cards.add(2,cardThree);
        deck.cards.add(3,cardFour);
        deck.cards.add(4,cardFive);
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        return playerHand;
    }

    @Test
    public void flushCheckerTrueTest(){
        CardDeck deck = new CardDeck();
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.flushChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void flushCheckerFalseTest(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,aceOfSpades);
        deck.cards.add(1,twoOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,threeOfHearts);
        deck.cards.add(4,kingOfHearts);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.flushChecker(playerHand);
        assertFalse(actual);
    }

    @Test
    public void straightCheckerTrueTest(){
        CardDeck deck = new CardDeck();
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.straightChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void straightCheckerFalseTest(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,aceOfSpades);
        deck.cards.add(1,twoOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,threeOfHearts);
        deck.cards.add(4,kingOfHearts);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.straightChecker(playerHand);
        assertFalse(actual);
    }

    @Test
    public void convertToRankOrdinalArrayTest1(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,aceOfSpades);
        deck.cards.add(1,twoOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,threeOfHearts);
        deck.cards.add(4,kingOfHearts);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        int[] actual = pokerChecker.convertToRankOrdinalArray(playerHand);
        int[] expected = {0,1,0,2,12};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void convertToRankOrdinalArrayTest2(){
        CardDeck deck = new CardDeck();
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        int[] actual = pokerChecker.convertToRankOrdinalArray(playerHand);
        int[] expected = {0,1,2,3,4};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void countOfMatchesFromLeftTest(){
        int[] ordinalArray = {0,0,12,12,12};
        PokerChecker pokerChecker = new PokerChecker();
        int actual = pokerChecker.countOfMatchesFromLeft(ordinalArray);
        int expected = 2;
        assertEquals(expected, actual,0.0);
    }

    @Test
    public void countOfMatchesFromRightTest(){
        int[] ordinalArray = {0,0,12,12,12};
        PokerChecker pokerChecker = new PokerChecker();
        int actual = pokerChecker.countOfMatchesFromRight(ordinalArray);
        int expected = 3;
        assertEquals(expected, actual,0.0);
    }

    @Test
    public void countOfMatchesFromPosition2(){
        int[] ordinalArray = {0,0,0,12,12};
        PokerChecker pokerChecker = new PokerChecker();
        int actual = pokerChecker.countOfMatchesFromPosition2(ordinalArray);
        int expected = 2;
        assertEquals(expected, actual,0.0);
    }

    @Test
    public void fullHouseCheckerTest2pair3pair(){
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,aceOfSpades,kingOfClubs,kingOfDiamonds,aceOfClubs);
        PokerChecker pokerChecker = new PokerChecker();
        boolean actual = pokerChecker.fullHouseChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void fullHouseCheckerTest3pair2pair(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,aceOfSpades);
        deck.cards.add(1,aceOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,kingOfDiamonds);
        deck.cards.add(4,kingOfSpades);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.fullHouseChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void tripsCheckerTest3pair(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,aceOfSpades);
        deck.cards.add(1,aceOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,threeOfHearts);
        deck.cards.add(4,kingOfSpades);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.tripsChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void twoPairCheckerTest(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,kingOfClubs);
        deck.cards.add(1,aceOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,threeOfHearts);
        deck.cards.add(4,kingOfSpades);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.twoPairChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void twoPairCheckerTestForFalse(){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,kingOfClubs);
        deck.cards.add(1,twoOfClubs);
        deck.cards.add(2,aceOfDiamonds);
        deck.cards.add(3,threeOfHearts);
        deck.cards.add(4,kingOfSpades);
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = new HashMap<Integer, Card>(5);
        for (Integer i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.twoPairChecker(playerHand);
        assertFalse(actual);
    }

    @Test
    public void jacksOrBetterCheckerTestingForFalse() {
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfClubs,twoOfClubs,aceOfDiamonds,threeOfHearts,fiveOfSpades);
        PokerChecker pokerChecker = new PokerChecker();
        boolean actual = pokerChecker.jacksOrBetterChecker(playerHand);
        assertFalse(actual);
    }

    @Test
    public void jacksOrBetterCheckerTestingForLowPair() {
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfClubs,twoOfClubs,aceOfDiamonds,threeOfHearts,threeOfDiamonds);
        boolean actual = pokerChecker.jacksOrBetterChecker(playerHand);
        assertFalse(actual);
    }

    @Test
    public void jacksOrBetterCheckerTestingForTrue() {
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfClubs, kingOfDiamonds, aceOfDiamonds, threeOfHearts, fiveOfDiamonds);
        boolean actual = pokerChecker.jacksOrBetterChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void jacksOrBetterCheckerTestingForAces() {
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(aceOfSpades,threeOfDiamonds,fiveOfDiamonds,fourOfDiamonds,aceOfClubs);
        boolean actual = pokerChecker.jacksOrBetterChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void royalCheckerFalseTest(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(aceOfSpades,threeOfDiamonds,fiveOfDiamonds,fourOfDiamonds,aceOfClubs);
        boolean actual = pokerChecker.royalChecker(playerHand);
        assertFalse(actual);
    }

    @Test
    public void royalCheckerTrueTest(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(tenOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,aceOfSpades);
        boolean actual = pokerChecker.royalChecker(playerHand);
        assertTrue(actual);
    }

    @Test
    public void decisionTreeTestRoyal(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(tenOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,aceOfSpades);
        String expected = "royalFlush", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestSF(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(tenOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,nineOfSpades);
        String expected = "straightFlush", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestFourOfAKind(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,kingOfDiamonds,kingOfClubs,aceOfClubs,kingOfHearts);
        String expected = "fourOfAKind", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestFullHouse(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,kingOfDiamonds,kingOfClubs,aceOfClubs,aceOfSpades);
        String expected = "fullHouse", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestFlush(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,tenOfSpades,fiveOfSpades,aceOfSpades,nineOfSpades);
        String expected = "flush", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestLowStraight(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(aceOfSpades,twoOfClubs,threeOfDiamonds,fourOfDiamonds,fiveOfSpades);
        String expected = "straight", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestMiddleStraight(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(twoOfClubs,threeOfDiamonds,fourOfDiamonds,fiveOfSpades,sixOfDiamonds);
        String expected = "straight", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestHighStraight(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(tenOfSpades,jackOfSpades,queenOfSpades,kingOfDiamonds,aceOfSpades);
        String expected = "straight", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestThreeOfAKind(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,kingOfDiamonds,kingOfClubs,fourOfDiamonds,threeOfDiamonds);
        String expected = "threeOfAKind", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestTwoPair(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(fiveOfDiamonds,fiveOfSpades,threeOfDiamonds,threeOfHearts,kingOfDiamonds);
        String expected = "twoPair", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }

    @Test
    public void decisionTreeTestJacksOrBetter(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,kingOfDiamonds,threeOfDiamonds,fiveOfDiamonds,nineOfSpades);
        String expected = "jacksOrBetter", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }


    @Test
    public void decisionTreeTestLostHand(){
        PokerChecker pokerChecker = new PokerChecker();
        HashMap<Integer, Card> playerHand = loadPlayerHandWithFiveCards(kingOfSpades,jackOfSpades,fourOfDiamonds,threeOfDiamonds,fiveOfSpades);
        String expected = "lostHand", actual = pokerChecker.getWinConditionThatIsMet(playerHand);
        assertEquals(expected,actual);
    }
}