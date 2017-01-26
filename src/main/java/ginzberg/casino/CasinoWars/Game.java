package ginzberg.casino;

<<<<<<< HEAD
public abstract class Game {
    protected double userBalance;
    protected double currentBet;

    // Setter
    protected double adjustBalance(double aNumber) {
        return this.userBalance - aNumber;
    }

    public void setCurrentBet(double anAmt) {
        this.currentBet = anAmt;
        this.adjustBalance(anAmt);
    }

    public void walkAway() {

    }

    public int calculateScore() {
        return 0;
    }

=======
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


>>>>>>> marwas_testmerge
}
