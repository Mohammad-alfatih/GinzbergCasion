package ginzberg.casino.CardGames.Cart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mkulima on 1/27/17.
 */
public class AsciiImages {
    DetermineFilePath determineFilePath = new DetermineFilePath();
    //String rootLoc = "//Users/anthonypajerowski/Casino/GinzbergCasion/src/main/java/ginzberg/casino/CardGames/Cart/";
    String rootLoc = determineFilePath.whereAmI()+"/src/main/java/ginzberg/casino/CardGames/Cart/";
    //String rootLoc = "/Users/williammattern/dev/GinzbergCasion/src/main/java/ginzberg/casino/CardGames/Cart/";

    public void showJoker() {
            String jokerString = rootLoc + "joker2.txt";
            readAndDisplay(jokerString);
    }

    public void showCasino() {
        String casinoString = rootLoc + "AsciiCasinoName.txt";
        readAndDisplay(casinoString);
    }

    public void showLetsPlayBlackJack() {
        String blackJackString = rootLoc + "gn_BlackJack.txt";
        readAndDisplay(blackJackString );
    }

    public void showLetsPlayCasinoWar() {
        String casinoWArString = rootLoc + "gn_casinoWar.txt";
        readAndDisplay(casinoWArString);
    }

    public void showLetsPlayPoker() {
        String pokerString = rootLoc + "gn_PokerName.txt";
        readAndDisplay(pokerString);
    }

    public void showLetsPlayRoulette() {
        String rouletteString = rootLoc + "gn_RouletteName.txt";
        readAndDisplay(rouletteString);
    }

    public void readAndDisplay(String fileName){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                try {
                    Thread.sleep(25);
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
