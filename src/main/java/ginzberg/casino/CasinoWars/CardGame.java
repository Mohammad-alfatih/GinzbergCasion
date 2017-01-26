package ginzberg.casino;

import java.util.ArrayList;

/**
 * Created by ryangross on 1/25/17.
 */
<<<<<<< HEAD
public class CardGame extends Game {
    protected CardDeck cardDeck = new CardDeck();
    protected ArrayList<Card> userHand = new ArrayList<Card>();
    protected ArrayList<Card> dealerHand = new ArrayList<Card>();

    public CardGame() {

=======
public abstract class CardGame extends Game {
    public CardDeck cardDeck = new CardDeck();
    public ArrayList<Card> userHand = new ArrayList<Card>();
    public ArrayList<Card> dealerHand = new ArrayList<Card>();

    public CardGame() {
>>>>>>> marwas_testmerge
    }

    public CardGame(CardDeck aCardDeck, ArrayList<Card> aUserHand, ArrayList<Card> aDealerHand) {
        this.cardDeck = aCardDeck;
        this.userHand = aUserHand;
        this.dealerHand = aDealerHand;
    }

    public CardGame(CardDeck aCardDeck, ArrayList<Card> aUserHand) {
        this.cardDeck = aCardDeck;
        this.userHand = aUserHand;
    }

    // Setter & Shuffler
    public void initializeDeck() {
        this.cardDeck.shuffle();
    }

    // Getter
    public ArrayList<Card> getUserHand() {
        return this.userHand;
    }

<<<<<<< HEAD
    // Getter
    public ArrayList<Card> getDealerHand() {
        return this.dealerHand;
    }

=======
>>>>>>> marwas_testmerge
    public void dealCard(ArrayList<Card> aHand) {
        aHand.add(this.cardDeck.getNextCard());
    }

<<<<<<< HEAD
=======
    public double calculateScore() {
        return 0.0;
    }
>>>>>>> marwas_testmerge

    // Tentative. Does it need a Scanner?
    public String getUserChoice() {
        return "";
    }
<<<<<<< HEAD
=======


}
>>>>>>> marwas_testmerge
