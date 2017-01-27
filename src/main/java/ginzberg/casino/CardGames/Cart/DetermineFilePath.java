package ginzberg.casino.CardGames.Cart;

import java.nio.file.Paths;

/**
 * Created by mkulima on 1/27/17.
 */
public class DetermineFilePath {

    public String whereAmI(){
        return Paths.get(".").toAbsolutePath().normalize().toString();
    }

    public static void main(String[] args) {
        DetermineFilePath df = new DetermineFilePath();
        System.out.println(df.whereAmI());
    }
}
