package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.CasinoWars.Casino_Wars;
import ginzberg.casino.CardGames.UserIO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mkulima on 1/26/17.
 */
public class CasinoWarsTests {
    Casino_Wars casinoWars;
    UserIO aUI;

    @Before
    public void setup(){
        aUI = new UserIO(100, "Woo Man");
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

    @Test
    public void payOutTest(){
        Assert.assertEquals(200, casinoWars.payOut(aUI,100), 1);
    }

    @Test
    public void clearBetTest(){
        Assert.assertEquals(0, casinoWars.clearBet(), 1);
    }
}
