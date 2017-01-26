package com.michael.wolfe.zipcodecasino;

/**
 * Created by mkulima on 1/25/17.
 */
public abstract class Game {

    protected double userBalance = 0;


    public boolean walkAway(User thisUser){
        return false;
    }
    public boolean placeBet(User thisUser){
        return false;
    }
    public  boolean winOrLose(User thisUser){
        return false;
    }

    public double getUserBalance(User thisUser) {
        this.userBalance = thisUser.getBalance();
        return thisUser.getBalance();
    }

    public double adjustUserBalance(double adjustByAmount, User thisUser) {
        thisUser.changeUserBalance(adjustByAmount);
        this.userBalance = thisUser.getBalance();
        return this.userBalance;
    }


}