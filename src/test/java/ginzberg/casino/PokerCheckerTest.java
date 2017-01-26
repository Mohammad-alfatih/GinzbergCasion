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
    Card twoOfClubs = new Card(Ranks.TWO, Suits.CLUBS);
    Card aceOfDiamonds = new Card(Ranks.ACE,Suits.DIAMONDS);
    Card threeOfHearts = new Card(Ranks.THREE, Suits.HEARTS);
    Card kingOfHearts = new Card(Ranks.KING,Suits.HEARTS);

    @Test
    public void seeCardsInHand(){
        PokerChecker pokerChecker = new PokerChecker();
        for (int i =0; i < 5; i++){
            System.out.println(pokerChecker.playerHand.get(i).getRank().ordinal());
        }
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
        System.out.println(actual);
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
        System.out.println(actual);
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
        System.out.println(actual);
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
        System.out.println(actual);
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


}