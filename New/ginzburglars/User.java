package marwamilton.ginzburglars;

/**
 * Created by root on 1/25/17.
 */
public class User {
    private String name;
    private double balance;

    User(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }


}
