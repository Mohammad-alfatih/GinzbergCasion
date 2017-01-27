package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.Card;
import ginzberg.casino.CardGames.CardDeck;
import ginzberg.casino.CardGames.Poker.PokerChecker;
import ginzberg.casino.CardGames.Poker.PokerGameController;
import ginzberg.casino.CardGames.Ranks;
import ginzberg.casino.CardGames.Suits;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.HashMap;

/**
 * Created by williammattern on 1/26/17.
 */
public class PokerCheckerTest {

    PokerChecker pokerChecker = new PokerChecker();
    Card aceOfSpades = new Card(Ranks.ACE, Suits.SPADES);
    Card twoOfSpades = new Card(Ranks.TWO, Suits.SPADES);
    Card threeOfSpades = new Card(Ranks.THREE, Suits.SPADES);
    Card fourOfSpades = new Card(Ranks.FOUR, Suits.SPADES);
    Card fiveOfSpades = new Card(Ranks.FIVE, Suits.SPADES);
    Card tenOfSpades = new Card(Ranks.TEN, Suits.SPADES);
    Card jackOfSpades = new Card(Ranks.JACK, Suits.SPADES);
    Card queenOfSpades = new Card(Ranks.QUEEN, Suits.SPADES);
    Card kingOfSpades = new Card(Ranks.KING, Suits.SPADES);
    Card twoOfDiamonds = new Card(Ranks.TWO, Suits.DIAMONDS);
    Card twoOfClubs = new Card(Ranks.TWO, Suits.CLUBS);
    Card twoOfHearts = new Card(Ranks.TWO, Suits.HEARTS);
    Card kingOfHearts = new Card(Ranks.KING, Suits.HEARTS);
    Card kingOfClubs = new Card(Ranks.KING, Suits.CLUBS);
    Card aceOfDiamonds = new Card(Ranks.ACE, Suits.DIAMONDS);


    public HashMap<Integer, Card> loadPlayerHand(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive){
        CardDeck deck = new CardDeck();
        deck.cards.add(0,cardOne);
        deck.cards.add(1,cardTwo);
        deck.cards.add(2,cardThree);
        deck.cards.add(3,cardFour);
        deck.cards.add(4,cardFive);
        HashMap<Integer, Card> playerHand = new HashMap<>();
        for (int i = 0; i < 5; i++){
            playerHand.put(i,deck.getNextCard());
        }
        return playerHand;
    }

    @Test
    public void flushChecker() {
        CardDeck deck = new CardDeck();
        Card aceOfSpades = new Card(Ranks.ACE, Suits.SPADES);
        Card twoOfSpades = new Card(Ranks.TWO, Suits.SPADES);
        Card threeOfSpades = new Card(Ranks.THREE, Suits.SPADES);
        Card fourOfSpades = new Card(Ranks.FOUR, Suits.SPADES);
        Card fiveOfSpades = new Card(Ranks.FIVE, Suits.SPADES);
        deck.cards.add(0, aceOfSpades);
        deck.cards.add(1, twoOfSpades);
        deck.cards.add(2, threeOfSpades);
        deck.cards.add(3, fourOfSpades);
        deck.cards.add(4, fiveOfSpades);
        HashMap<Integer, Card> playerHand = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            playerHand.put(i, deck.getNextCard());
        }
        boolean actual = pokerChecker.flushChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void straightChecker(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(aceOfSpades,twoOfSpades,threeOfSpades,fourOfSpades,fiveOfSpades);
        boolean actual = pokerChecker.straightChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void royalChecker(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(tenOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,aceOfSpades);
        boolean actual = pokerChecker.royalChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void royalCheckerFalse(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(fiveOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,aceOfSpades);
        boolean actual = pokerChecker.royalChecker(playerHand), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void convertToRankOrdinalArrayTest(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(fiveOfSpades,jackOfSpades,queenOfSpades,kingOfSpades,aceOfSpades);
        int[] actual = pokerChecker.convertToRankOrdinalArray(playerHand), expected = {0,4,10,11,12};
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void fourOfAKindCheckerTest(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(twoOfClubs,fiveOfSpades,twoOfDiamonds,twoOfHearts,twoOfSpades);
        boolean actual = pokerChecker.fourOfAKindChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void fourOfAKindCheckerTestFalse(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(threeOfSpades,fiveOfSpades,twoOfDiamonds,twoOfHearts,twoOfSpades);
        boolean actual = pokerChecker.fourOfAKindChecker(playerHand), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countOfMatchesFromLeftChecker(){
        int[] ordinals = {0,0,0,1,1};
        int actual = pokerChecker.countOfMatchesFromLeft(ordinals), expected = 3;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countOfMatchesFromRightChecker(){
        int[] ordinals = {0,0,0,1,1};
        int actual = pokerChecker.countOfMatchesFromRight(ordinals), expected = 2;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void fullHouseCheckerTest(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(twoOfClubs,twoOfSpades,kingOfSpades, kingOfHearts,kingOfClubs);
        boolean actual = pokerChecker.fullHouseChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void fullHouseCheckerTestFalse(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(threeOfSpades,fiveOfSpades,twoOfDiamonds,aceOfSpades,twoOfSpades);
        boolean actual = pokerChecker.fullHouseChecker(playerHand), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void countOfMatchesFromPosition2Checker(){
        int[] ordinals = {0,0,0,1,1};
        int actual = pokerChecker.countOfMatchesFromPosition2(ordinals), expected = 2;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void tripsCheckerTest(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(twoOfClubs,fiveOfSpades,twoOfDiamonds,aceOfSpades,twoOfSpades);
        boolean actual = pokerChecker.tripsChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void tripsCheckerTestFalse(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(threeOfSpades,fiveOfSpades,twoOfDiamonds,aceOfSpades,twoOfSpades);
        boolean actual = pokerChecker.tripsChecker(playerHand), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForPairAroundPosition2(){
        int[] ordinals = {2,9,9,10,10};
        boolean actual = pokerChecker.checkForPairAroundPosition2(ordinals), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForPairAroundPosition2False(){
        int[] ordinals = {2,8,9,10,10};
        boolean actual = pokerChecker.checkForPairAroundPosition2(ordinals), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForPairAroundPosition4(){
        int[] ordinals = {2,9,9,10,10};
        boolean actual = pokerChecker.checkForPairAroundPosition4(ordinals), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForPairAroundPosition4False(){
        int[] ordinals = {2,8,9,10,11};
        boolean actual = pokerChecker.checkForPairAroundPosition4(ordinals), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForJacksOrBetterPairAroundPosition2(){
        int[] ordinals = {2,10,10,9,11};
        boolean actual = pokerChecker.checkForJacksOrBetterPairAroundPosition2(ordinals), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForJacksOrBetterPairAroundPosition2False(){
        int[] ordinals = {2,8,9,9,11};
        boolean actual = pokerChecker.checkForJacksOrBetterPairAroundPosition2(ordinals), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForJacksOrBetterPairAroundPosition4(){
        int[] ordinals = {2,10,10,11,11};
        boolean actual = pokerChecker.checkForJacksOrBetterPairAroundPosition4(ordinals), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForJacksOrBetterPairAroundPosition4False(){
        int[] ordinals = {2,8,9,9,11};
        boolean actual = pokerChecker.checkForJacksOrBetterPairAroundPosition4(ordinals), expected = false;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void twoPairChecker(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(threeOfSpades,aceOfDiamonds,twoOfDiamonds,aceOfSpades,twoOfSpades);
        boolean actual = pokerChecker.twoPairChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void jacksOrBetterChecker(){
        HashMap<Integer, Card> playerHand = loadPlayerHand(aceOfSpades,aceOfDiamonds,twoOfDiamonds,fourOfSpades,fiveOfSpades);
        boolean actual = pokerChecker.jacksOrBetterChecker(playerHand), expected = true;
        Assert.assertEquals(expected,actual);
    }


}
