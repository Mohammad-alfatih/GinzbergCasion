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
        String answer;
        String display = "";

        if (hasBlackJack(userHand)) {
            display += "BlackJack!\n";
            aUI.displayTurn(display);
        } else if (calculateScore(userHand) < 21) {

            answer = hitOrSurrender(aUI);

            while (!answer.equalsIgnoreCase("surrender"))
                if (isOver(userHand, 21)) {
                    display += "You busted at: " + this.calculateScore(userHand) + "\n";
                    aUI.displayTurn(display);
                    break;
                } else {
                    hit(display, aUI, userHand);
                    answer = hitOrSurrender(aUI);
                }
        }
    }

    public String hitOrSurrender(UserIO uIO) {

        if (calculateScore(userHand) <= 21) {
            System.out.println("Hit, or surrender?");
            String answer = uIO.userInput.next();
            return answer;
        } else {
            // System.out.println("Bust at " + calculateScore(userHand));
            return "Bust";
        }
    }

    public boolean isOver(ArrayList<Card> aHand, int number) {
        return (calculateScore(aHand) > number);
    }

    public boolean hasBlackJack(ArrayList<Card> aHand) {
        return calculateScore(aHand) == 21;
    }

    public void hit(String aString, UserIO aUI, ArrayList<Card> aHand) {
        this.dealCard(aHand);
        aString += "You hit, score is now: " + this.calculateScore(aHand);
        aUI.displayTurn(aString);
    }

    public String showFirstCards(UserIO aUI) {
        String answer = "Dealer: " + this.dealerHand.get(1).getRank() + " of " + this.dealerHand.get(1).getSuit() + "\n" +
                "You: " + this.userHand.get(0).getRank() + " of " + this.userHand.get(0).getSuit() + ", " +
                this.userHand.get(1).getRank() + " of " + this.userHand.get(1).getSuit();

        aUI.displayTurn(answer);
        return answer;
    }


    public void dealerTurn(UserIO aUI) {
        String display = "";
        if (this.calculateScore(dealerHand) >= 17) {
            display += "Dealer stayed at: " + calculateScore(dealerHand);
            aUI.displayTurn(display);
        } else {
            while (calculateScore(dealerHand) < 17) {
                this.dealCard(dealerHand);
                if (isOver(dealerHand, 21)) {
                    display += "Dealer busted at: " + this.calculateScore(dealerHand) + "\n";
                    aUI.displayTurn(display);
                } else if (calculateScore(dealerHand) > 17) {
                    display += "Dealer stayed at: " + calculateScore(dealerHand);
                    aUI.displayTurn(display);
                } else {
                    this.dealCard(dealerHand);
                    display += "Dealer hit: " + calculateScore(dealerHand);
                    aUI.displayTurn(display);
                }

            }
        }
    }

    public String compareScores(UserIO aUI) {
        String answer = "";
        int user = calculateScore(userHand);
        int dealer = calculateScore(dealerHand);
        if ( ((user > dealer) ||  (hasBlackJack(userHand))) && isOver(dealerHand, 21) ) {
            answer += "You Won! Your " + user + " to the dealer's " + dealer + "\n" +
                    "You won : " + currentBet + "\n" + "Total: " + aUI.getUserBalance();
            payOut(aUI);
        } else if ((user < dealer) && (!isOver(dealerHand, 21))) {
            answer += "You lost! Your " + user + " to the dealer's " + dealer + "\n" +
                    "Remaining Balance :" + aUI.getUserBalance();
        } else {
            answer += "Push! Both parties at" + calculateScore(userHand);
        }
        aUI.displayTurn(answer);
        return answer;
    }

    public double payOut(UserIO aUI) {
        double total;
        if (  (hasBlackJack(userHand) && (userHand.size() == 2)) ) {
            total = currentBet * 2.5;
        } else {
            total = currentBet * 2;
        }

        userBalance += total;
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
        compareScores(aUI);
        //payOut(aUI);
        clearBet();
        aUI.anotherRound();
    }

    public void playBlackJack(UserIO aUI) {
        playRound(aUI);
    }

}