package ginzberg.casino.CardGames;

import java.util.Scanner;

/**
 * Created by mkulima on 1/25/17.
 */
public class User {
    private String name;
    private double balance;

    public User(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    protected String getName() {
        return name;
    }

    public double getBalance() {
        return this.balance;
    }

    /*
    public double changeUserBalance(double changeBy) {
        this.balance += (isUserBalancePositive()) ?  changeBy : 0;
        return this.balance;
    }
    */

    /*
    private boolean isUserBalancePositive(){
        return this.balance>=0 ? true : false;
    }
    */

    public String toString(){
        return "Name: " + this.name + "\n Bal: " + this.balance;
    }

    public double getUserBet(){
        System.out.println("Your balance is: " + this.balance + "\n How Much do you want to bet?");
        Scanner scan = new Scanner(System.in);
        double betAmount = scan.nextDouble();
      //  changeUserBalance(-betAmount);
        return betAmount;
    }

    public String getUserChoice(){
        System.out.println("Play or Quit? \n Enter 'Y' to play, anything else to quit." );
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


}
