package ginzberg.casino.CardGamesTest;
import ginzberg.casino.CardGames.Poker.PokerPayout;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by anthonypajerowski on 1/25/17.
 */
public class PokerPayoutTest {

        PokerPayout payout;

    @Before
    public void setup() {
        payout = new PokerPayout();
        payout.setBetSize(2);
    }

    @Test
    public void payWinningsLostHandTest(){
        Double expected = 0.0d;
        Double actual = payout.payWinnings("lostHand");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsJackOrBetterPairTest(){
        Double expected = 2.0d;
        Double actual = payout.payWinnings("jacksOrBetter");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsTwoPairTest(){
        Double expected = 4.0d;
        Double actual = payout.payWinnings("twoPair");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsThreeOfAKindTest(){
        Double expected = 6.0d;
        Double actual = payout.payWinnings("threeOfAKind");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsStraightTest(){
        Double expected = 8.0d;
        Double actual = payout.payWinnings("straight");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsFlushTest(){
        Double expected = 10.0d;
        Double actual = payout.payWinnings("flush");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsFullHouseTest(){
        Double expected = 18.0d;
        Double actual = payout.payWinnings("fullHouse");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsFourOfAKindTest(){
        Double expected = 50.0d;
        Double actual = payout.payWinnings("fourOfAKind");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsStraightFlushTest(){
        Double expected = 100.0d;
        Double actual = payout.payWinnings("straightFlush");
        assertEquals(expected,actual);

    }
    @Test
    public void payWinningsRoyalFlushTest(){
        Double expected = 1600.0d;
        Double actual = payout.payWinnings("royalFlush");
        assertEquals(expected,actual);

    }


}
