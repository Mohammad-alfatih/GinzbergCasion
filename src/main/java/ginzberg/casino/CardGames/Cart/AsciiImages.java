package ginzberg.casino.CardGames.Cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mkulima on 1/27/17.
 */
public class AsciiImages {
    //String rootLoc = "//Users/anthonypajerowski/Casino/GinzbergCasion/src/main/java/ginzberg/casino/CardGames/Cart/";
    String rootLoc = "/home/mkulima/dev/labs/GinzbergCasion/src/main/java/ginzberg/casino/CardGames/Cart/";
    //String rootLoc = "/Users/williammattern/dev/GinzbergCasion/src/main/java/ginzberg/casino/CardGames/Cart/";

    public void showJoker() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(rootLoc+"joker2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCasino() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(rootLoc+"AsciiCasinoName.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
