package ginzberg.casino.Roulette;

import ginzberg.casino.CardGames.UserIO;

/**
 * Created by rickjackson on 1/26/17.
 */
public class Chip {
    private Input in;
    private Output out;
    private Double balance;
    private Integer chips;
    private Integer minimumBet;

    Chip() {
        out = new Output();
        in = new Input();
        balance = 0.00;
        chips = 0;
    }

    public void getUserBalance(UserIO uio) {
        balance = uio.getUserBalance();
    }

    public void setUserBalance(UserIO uio) {

    }

    public Integer requestChips(Double balance) {
        String response = in.userInput();
        Integer request = in.parseToInteger(response);

        if (request >= 1 && request <= balance) {
            return request;
        } else if (request > balance) {
            return 0;
        } else if (response == "QUIT"){
            return -1;
        } else {
            return -2;
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
