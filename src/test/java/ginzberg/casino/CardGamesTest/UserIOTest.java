package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.UserIO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by mkulima on 1/26/17.
 */
public class UserIOTest {
    UserIO wooMan;

    @Before
    public void setup(){
        wooMan = new UserIO(100, "Woo Man");
    }

    @Test
    public void getUserNameTest(){
        String expectedName = wooMan.getUserName();
        String actualName = "Woo Man";

        String expectedBalanceMessage = "Your current balance is $100.0";
        String actualbalanceMessage = wooMan.displayUserBalance();

        Assert.assertTrue(expectedName.equals(actualName));
        Assert.assertTrue(wooMan.getUserBalance()==100);
        Assert.assertTrue(expectedBalanceMessage.equals(actualbalanceMessage));
    }

}
