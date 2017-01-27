package ginzberg.casino.CardGames;

/**
 * Created by ryangross on 1/25/17.
 */
public class Main {
    static boolean inCasino = true;
    static Casino init;
    static UserIO initIO;

    public static void main(String[] args) {
        init = new Casino();
        initIO = new UserIO();
        initIO.firstWelcome();
        int counter = 0;
        while(inCasino) {
            init.play(initIO, counter);
            initIO.additionalWelcome();
            counter++;

        }
    }
}

