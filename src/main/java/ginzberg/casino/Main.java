package ginzberg.casino;

/**
 * Created by ryangross on 1/25/17.
 */
public class Main {

    public static void main(String[] args) {
        Casino init = new Casino();
        UserIO initIO = new UserIO();
        init.play(initIO);
    }
}
