package ginzberg.casino.CardGames.Poker;

/**
 * Created by anthonypajerowski on 1/25/17.
 */
public class PokerStarter {
    static PokerGameController pgc;
    static boolean playAgain = true;

    public static void main(String[] args) {
        while (playAgain) {
            pgc = new PokerGameController();
            pgc.playPoker();
            System.out.println("would you like to play again? (y/n)");

            if (pgc.sc.next().equalsIgnoreCase("n")) {
                playAgain = false;
            }

        }
    }
}

