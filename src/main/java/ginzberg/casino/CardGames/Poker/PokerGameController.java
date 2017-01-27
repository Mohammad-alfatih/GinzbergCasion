package ginzberg.casino.CardGames.Poker;
import ginzberg.casino.CardGames.UserIO;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anthonypajerowski on 1/25/17.
 */

class PokerGameController {
    Scanner sc = new Scanner(System.in);
    PokerCardHandler pokerCards;
    PokerPayout payout = new PokerPayout();
    PokerInputParser parser = new PokerInputParser();
    PokerChecker checker = new PokerChecker();
    UserIO pokerPlayer = new UserIO();

    HashMap<Integer, String> gameType = new HashMap<>();
    {
        gameType.put(1, "jacksOrBetter");
        gameType.put(2, "tensOrBetter");
        gameType.put(3, "acesAndEights");
        gameType.put(4, "doubleBonus");
    }

    void playPoker() {

        pokerPlayer.getUserInput();
        pokerPlayer.welcome();
        while (pokerPlayer.getPlayAgain() == true) {
//           //pokerPlayer.displayTurn("What game would you like to play? \n Enter '1' for 'Jacks or better" +
//           //         "\n Enter '2' for 'Tens or Better'\n Enter '3' for 'Aces and Eights'\n Enter '4' for 'Double Bonus'");
//            payout.setGamePayoutOdds(gameType.get(pokerPlayer.userInput.nextInt()));
            pokerCards = new PokerCardHandler();
            pokerCards.dealHand();
            pokerPlayer.displayUserBalance();
            payout.setBetSize(pokerPlayer.askForBet());
            pokerPlayer.displayTurn(pokerCards.showHand());
            pokerPlayer.displayTurn("which cards would you like to exchange? (enter \"none\" to keep hand as is):");
            pokerCards.setCardsToReplace(parser.parseUserInput(sc.next()));
            pokerCards.replaceCards();
            pokerPlayer.displayTurn(pokerCards.showHand());
            pokerPlayer.displayTurn(checker.getWinConditionThatIsMet(pokerCards.playerHand));
            pokerPlayer.setUserBalance(pokerPlayer.getUserBalance() + payout.payWinnings(checker.getWinConditionThatIsMet(pokerCards.playerHand)));
            pokerPlayer.displayUserBalance();
            pokerPlayer.setPlayAgain(pokerPlayer.anotherRound());
        }
    }
}