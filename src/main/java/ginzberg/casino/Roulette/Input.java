package ginzberg.casino.Roulette;

import java.util.Scanner;

/**
 * Created by rickjackson on 1/26/17.
 */
public class Input {

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public Integer parseToInteger(String input) {
        return Integer.parseInt(input);
    }

}
