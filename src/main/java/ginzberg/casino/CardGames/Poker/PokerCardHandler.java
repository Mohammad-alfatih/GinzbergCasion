package ginzberg.casino.CardGames.Poker;
import ginzberg.casino.CardGames.Card;
import ginzberg.casino.CardGames.CardDeck;

import java.util.HashMap;

/**
 * Created by anthonypajerowski on 1/25/17.
 */

public class PokerCardHandler {

    int sizeOfHand = 5;

    CardDeck deck = new CardDeck();
    {
        deck.shuffle();
    }

    HashMap<Integer, Card> playerHand = new HashMap<>(sizeOfHand);
    {
        for ( int i = 1; i <= sizeOfHand; i++) {
            playerHand.put(i, deck.getNextCard());
        }
    }

    HashMap<Integer, Boolean> cardsToReplace = new HashMap<>();
    {
        for ( int i = 1; i <= sizeOfHand; i++) {
            cardsToReplace.put(i, false);
        }
    }

    public HashMap dealHand() {
        return playerHand;
    }

    public String showHand() {
        String hand= "";
        for (int i = 1; i <= sizeOfHand; i++) {     // SEE HAND in controller?
            hand += "Card " + i + ": " + playerHand.get(i).getRank() + " of " +
                    playerHand.get(i).getSuit() + "\n";
        }
        return hand;
    }

    void setCardsToReplace(int[] cardNumber) {
        for (int i = 0; i < cardNumber.length; i++) {
            cardsToReplace.replace(cardNumber[i], false, true);
        }
    }

    public void replaceCards() {
        for (int i = 1; i <= playerHand.size(); i++) {

            if (cardsToReplace.get(i)) {
                playerHand.remove(i);
                playerHand.put(i, deck.getNextCard());
            }
        }
    }
}