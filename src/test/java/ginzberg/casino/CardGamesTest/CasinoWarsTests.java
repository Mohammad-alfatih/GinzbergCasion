package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.CasinoWars.Casino_Wars;
import org.junit.Assert;
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
        Assert.assertEquals(3,casinoWars.warDrawCard(casinoWars.getUserHand()));
        Assert.assertEquals(6,casinoWars.warDrawCard(casinoWars.getDealerHand()));
    }

    @Test
    public void getCardScoreTest(){
        Assert.assertEquals(11, casinoWars.getCardScore(casinoWars.getUserHand()));
        Assert.assertEquals(2, casinoWars.getCardScore(casinoWars.getDealerHand()));
    }

    @Test
    public void greaterThanDealerTest(){
        Assert.assertTrue(casinoWars.greaterThanDealer());
        Assert.assertTrue(!casinoWars.lessThanDealer());
    }


}
