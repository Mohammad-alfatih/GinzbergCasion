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
        return Integer.valueOf(input);
    }

    public boolean helpOrQuit(String input) {
        return input.equals("HELP") || input.equals("BACK") || input.equals("QUIT");
    }

    public String validateNumber(String input, String holder) {
        int i = Integer.valueOf(input);

        if (input == "00" || (i >= 0 || i <= 36)) {
            return "NUMBER";
        } else {
            return "NAN";
        }
    }

}
