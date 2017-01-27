package ginzberg.casino.CardGames.Cart;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mkulima on 1/26/17.
 */
public class ReadAndPrintImage {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/home/mkulima/dev/labs/GinzbergCasion/src/main/java/ginzberg/casino/CardGames/Cart/joker.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}
