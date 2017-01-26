package ginzberg.casino.Roulette;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rickjackson on 1/25/17.
 */
public class Tracker {
    private List<Integer> winningNumbers;

    Tracker() {
        winningNumbers = new ArrayList<>();
    }

    void addWinningNumber(int winningNumber) {
        winningNumbers.add(winningNumber);
    }
}