package ginzberg.casino.Roulette;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 1/25/17.
 */
public class Roulette {
    private Map<Character, Integer> payout;
    private int minimumBet;
    private int insideBetTotal;
    private int outsideBetTotal;

    Roulette(double userBalance) {
        payout = new HashMap<>();
        minimumBet = 10;
        insideBetTotal = 0;
        outsideBetTotal = 0;
        constructPayout();
    }

    private void constructPayout() {
        payout.put('A', 35);
        payout.put('B', 2);
        payout.put('C', 2);
        payout.put('D', 1);
        payout.put('E', 1);
        payout.put('F', 1);
        payout.put('G', 17);
        payout.put('H', 11);
        payout.put('I', 8);
        payout.put('J', 6);
        payout.put('K', 5);
        payout.put('L', 17);
        payout.put('M', 17);
    }

    Integer getPayout(Character key) {
        return payout.get(key);
    }

    private void changeMinimumBet() {
        minimumBet = 10;
    }
}
