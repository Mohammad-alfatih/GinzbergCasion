package ginzberg.casino.CardGames.CasinoWars;

import ginzberg.casino.CardGames.*;

import java.util.ArrayList;

/**
 * Created by mkulima on 1/25/17.
 */
public class Casino_Wars extends CardGame {
    /* By default, these exist from the parent
    *  protected CardDeck cardDeck = new CardDeck();
    *  protected ArrayList<Card> userHand = new ArrayList<Card>();
    *  protected ArrayList<Card> dealerHand = new ArrayList<Card>();
    * */
  //  protected CardDeck dealerDeck = new CardDeck();
   // protected CardDeck userDeck = new CardDeck();
   // protected Card dealerCard;
   // protected Card userCard;
    protected ArrayList<Card> dumpCards = new ArrayList<Card>(104);
    int numberofWar = 0;

    public Casino_Wars(){
        super();
        this.userHand = new ArrayList<Card>();
    }

    // Initialize/shuffle deck
    public void dealCards() {
        /* inputDeck is the deck to deal from - can be userDeck or dealerDeck
        * burnCards is number of cards to burn prior to picking */
       // cardDeck.shuffle();
        dealCard(userHand);
        dealCard(dealerHand);
    }

    public int warDrawCard(ArrayList<Card> aHand) {

        for(int i = 0; i < 3; i++) {
            dealCard(dumpCards);
            }
        dealCard(aHand);
        return dumpCards.size();
    }

    public void warDealCards() {
        warDrawCard(userHand);
        warDrawCard(dealerHand);
    }


    public int getCardScore(ArrayList<Card> aHand) {
        if (aHand.get(aHand.size() - 1).getRank() != Ranks.ACE) {
            return aHand.get(aHand.size() - 1).getRank().ordinal() + 1;
        } else {
            return 11;
        }
    }

    public String displayWinner(UserIO aUI) {
        String answer = "";

        if (greaterThanDealer()) {
            answer += "Your " + getCardScore(userHand) + " beats the dealer's " + getCardScore(dealerHand) + "!\n" +
                    "You win the round. You get $" + currentBet + "!";
            payOut(aUI, currentBet * 2);
            // PAYOUT
            //
            aUI.displayTurn(answer);
            aUI.displayUserBalance();
        } else if (lessThanDealer()) {
            answer += "The dealer's " + getCardScore(dealerHand) + "beats your " + getCardScore(userHand) + "!\n" +
                    "You lose the round.";
            aUI.displayTurn(answer);
            aUI.displayUserBalance();
        } else {
            answer += "Both players are at " + getCardScore(userHand) + "!\n" +
                    "War! And, what is it good for? Absolutely nothing! Draw again.";
            aUI.displayTurn(answer);
        }
        return answer;
    }

    public boolean greaterThanDealer() {
        return getCardScore(userHand) > getCardScore(dealerHand);
    }

    public boolean lessThanDealer() {
        return getCardScore(userHand) < getCardScore(dealerHand);
    }

    public boolean isNotWar() {
        return getCardScore(userHand) != getCardScore(dealerHand);
    }

    public void playRound(UserIO aUI) {
         currentBet = aUI.askForBet();
         initializeCasinoWars();
         dealCards();
         if (!isNotWar()) {
             displayWinner(aUI);
             while (isNotWar() == false) {
                 numberofWar += 2;
                 warDealCards();
                 displayWinner(aUI);
             }
         } else {
             displayWinner(aUI);
         }
         clearBet();
    }

    public double payOut(UserIO aUI, double aPayOut) {
        double total;

        if (numberofWar != 0) {
            total = aUI.getUserBalance() + (aPayOut * numberofWar);
        } else {
            total = aUI.getUserBalance() + aPayOut;
        }
        aUI.setUserBalance(total);
        return total;
    }

    public double clearBet() {
        currentBet = 0;
        return currentBet;
    }

    public void initializeCasinoWars() {
        cardDeck.shuffle();
    }

}
