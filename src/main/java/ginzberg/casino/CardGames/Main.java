package ginzberg.casino.CardGames;

/**
 * Created by ryangross on 1/25/17.
 */
public class Main {
    static boolean inCasino = true;
    public static void main(String[] args) {
        while(inCasino) {
            Casino init = new Casino();
            UserIO initIO = new UserIO();
            init.play(initIO);
        }
    }
}

