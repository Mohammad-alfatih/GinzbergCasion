package ginzberg.casino;

import java.util.Scanner;

/**
 * Created by mkulima on 1/25/17.
 */
public class User {
    private String name;
    private double balance;

    User(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    protected String getName() {
        return name;
    }

    protected double getBalance() {
        return this.balance;
    }

    protected double changeUserBalance(double changeBy) {
        this.balance += (isUserBalancePositive()) ?  changeBy : 0;
        return this.balance;
    }


    private boolean isUserBalancePositive(){
        return this.balance>=0 ? true : false;
    }

    public String toString(){
        return "Name: " + this.name + "\n Bal: " + this.balance;
    }

    public double getUserBet(){
        System.out.println("Your balance is: " + this.balance + "\n How Much do you want to bet?");
        Scanner scan = new Scanner(System.in);
        double betAmount = scan.nextDouble();
        changeUserBalance(-betAmount);
        return betAmount;
    }

    public String getUserChoice(){
        System.out.println("Play or Quit?");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


}
