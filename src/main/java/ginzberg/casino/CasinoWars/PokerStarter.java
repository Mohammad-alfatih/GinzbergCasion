package ginzberg.casino;

/**
 * Created by anthonypajerowski on 1/25/17.
 */
public class Main {
    static PokerGameController pgc = new PokerGameController();
    static boolean playAgain = true;

    public static void main(String[] args) {
        while (playAgain) {
            pgc.playPoker();
            System.out.println("would you like to play again? (y/n)");
            System.out.println(pgc.sc.next());

            }
        }
    }

