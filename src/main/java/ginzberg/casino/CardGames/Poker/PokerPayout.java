package ginzberg.casino.CardGames.Poker;

import java.util.HashMap;

/**
 * Created by anthonypajerowski on 1/25/17.
 */
class PokerPayout {

    private int betSize;

    HashMap<String, Integer> gamePayoutOdds = new HashMap<>();

{
    gamePayoutOdds.put("lostHand", 0);
    gamePayoutOdds.put("jacksOrBetter", 1);
    gamePayoutOdds.put("twoPair", 2);
    gamePayoutOdds.put("threeOfAKind", 3);
    gamePayoutOdds.put("straight", 4);
    gamePayoutOdds.put("flush", 5);
    gamePayoutOdds.put("fullHouse", 9);
    gamePayoutOdds.put("fourOfAKind", 25);
    gamePayoutOdds.put("straightFlush", 50);
    gamePayoutOdds.put("royalFlush", 800);
}

    protected void setBetSize(int bet) {
        betSize = bet;
    }

    protected int getBetSize(){
        return betSize;
    }

    protected double payWinnings(String outcome) {
        return getBetSize() * gamePayoutOdds.get(outcome);
    }
}