package ginzberg.casino.Roulette;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by rickjackson on 1/25/17.
 */
public class BetTest {
    private Bet bet;

    @Before
    public void setup() {
        bet = new Bet();
    }

    @Test
    public void getBetTypeTest() {

        String expected = "Straight Up";
        String actual = bet.getBetType('A');
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        assertEquals("I expect the result to be: Straight Up", expected, actual);
    }

    @Test
    public void getWinningColumnBetTest() {

        int expected = 2;
        int actual = bet.getWinningColumnBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Column '" + bet.getWinningColumnBet(0) + "'");
        System.out.println("'00' Test  : Column '" + bet.getWinningColumnBet(37) + "'");
        System.out.println("'34' Test  : Column '" + bet.getWinningColumnBet(34) + "'");
        System.out.println("'35' Test  : Column '" + bet.getWinningColumnBet(35) + "'");
        System.out.println("'36' Test  : Column '" + bet.getWinningColumnBet(36) + "'");
        assertEquals("I expect the result to be: 2", expected, actual);
    }

    @Test
    public void getWinningDozenBetTest() {

        int expected = 1;
        int actual = bet.getWinningDozenBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Dozen '" + bet.getWinningDozenBet(0) + "'");
        System.out.println("'00' Test  : Dozen '" + bet.getWinningDozenBet(37) + "'");
        System.out.println(" '7' Test  : Dozen '" + bet.getWinningDozenBet(7) + "'");
        System.out.println("'20' Test  : Dozen '" + bet.getWinningDozenBet(20) + "'");
        System.out.println("'36' Test  : Dozen '" + bet.getWinningDozenBet(36) + "'");
        assertEquals("I expect the result to be: 1", expected, actual);
    }

    @Test
    public void getWinningRedBlackBetTest() {

        int expected = 2;
        int actual = bet.getWinningRedBlackBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Red/Black '" + bet.getWinningRedBlackBet(0) + "'");
        System.out.println("'00' Test  : Red/Black '" + bet.getWinningRedBlackBet(37) + "'");
        System.out.println(" '7' Test  : Red/Black '" + bet.getWinningRedBlackBet(7) + "'");
        System.out.println("'20' Test  : Red/Black '" + bet.getWinningRedBlackBet(20) + "'");
        System.out.println("'36' Test  : Red/Black '" + bet.getWinningRedBlackBet(36) + "'");
        assertEquals("I expect the result to be: 2", expected, actual);
    }

    @Test
    public void getWinningHalfBetTest() {

        int expected = 1;
        int actual = bet.getWinningHalfBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Half '" + bet.getWinningHalfBet(0) + "'");
        System.out.println("'00' Test  : Half '" + bet.getWinningHalfBet(37) + "'");
        System.out.println(" '7' Test  : Half '" + bet.getWinningHalfBet(7) + "'");
        System.out.println("'20' Test  : Half '" + bet.getWinningHalfBet(20) + "'");
        System.out.println("'36' Test  : Half '" + bet.getWinningHalfBet(36) + "'");
        assertEquals("I expect the result to be: 1", expected, actual);
    }

    @Test
    public void getWinningEvenOddBetTest() {

        int expected = 1;
        int actual = bet.getWinningEvenOddBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : EvenOdd '" + bet.getWinningEvenOddBet(0) + "'");
        System.out.println("'00' Test  : EvenOdd '" + bet.getWinningEvenOddBet(37) + "'");
        System.out.println(" '7' Test  : EvenOdd '" + bet.getWinningEvenOddBet(7) + "'");
        System.out.println("'20' Test  : EvenOdd '" + bet.getWinningEvenOddBet(20) + "'");
        System.out.println("'36' Test  : EvenOdd '" + bet.getWinningEvenOddBet(36) + "'");
        assertEquals("I expect the result to be: 1", expected, actual);
    }

    @Test
    public void getWinningSplitUpBetTest() {

        int expected = 5;
        int actual = bet.getWinningSplitUpBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : SplitUp '" + bet.getWinningSplitUpBet(0) + "'");
        System.out.println("'00' Test  : SplitUp '" + bet.getWinningSplitUpBet(37) + "'");
        System.out.println(" '7' Test  : SplitUp '" + bet.getWinningSplitUpBet(7) + "'");
        System.out.println("'20' Test  : SplitUp '" + bet.getWinningSplitUpBet(20) + "'");
        System.out.println("'36' Test  : SplitUp '" + bet.getWinningSplitUpBet(36) + "'");
        assertEquals("I expect the result to be: 5", expected, actual);
    }

    @Test
    public void getWinningSplitDownBetTest() {

        int expected = 8;
        int actual = bet.getWinningSplitDownBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : SplitDown '" + bet.getWinningSplitDownBet(0) + "'");
        System.out.println("'00' Test  : SplitDown '" + bet.getWinningSplitDownBet(37) + "'");
        System.out.println(" '7' Test  : SplitDown '" + bet.getWinningSplitDownBet(7) + "'");
        System.out.println("'20' Test  : SplitDown '" + bet.getWinningSplitDownBet(20) + "'");
        System.out.println("'36' Test  : SplitDown '" + bet.getWinningSplitDownBet(36) + "'");
        assertEquals("I expect the result to be: 8", expected, actual);
    }

    @Test
    public void getWinningSplitLeftBetTest() {

        int expected = 7;
        int actual = bet.getWinningSplitLeftBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : SplitLeft '" + bet.getWinningSplitLeftBet(0) + "'");
        System.out.println("'00' Test  : SplitLeft '" + bet.getWinningSplitLeftBet(37) + "'");
        System.out.println(" '7' Test  : SplitLeft '" + bet.getWinningSplitLeftBet(7) + "'");
        System.out.println("'20' Test  : SplitLeft '" + bet.getWinningSplitLeftBet(20) + "'");
        System.out.println("'36' Test  : SplitLeft '" + bet.getWinningSplitLeftBet(36) + "'");
        assertEquals("I expect the result to be: 7", expected, actual);
    }

    @Test
    public void getWinningSplitRightBetTest() {

        int expected = 8;
        int actual = bet.getWinningSplitRightBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : SplitRight '" + bet.getWinningSplitRightBet(0) + "'");
        System.out.println("'00' Test  : SplitRight '" + bet.getWinningSplitRightBet(37) + "'");
        System.out.println(" '7' Test  : SplitRight '" + bet.getWinningSplitRightBet(7) + "'");
        System.out.println("'20' Test  : SplitRight '" + bet.getWinningSplitRightBet(20) + "'");
        System.out.println("'36' Test  : SplitRight '" + bet.getWinningSplitRightBet(36) + "'");
        assertEquals("I expect the result to be: 8", expected, actual);
    }

    @Test
    public void getWinningStreetBetTest() {

        int expected = 3;
        int actual = bet.getWinningStreetBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Street '" + bet.getWinningStreetBet(0) + "'");
        System.out.println("'00' Test  : Street '" + bet.getWinningStreetBet(37) + "'");
        System.out.println("'28' Test  : Street '" + bet.getWinningStreetBet(28) + "'");
        System.out.println("'32' Test  : Street '" + bet.getWinningStreetBet(32) + "'");
        System.out.println("'36' Test  : Street '" + bet.getWinningStreetBet(36) + "'");
        assertEquals("I expect the result to be: 3", expected, actual);
    }

    @Test
    public void getWinningCornerUpLeftBetTest() {

        int expected = 4;
        int actual = bet.getWinningCornerUpLeftBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : UpLeft '" + bet.getWinningCornerUpLeftBet(0) + "'");
        System.out.println("'00' Test  : UpLeft '" + bet.getWinningCornerUpLeftBet(37) + "'");
        System.out.println(" '7' Test  : UpLeft '" + bet.getWinningCornerUpLeftBet(7) + "'");
        System.out.println("'20' Test  : UpLeft '" + bet.getWinningCornerUpLeftBet(20) + "'");
        System.out.println("'36' Test  : UpLeft '" + bet.getWinningCornerUpLeftBet(36) + "'");
        assertEquals("I expect the result to be: 4", expected, actual);
    }

    @Test
    public void getWinningCornerUpRightBetTest() {

        int expected = 5;
        int actual = bet.getWinningCornerUpRightBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : UpRight '" + bet.getWinningCornerUpRightBet(0) + "'");
        System.out.println("'00' Test  : UpRight '" + bet.getWinningCornerUpRightBet(37) + "'");
        System.out.println(" '7' Test  : UpRight '" + bet.getWinningCornerUpRightBet(7) + "'");
        System.out.println("'20' Test  : UpRight '" + bet.getWinningCornerUpRightBet(20) + "'");
        System.out.println("'36' Test  : UpRight '" + bet.getWinningCornerUpRightBet(36) + "'");
        assertEquals("I expect the result to be: 6", expected, actual);
    }

    @Test
    public void getWinningCornerDownRightBetTest() {

        int expected = 8;
        int actual = bet.getWinningCornerDownRightBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : DownRight '" + bet.getWinningCornerDownRightBet(0) + "'");
        System.out.println("'00' Test  : DownRight '" + bet.getWinningCornerDownRightBet(37) + "'");
        System.out.println(" '7' Test  : DownRight '" + bet.getWinningCornerDownRightBet(7) + "'");
        System.out.println("'20' Test  : DownRight '" + bet.getWinningCornerDownRightBet(20) + "'");
        System.out.println("'36' Test  : DownRight '" + bet.getWinningCornerDownRightBet(36) + "'");
        assertEquals("I expect the result to be: 8", expected, actual);
    }

    @Test
    public void getWinningCornerDownLeftBetTest() {

        int expected = 10;
        int actual = bet.getWinningCornerDownLeftBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : SplitRight '" + bet.getWinningCornerDownLeftBet(0) + "'");
        System.out.println("'00' Test  : SplitRight '" + bet.getWinningCornerDownLeftBet(37) + "'");
        System.out.println(" '7' Test  : SplitRight '" + bet.getWinningCornerDownLeftBet(7) + "'");
        System.out.println("'20' Test  : SplitRight '" + bet.getWinningCornerDownLeftBet(20) + "'");
        System.out.println("'36' Test  : SplitRight '" + bet.getWinningCornerDownLeftBet(36) + "'");
        assertEquals("I expect the result to be: 10", expected, actual);
    }

    @Test
    public void getWinningToplineBetTest() {

        int expected = 0;
        int actual = bet.getWinningToplineBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : SplitRight '" + bet.getWinningToplineBet(0) + "'");
        System.out.println("'00' Test  : SplitRight '" + bet.getWinningToplineBet(37) + "'");
        System.out.println(" '7' Test  : SplitRight '" + bet.getWinningToplineBet(7) + "'");
        System.out.println("'20' Test  : SplitRight '" + bet.getWinningToplineBet(20) + "'");
        System.out.println("'36' Test  : SplitRight '" + bet.getWinningToplineBet(36) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getWinningLineUpBetTest() {

        int expected = 2;
        int actual = bet.getWinningLineUpBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : LineUp '" + bet.getWinningLineUpBet(0) + "'");
        System.out.println("'00' Test  : LineUp '" + bet.getWinningLineUpBet(37) + "'");
        System.out.println(" '7' Test  : LineUp '" + bet.getWinningLineUpBet(7) + "'");
        System.out.println("'20' Test  : LineUp '" + bet.getWinningLineUpBet(20) + "'");
        System.out.println("'36' Test  : LineUp '" + bet.getWinningLineUpBet(36) + "'");
        assertEquals("I expect the result to be: 2", expected, actual);
    }

    @Test
    public void getWinningLineDownBetTest() {

        int expected = 3;
        int actual = bet.getWinningLineDownBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : LineDown '" + bet.getWinningLineDownBet(0) + "'");
        System.out.println("'00' Test  : LineDown '" + bet.getWinningLineDownBet(37) + "'");
        System.out.println(" '7' Test  : LineDown '" + bet.getWinningLineDownBet(7) + "'");
        System.out.println("'20' Test  : LineDown '" + bet.getWinningLineDownBet(20) + "'");
        System.out.println("'36' Test  : LineDown '" + bet.getWinningLineDownBet(36) + "'");
        assertEquals("I expect the result to be: 2", expected, actual);
    }

    @Test
    public void getWinningZeroDoubleZeroBetTest() {

        int expected = 0;
        int actual = bet.getWinningZeroDoubleZeroBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : ZeroDoubleZero '" + bet.getWinningZeroDoubleZeroBet(0) + "'");
        System.out.println("'00' Test  : ZeroDoubleZero '" + bet.getWinningZeroDoubleZeroBet(37) + "'");
        System.out.println(" '7' Test  : ZeroDoubleZero '" + bet.getWinningZeroDoubleZeroBet(7) + "'");
        System.out.println("'20' Test  : ZeroDoubleZero '" + bet.getWinningZeroDoubleZeroBet(20) + "'");
        System.out.println("'36' Test  : ZeroDoubleZero '" + bet.getWinningZeroDoubleZeroBet(36) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

    @Test
    public void getWinningCourtesyBetTest() {

        int expected = 0;
        int actual = bet.getWinningCourtesyBet(8);
        System.out.println("Expected : " + expected);
        System.out.println("Actual   : " + actual);
        System.out.println("\n '0' Test  : Courtesy '" + bet.getWinningCourtesyBet(0) + "'");
        System.out.println("'00' Test  : Courtesy '" + bet.getWinningCourtesyBet(37) + "'");
        System.out.println(" '7' Test  : Courtesy '" + bet.getWinningCourtesyBet(7) + "'");
        System.out.println("'20' Test  : Courtesy '" + bet.getWinningCourtesyBet(20) + "'");
        System.out.println("'36' Test  : Courtesy '" + bet.getWinningCourtesyBet(36) + "'");
        assertEquals("I expect the result to be: 0", expected, actual);
    }

}
