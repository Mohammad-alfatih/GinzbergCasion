package ginzberg.casino;

/**
 * Created by ryangross on 1/25/17.
 */
public class Casino {


    public void startGame(UserIO aUI) {
        String selection = aUI.gameUserWantsToPlay();
        if(selection.equalsIgnoreCase("1")) {
            BlackJack newBJ = new BlackJack();
            //   newBJ.playBlackJack(aUI);
            newBJ.playRound(aUI);
        }
    }


    public void play(UserIO anIO) {
        anIO.welcome();
        startGame(anIO);
    }


}
