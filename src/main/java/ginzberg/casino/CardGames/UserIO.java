package ginzberg.casino.CardGames;

import ginzberg.casino.CardGames.Cart.AsciiImages;

import java.util.Scanner;

/**
 * Created by ryangross on 1/25/17.
 */
public class UserIO {

    protected static double userBalance = 100.0;
    public static String userName;
    public Scanner userInput = new Scanner(System.in);
    protected boolean playAgain = true;
    AsciiImages images = new AsciiImages();

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

    public void getNameIO() {
        userName = userInput.next();
    }

    public void firstWelcome(){
        images.showCasino();
        System.out.println("Welcome the Ginzberger Casino!\n" +
                "What is your name?");
        this.getNameIO();
        System.out.println("Cool, " + this.userName + ". Here's $100. Good luck!");
    }

    public void additionalWelcome() {
        images.showJoker();
        System.out.println("Your current balance is " + getUserBalance());
        System.out.println("What game would you like to play next?");
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

        System.out.println("How much would you like to bet?");

        answer = userInput.next();
        userBalance -= Integer.parseInt(answer);
        return Integer.parseInt(answer);
    }


    public void displayTurn(String aString) {
        System.out.println(aString);
    }


    public String anotherRound() {
        System.out.println("Play again?\n Y/N");
        String answer = userInput.next();
        return answer;
    }

    public String displayUserBalance() {
        String answer = "Your current balance is $" + userBalance;
        System.out.println(answer);
        return answer;
    }

    public void setPlayAgain(String playAgain) {
        if (playAgain.equalsIgnoreCase("N")){
            this.playAgain = false;
        }
    }
}