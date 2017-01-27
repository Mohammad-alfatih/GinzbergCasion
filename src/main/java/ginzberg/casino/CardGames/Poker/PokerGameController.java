package ginzberg.casino.CardGames.Poker;
import ginzberg.casino.CardGames.Cart.AsciiImages;
import ginzberg.casino.CardGames.UserIO;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anthonypajerowski on 1/25/17.
 */

public class PokerGameController {
    Scanner sc = new Scanner(System.in);
    PokerCardHandler pokerCards;
    PokerPayout payout = new PokerPayout();
    PokerInputParser parser = new PokerInputParser();
    PokerChecker checker = new PokerChecker();
    UserIO pokerPlayer = new UserIO();
    AsciiImages images = new AsciiImages();

    HashMap<Integer, String> gameType = new HashMap<>();
    {
        gameType.put(1, "jacksOrBetter");
        gameType.put(2, "tensOrBetter");
        gameType.put(3, "acesAndEights");
        gameType.put(4, "doubleBonus");
    }

    public void playPoker() {

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
            if(checker.getWinConditionThatIsMet(pokerCards.playerHand).equals("lostHand")) {
                images.showWin();
            } else {
                images.showLose();
            }
            pokerPlayer.setUserBalance(pokerPlayer.getUserBalance() + payout.payWinnings(checker.getWinConditionThatIsMet(pokerCards.playerHand)));
            pokerPlayer.displayUserBalance();

    }
}