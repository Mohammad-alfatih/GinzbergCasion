package ginzberg.casino.Roulette;

/**
 * Created by rickjackson on 1/26/17.
 */
public class Chip {
    private Double balance;
    private Integer chips;
    private Integer minimumBet;

    Chip(double userBalance) {
        balance = userBalance;
        chips = 0;
    }

    void getChips(Integer requestedChips, Double balance, Integer minimum) {
        requestedChips /= 1;

        if (requestedChips >= minimum && requestedChips <= balance) {
            chips = requestedChips;
        }
    }

    void cashOutChips(Integer userChips, Double userBalance) {
        balance += userChips;
    }
}
