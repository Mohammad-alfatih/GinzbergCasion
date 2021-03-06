package ginzberg.casino;

import java.util.Scanner;

/**
 * Created by ryangross on 1/25/17.
 */
public class UserIO {

    // Should these be static?
    protected static double userBalance = 100.0;
    public static String userName;
    protected Scanner userInput = new Scanner(System.in);
    protected String playAgain = "";

    public UserIO(double aBalance, String aName) {
        this.userBalance = aBalance;
        this.userName = aName;
    }

    public UserIO() {

    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserBalance(double newBalance) {
        this.userBalance = newBalance;
    }

    public double getUserBalance() {
        return userBalance;
    }

    public Scanner getUserInput() {
        return this.userInput;
    }

    public String getPlayAgain() {
        return this.playAgain;
    }

    public void getNameIO() {
        userName = userInput.next();
    }

    public void welcome() {
        System.out.println("Welcome the Ginzberger Casion!\n" +
                "What is your name?");
        this.getNameIO();
        System.out.println("Cool, " + this.userName + ". Here's $100. Good luck!");
    }
    // Takes in a String (User Input), and starts a game based on said String
    // Exception Handling...
    public String gameUserWantsToPlay() {
        System.out.println("What game do you want to play? Pick the number please!\n" +
                "1: Classic BlackJack\n" + "2: Poker\n" + "3: Casino War\n" + "4. Roulette\n");
        String answer = userInput.next();
        return answer;
    }

    public int askForBet() {
        String answer;
        // switch Statement

        System.out.println("How much would you like to bet?");

        answer = userInput.next();
        return Integer.parseInt(answer);
    }

    public void displayScore(int userScore, int dealerScore) {
        System.out.println("You: " + userScore + "Dealer: " + dealerScore);
    }

    public void displayTurn(String aString) {
        System.out.println(aString);
    }

    public String hitOrSurrender() {
        System.out.println("Hit, or surrender?");
        String answer = userInput.next();
        return answer;
    }

    public String anotherRound() {
        System.out.println("Play again?\n Y/N");
        String answer = userInput.next();
        return answer;
    }

    // setter


}
