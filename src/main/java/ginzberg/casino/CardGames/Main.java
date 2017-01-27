package ginzberg.casino.CardGames;

/**
 * Created by ryangross on 1/25/17.
 */
public class Main {
    static boolean inCasino = true;
    public static void main(String[] args) {
        Casino init = new Casino();
        UserIO initIO = new UserIO();
        initIO.firstWelcome();
        while(inCasino) {
            init.play(initIO);
            initIO.additionalWelcome();
        }
    }
}

