package ginzberg.casino.Roulette;

/**
 * Created by rickjackson on 1/26/17.
 */
public class Chip {
    private Input in;
    private Output out;
    private Double balance;
    private Integer chips;
    private Integer minimumBet;

    Chip(double userBalance) {
        out = new Output();
        in = new Input();
        balance = userBalance;
        chips = 0;
    }

    public Integer requestChips(Double balance) {
        String response = in.userInput();
        Integer request = in.parseToInteger(response);

        if (request >= 1 && request <= balance) {
            return request;
        } else if (request == 0) {
            return 0;
        } else {
            return null;
        }
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