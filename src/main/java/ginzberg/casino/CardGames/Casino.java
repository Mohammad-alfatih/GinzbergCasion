package ginzberg.casino.CardGames;

import ginzberg.casino.CardGames.BlackJack.BlackJack;
import ginzberg.casino.CardGames.CasinoWars.Casino_Wars;
import ginzberg.casino.CardGames.Poker.PokerGameController;

/**
 * Created by ryangross on 1/25/17.
 */
public class Casino {


    public void playBJ(UserIO aUI) {

            BlackJack newBJ = new BlackJack();
            newBJ.playRound(aUI);
            aUI.setPlayAgain(aUI.anotherRound());
    }

    public void playWar(UserIO aUI) {
            Casino_Wars newCW = new Casino_Wars();
            newCW.playRound(aUI);
            aUI.setPlayAgain(aUI.anotherRound());
    }

    public void playPoker(UserIO aUI){
            PokerGameController pokerGameController = new PokerGameController();
            pokerGameController.playPoker();
            aUI.setPlayAgain(aUI.anotherRound());
    }


    public void startGame(UserIO aUI) {
        String selection = aUI.gameUserWantsToPlay();
        if (selection.equalsIgnoreCase("1")) {
            this.playBJ(aUI);
        } else if (selection.equalsIgnoreCase("2")){
            this.playPoker(aUI);
        } else if (selection.equalsIgnoreCase("3")) {
            this.playWar(aUI);
        }
    }


    public void play(UserIO anIO) {
        startGame(anIO);
    }


}
