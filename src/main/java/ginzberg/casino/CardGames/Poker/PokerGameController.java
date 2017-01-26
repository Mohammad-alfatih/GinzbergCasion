package ginzberg.casino.CardGames.Poker;
import ginzberg.casino.CardGames.UserIO;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by anthonypajerowski on 1/25/17.
 */

class PokerGameController {
    Scanner sc = new Scanner(System.in);
    PokerCardHandler pokerCards = new PokerCardHandler();
    PokerPayout payout = new PokerPayout();
    PokerInputParser parser = new PokerInputParser();
    PokerChecker checker = new PokerChecker();
<<<<<<< HEAD
    UserIO pokerPlayer = new UserIO();
=======


    String promtUserForBetAmount;
>>>>>>> 9afa09ee822774bb2ad6424bc0bf7068b7bf41f2


    HashMap<Integer, String> gameType = new HashMap<>();
    {
        gameType.put(1, "jacksOrBetter");
        gameType.put(2, "tensOrBetter");
        gameType.put(3, "acesAndEights");
        gameType.put(4, "doubleBonus");
    }

    void playPoker() {
<<<<<<< HEAD
        pokerPlayer.getUserInput();
        pokerPlayer.welcome();
        while (pokerPlayer.getPlayAgain() == true) {
            pokerPlayer.displayTurn("What game would you like to play? \n Enter '1' for 'Jacks or better" +
                    "\n Enter '2' for 'Tens or Better'\n Enter '3' for 'Aces and Eights'\n Enter '4' for 'Double Bonus'");
            payout.setGamePayoutOdds(gameType.get(pokerPlayer.userInput.nextInt()));
            pokerCards.deck.shuffle();
            pokerCards.dealHand();
            payout.setBetSize(pokerPlayer.askForBet());
            System.out.println(pokerCards.showHand());
            pokerPlayer.displayTurn("which cards would you like to exchange? (enter \"none\" to keep hand as is):");
            pokerCards.setCardsToReplace(parser.parseUserInput(sc.next()));
            pokerCards.replaceCards();
            pokerPlayer.displayTurn(pokerCards.showHand());
            pokerPlayer.displayTurn(checker.getWinConditionThatIsMet(pokerCards.playerHand));
            pokerPlayer.anotherRound();
            pokerPlayer.getPlayAgain();
        }
=======
//        System.out.println("What game would you like to play?");
//        System.out.println("(Enter '1' for 'Jacks Or Better)\n Enter '2' for 'Tens or Better'\n Enter '3' " +
//                        "for 'Aces and Eights'\n Enter '4' for 'Double Bonus'");
//        payout.setGamePayoutOdds(gameType.get(sc.next()));
        System.out.println(payout.gamePayoutOdds);
        //pokerCards.deck.shuffle();
        pokerCards.dealHand();
        System.out.format("Enter the amount you would like to bet (Between 1 and %d):\n", (int) playerMoney);
        payout.setBetSize(sc.nextInt());
        System.out.println("your hand is: ");
        System.out.println(pokerCards.showHand());
        System.out.println("which cards would you like to exchange? (enter \"none\" to keep hand as is):");
        pokerCards.setCardsToReplace(parser.parseUserInput(sc.next()));
        pokerCards.replaceCards();
        System.out.println(pokerCards.showHand());
        System.out.println(checker.getWinConditionThatIsMet(pokerCards.playerHand));

>>>>>>> 9afa09ee822774bb2ad6424bc0bf7068b7bf41f2
    }
}