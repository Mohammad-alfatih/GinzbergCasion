package ginzberg.casino.CardGamesTest;

import ginzberg.casino.CardGames.UserIO;
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
        System.out.println(wooMan.getUserName());
        //Assert.assertTrue(wooMan.getUserName().equals("Woo man"));
    }


}
