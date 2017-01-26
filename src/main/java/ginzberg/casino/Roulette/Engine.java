package ginzberg.casino.Roulette;

import ginzberg.casino.Games.UserIO;

/**
 * Created by rickjackson on 1/25/17.
 */
public class Engine {
    private Input in;
    private Output out;
    private UserIO userIO;
    private Double balance;
    private Chip chips;
    private Integer stack;
    private Help help;
    private String betType;

    Engine() {
        in = new Input();
        out = new Output();
        userIO = new UserIO();
        balance = userIO.getUserBalance();
        chips = new Chip(balance);
        stack = 0;
        help = new Help();
        betType = "";

        out.casinoOutput("Welcome to Roulette. How many chips would you like?");
        stack = chips.requestChips(balance);

        while (stack == null) {
            out.casinoOutput("I'm sorry, you do not have enough for that amount.");
            out.casinoOutput("Would you like another amount? (Enter '0' to quit");
            stack = chips.requestChips(balance);
        }

        out.casinoOutput("At anytime enter 'HELP' for the Help Menu");
        help.showTable();
        out.casinoOutput("Place your bets...");
        out.shortOutput("Enter your bet type: ");
    }

    public void gameplay() {
        out.casinoOutput("Welcome to Roulette. How many chips would you like?");
        stack = chips.requestChips(balance);

        while (stack == null) {
            out.casinoOutput("I'm sorry, you do not have enough for that amount.");
            out.casinoOutput("Would you like another amount? (Enter '0' to quit");
            stack = chips.requestChips(balance);
        }

        out.casinoOutput("At anytime enter 'HELP' for the Help Menu");
        help.showTable();
        out.casinoOutput("Place your bets...");
        out.shortOutput("Enter your bet type: ");
    }
}
