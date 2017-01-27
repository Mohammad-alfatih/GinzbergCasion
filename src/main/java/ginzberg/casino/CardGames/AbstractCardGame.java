package ginzberg.casino.CardGames;

import java.util.ArrayList;

/**
 * Created by mkulima on 1/27/17.
 */
public class AbstractCardGame {
    protected CardDeck cardDeck = new CardDeck();
    protected ArrayList<Card> userHand = new ArrayList<Card>();
    protected ArrayList<Card> dealerHand = new ArrayList<Card>();
    protected double currentBet;
}
