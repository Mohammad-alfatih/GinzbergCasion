package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.CasinoWars.Casino_Wars;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mkulima on 1/26/17.
 */
public class CasinoWarsTests {
    Casino_Wars casinoWars;

    @Before
    public void setup(){
        casinoWars = new Casino_Wars();
        casinoWars.dealCards();
    }

    @Test
    public void warDrawCard_Test(){
        casinoWars.warDrawCard(casinoWars.getUserHand());
        System.out.println("The following cards wer drawn after war: \n" + casinoWars.getUserHand().toString());
    }
}
