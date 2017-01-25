package marwaspackage;

/**
 * Created by mkulima on 1/25/17.
 */
public abstract class Game {

    protected double userBalance = 0;


    abstract boolean walkAway(User thisUser);
    abstract boolean placeBet(User thisUser);
    abstract boolean winOrLose(User thisUser);

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
