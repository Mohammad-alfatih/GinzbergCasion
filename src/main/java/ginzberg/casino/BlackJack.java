package ginzberg.casino;

/**
 * Created by ryangross on 1/25/17.
 */
import java.util.ArrayList;

/**
 * Created by ryangross on 1/25/17.
 */
public class BlackJack extends CardGame {
    boolean playAgain;
    int currentBet;


    public void initializeBJD() {
        cardDeck.shuffle();
    }

    public void dealCards() {
        for(int i = 0; i < 2; i++) {
            this.dealCard(userHand);
            this.dealCard(dealerHand);
        }
    }

    public int findAllAces(ArrayList<Card> aHand) {
        int counter = 0;
        for(Card eachCard : aHand) {
            if (eachCard.getRank() == Ranks.ACE) {
                counter++;
            }
        }
        return counter;
    }

    public int regularScore(ArrayList<Card> aHand) {
        int score = 0;
        for(Card eachCard : aHand) {
            switch (eachCard.getRank()) {
                case ACE:
                    score += 11;
                    break;
                case JACK:
                    score += 10;
                    break;
                case QUEEN:
                    score += 10;
                    break;
                case KING:
                    score += 10;
                    break;
                default:
                    score += eachCard.getRank().ordinal() + 1;
                    break;
            }
        }
        return score;
    }

    public int calculateScore(ArrayList<Card> aHand) {
        int allAces = findAllAces(aHand);
        int mScore = regularScore(aHand);

        if ( (mScore >= 22) && (allAces != 0) ) {
            for(int i = allAces; i != 0; i--) {
                mScore -= 10;
            }
        }
        return mScore;
    }

    public void userTurn(UserIO aUI) {
        String answer = aUI.hitOrSurrender();

        if (this.calculateScore(userHand) < 21) {
            if (answer == "hit") {
                this.dealCard(userHand);
                userTurn(aUI);
            }
        }
    }

    public String showFirstCards(UserIO aUI) {
        String answer = "Dealer: " + this.dealerHand.get(1).getRank() + " of " + this.dealerHand.get(1).getSuit() + "\n" +
                "You: " + this.userHand.get(1).getRank() + " of " + this.userHand.get(1).getSuit();
        aUI.displayTurn(answer);
        return answer;
    }

    public void dealerTurn(UserIO aUI) {
        String display = "";
        if(this.calculateScore(dealerHand) >= 17) {
            display += "Dealer stayed at " + calculateScore(dealerHand);
            aUI.displayTurn(display);
        } else {
            dealerTurn(aUI);
            display += "Dealer hit: " + calculateScore(dealerHand);
            aUI.displayTurn(display);
        }
    }

    public String compareScores(UserIO aUI) {
        String answer = "";
        int user = calculateScore(userHand);
        int dealer = calculateScore(dealerHand);
        if (user > dealer) {
            answer += "You Won! Your " + user + " to the dealer's " + dealer;
        } else if (user < dealer) {
            answer += "You lost! Your " + user + " to the dealer's " + dealer;
        } else {
            answer += "Push! Both parties at" + user;
        }
        return answer;
    }

    public double payOut(UserIO aUI) {
        double total;

        if ( (calculateScore(userHand) == 21) && userHand.size() == 2) {
            total = (currentBet * 1.5);
        }
        total = currentBet;
        aUI.setUserBalance(aUI.getUserBalance() + total);
        return total;
    }

    public int clearBet() {
        currentBet = 0;
        return currentBet;
    }

    public void playRound(UserIO aUI) {
        currentBet = aUI.askForBet();
        initializeBJD();
        dealCards();
        showFirstCards(aUI);
        userTurn(aUI);
        dealerTurn(aUI);
        payOut(aUI);
        clearBet();
        aUI.anotherRound();
    }

    public void playBlackJack(UserIO aUI) {
        playRound(aUI);

    }


}