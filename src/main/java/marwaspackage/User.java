package marwaspackage;

import org.jetbrains.annotations.Contract;

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
        this.balance += (isUserBalancePositive()) ?  changeBy : this.balance;
        return this.balance;
    }

    @Contract(pure = true)
    private boolean isUserBalancePositive(){
        return this.balance>=0? true : false;
    }


}
