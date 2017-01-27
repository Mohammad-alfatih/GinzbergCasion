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

//    public Integer payoutWinningBets(int winPayout, Map<Integer, Integer> betMap, int betPayout, String betType) {
//        Set<Integer> set = createSet(betMap);
//        Iterator<Integer> itr = createIterator(set);
//
//        while (itr.hasNext()) {
//            Integer next = itr.next();
//            winTest = betMap.get(next);
//
//            if (next == winTest) {
//                int bet = betMap.get(next);
//                temp += payouts.get(betType) * bet;
//
//                if (bet != 0) {
//                    System.out.println("Paying out $" + bet + " on " + getBetType(betType) + " " + payout + "\n");
//                }
//                betMap.replace(next, 0);
//            }
//        }
//        return temp;
//    }

    public Integer payoutWinningBets(int winningNumber, Map<Integer, Integer> placeBetMap, Map<Integer, Integer> winBetMap, String betType) {
        Set<Integer> set = createSet(placeBetMap);
        Iterator<Integer> itr = createIterator(set);
        int winPayout = 0;
        int testPayout = 0;
        int payout = 0;

        while (itr.hasNext()) {
            Integer next = itr.next();
            winPayout = winBetMap.get(winningNumber);
            testPayout = winBetMap.get(next);

            if (winPayout == testPayout) {
                int bet = placeBetMap.get(next);
                payout += payouts.get(betType) * bet;

                if (bet != 0) {
                    System.out.println("Paying out $");
                }
                placeBetMap.replace(next, 0);
            }
        }
        return payout;
    }

    public Integer payoutWinningHalfBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.highLow.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println("next: " + next);
            int winPayout = super.getWinningHalfBet(winningNumber);
            System.out.println("winPayout: " + winPayout);
            int compPayout = super.getWinningHalfBet(next);
            System.out.println("compPayout: " + compPayout);

            if (winPayout == compPayout) {
                int bet = super.highLow.get(next);
                System.out.println("bet: " + bet);
                int thisPOamount = payouts.get(betType);
                System.out.println("thisPOamount: " + thisPOamount);
                int thisPayout = (payouts.get(betType) * bet);
                System.out.println("thisPayout: " + thisPayout);
                payout += thisPayout;
                System.out.println("payout: " + payout);
                super.highLow.replace(next, 0);
                System.out.println("updated bet: " + super.highLow.get(next));
            }
        }
        System.out.println(payout);
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
