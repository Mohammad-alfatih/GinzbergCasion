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

    public void clearLosingHighLowBets(int winningNumber) {
        Set<Integer> set = highLow.keySet();
        Iterator<Integer> itr = set.iterator();
        int win = Bet.getWinningHalfBet(winningNumber);

        while (itr.hasNext()) {
            Integer next = itr.next();

            if (next != win) {
                super.highLow.put(next, 0);
            }
        }
    }

//    public void clearLosingBets(int winningNumber, Map map) {
//        Set<Integer> set = createSet(map);
//        Iterator<Integer> itr = createIterator(set);
//        int win = Bet.getWinningHalfBet(winningNumber);
//
//        while (itr.hasNext()) {
//            Integer next = itr.next();
//
//            if (next != win) {
//                map.put(next, 0);
//            }
//        }
//    }

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

    public Integer payoutHalfBet(int winningNumber, String betType) {
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

            if (winPayout == next) {
                int bet = super.getHighLow(next);
                System.out.println("bet: " + bet);
                int thisPOamount = payouts.get(betType);
                System.out.println("thisPOamount: " + thisPOamount);
                int thisPayout = (payouts.get(betType) * bet);
                System.out.println("thisPayout: " + thisPayout);
                payout += (bet + thisPayout);
                System.out.println("payout: " + payout);
                super.highLow.put(next, 0);
                System.out.println("updated bet: " + super.highLow.get(next));
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutEvenOddBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.evenOdd.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningEvenOddBet(winningNumber);
            int compPayout = super.getWinningEvenOddBet(next);

            if (winPayout == next) {
                int bet = super.getEvenOdd(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.evenOdd.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutRedBlackBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.redBlack.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningRedBlackBet(winningNumber);
            int compPayout = super.getWinningRedBlackBet(next);

            if (winPayout == next) {
                int bet = super.getRedBlack(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.redBlack.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutDozenBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.dozen.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningDozenBet(winningNumber);
            int compPayout = super.getWinningDozenBet(next);

            if (winPayout == next) {
                int bet = super.getDozen(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.dozen.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutColumnBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.column.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningColumnBet(winningNumber);
            int compPayout = super.getWinningColumnBet(next);

            if (winPayout == next) {
                int bet = super.getColumn(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.column.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutLineBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.line.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayoutU = super.getWinningLineUpBet(winningNumber);
            int winPayoutD = super.getWinningLineDownBet(winningNumber);
            int compPayoutD = super.getWinningLineUpBet(next);

            if (winPayoutU == next || winPayoutD == next) {
                int bet = super.getColumn(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.column.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutToplineBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.topline.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningToplineBet(winningNumber);
            int compPayout = super.getWinningToplineBet(next);

            if (winPayout == next) {
                int bet = super.getTopline(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.topline.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutCornerBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.corner.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayoutUL = super.getWinningCornerUpLeftBet(winningNumber);
            int winPayoutUR = super.getWinningCornerUpRightBet(winningNumber);
            int winPayoutDR = super.getWinningCornerDownRightBet(winningNumber);
            int winPayoutDL = super.getWinningCornerDownRightBet(winningNumber);
            int compPayoutD = super.getWinningLineUpBet(next);

            if (winPayoutUL == next || winPayoutUR == next || winPayoutDR == next || winPayoutDL == next) {
                int bet = super.getCorner(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.corner.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutStreetBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.street.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningStreetBet(winningNumber);
            int compPayout = super.getWinningStreetBet(next);

            if (winPayout == next) {
                int bet = super.getStreet(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.street.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutCourtesyBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.courtesy.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningCourtesyBet(winningNumber);
            int compPayout = super.getWinningCourtesyBet(next);

            if (winPayout == next) {
                int bet = super.getCourtesy(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.courtesy.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutSplitDownBet(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.splitDown.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayoutD = super.getWinningSplitDownBet(winningNumber);
            int winPayoutU = super.getWinningSplitUpBet(winningNumber);
            int compPayoutD = super.getWinningLineUpBet(next);

            if (winPayoutU == next || winPayoutD == next) {
                int bet = super.getSplitDown(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.splitDown.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutSplitRight(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.splitRight.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayoutD = super.getWinningSplitLeftBet(winningNumber);
            int winPayoutU = super.getWinningSplitRightBet(winningNumber);
            int compPayoutD = super.getWinningLineUpBet(next);

            if (winPayoutU == next || winPayoutD == next) {
                int bet = super.getSplitDown(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.splitRight.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutZeroDoubleZero(int winningNumber, String betType) {
        int payout = 0;
        Set<Integer> set = super.zeroDoubleZero.keySet();
        Iterator<Integer> itr = set.iterator();

        while (itr.hasNext()) {
            Integer next = itr.next();
            int winPayout = super.getWinningZeroDoubleZeroBet(winningNumber);
            int compPayout = super.getWinningZeroDoubleZeroBet(next);

            if (winPayout == next) {
                int bet = super.getZeroDoubleZero(next);
                int thisPOamount = payouts.get(betType);
                int thisPayout = (payouts.get(betType) * bet);
                payout += (bet + thisPayout);
                super.zeroDoubleZero.put(next, 0);
            }
        }
        System.out.println(payout);
        return payout;
    }

    public Integer payoutStraightUp(int winningNumber, String betType) {
        int payout = 0;
        Set<String> set = super.straightUp.keySet();
        Iterator<String> itr = set.iterator();

        while (itr.hasNext()) {
            String next = itr.next();
            System.out.println("next: " + next);
            String winPayout = Integer.toString(winningNumber);
            System.out.println("winPayout: " + winPayout);
            String compPayout = next;
            System.out.println("compPayout: " + compPayout);

            if (winPayout == next) {
                int bet = super.getStraightUp(next);
                System.out.println("bet: " + bet);
                int thisPOamount = payouts.get(betType);
                System.out.println("thisPOamount: " + thisPOamount);
                int thisPayout = (payouts.get(betType) * bet);
                System.out.println("thisPayout: " + thisPayout);
                payout += (bet + thisPayout);
                System.out.println("payout: " + payout);
                super.straightUp.put(next, 0);
                System.out.println("updated bet: " + super.straightUp.get(next));
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
