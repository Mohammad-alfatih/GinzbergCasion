package ginzberg.casino.CardGames.Poker;

/**
 * Created by anthonypajerowski on 1/25/17.
 */
public class PokerStarter {
<<<<<<< HEAD
    static PokerGameController pgc = new PokerGameController();

    public static void main(String[] args) {
            pgc.playPoker();
        }
    }

=======
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
>>>>>>> 9afa09ee822774bb2ad6424bc0bf7068b7bf41f2

