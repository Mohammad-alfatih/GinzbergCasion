package ginzberg.casino.Roulette;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by rickjackson on 1/26/17.
 */
public class Payout extends PlaceBet {
    private Map<String, Integer> payouts = new HashMap<>();
    private Integer payout;

    Payout() {
        payout = 0;
        constructPayouts();
    }

    public Integer getPayout() {
        return payout;
    }

    public Integer setPayout() {
        return payout;
    }

    public Integer addToPayout(Integer total) {
        return payout + total;
    }

    Integer getPayouts(int i) {
        return payouts.get(i);
    }

    void constructPayouts() {
        payouts.put("A", 35);
        payouts.put("B", 2);
        payouts.put("C", 2);
        payouts.put("D", 1);
        payouts.put("E", 1);
        payouts.put("F", 1);
        payouts.put("GR", 17);
        payouts.put("GD", 17);
        payouts.put("H", 11);
        payouts.put("I", 8);
        payouts.put("J", 6);
        payouts.put("K", 5);
        payouts.put("L", 17);
        payouts.put("M", 17);
    }

    private Set<Integer> createSet(Map map) {
        return map.keySet();
    }

    private Iterator<Integer> createIterator(Set set) {
        return set.iterator();
    }

    public void clearAllLosingBets(int winningNumber) {
    }

    public void clearLosingBets(int winningNumber, Map map) {
        Set<Integer> set = createSet(map);
        Iterator<Integer> itr = createIterator(set);

        while (itr.hasNext()) {
            Integer next = itr.next();

            if (!next.equals(winningNumber)) {
                map.replace(next, 0);
            }
        }
    }

    public Integer payoutWinningBets(int winningNumber, Map<Integer, Integer> map, int payout, String betType) {
        Set<Integer> set = createSet(map);
        Iterator<Integer> itr = createIterator(set);

        while (itr.hasNext()) {
            Integer next = itr.next();

            if (next.equals(winningNumber)) {
                int bet = map.get(next);
                bet *= payouts.get(betType);

                if (bet != 0) {
                    System.out.println("Paying out $" + bet + " on " + getBetType(betType) + " " + payout + "\n");
                }
                map.replace(next, 0);
            }
        }
        return payout;
    }

    public Integer payoutWinningStraightUp(int winningNumber) {
        Set<String> s = super.straightUp.keySet();
        Iterator<String> itr = s.iterator();

        while (itr.hasNext()) {
            String next = itr.next();

            if (next.equals(Integer.toString(winningNumber))) {
                int bet = super.straightUp.get(next);
                bet *= 35;

                if (bet != 0) {
                    System.out.println("Payout out $" + bet + " on Straight Up " + winningNumber + "\n");
                }
                super.straightUp.replace(next, 0);
            }
        }
        return payout;
    }

    public void clearLosingStraightUp(int winningNumber) {
        Set<String> s = super.straightUp.keySet();
        Iterator<String> itr = s.iterator();

        while (itr.hasNext()) {
            String next = itr.next();

            if (!next.equals(Integer.toString(winningNumber))) {
                super.straightUp.replace(next, 0);
            }
        }
    }
}
