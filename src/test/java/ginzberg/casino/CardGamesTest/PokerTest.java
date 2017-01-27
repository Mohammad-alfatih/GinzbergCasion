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
public class PokerTest {

    PokerChecker pokerChecker = new PokerChecker();

    @Test
    public void flushChecker(){
        CardDeck deck = new CardDeck();
        Card aceOfSpades = new Card(Ranks.ACE, Suits.SPADES);
        Card twoOfSpades = new Card(Ranks.TWO, Suits.SPADES);
        Card threeOfSpades = new Card(Ranks.THREE, Suits.SPADES);
        Card fourOfSpades = new Card(Ranks.FOUR, Suits.SPADES);
        Card fiveOfSpades = new Card(Ranks.FIVE, Suits.SPADES);
        deck.cards.add(0,aceOfSpades);
        deck.cards.add(1,twoOfSpades);
        deck.cards.add(2,threeOfSpades);
        deck.cards.add(3,fourOfSpades);
        deck.cards.add(4,fiveOfSpades);
        HashMap<Integer, Card> playerHand = new HashMap<>();
        for (int i = 0; i < 5; i++){
            playerHand.put(i,deck.getNextCard());
        }
        boolean actual = pokerChecker.flushChecker(playerHand), expected = true;
        Assert.assertEquals(actual,expected);
    }
}
