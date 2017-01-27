package ginzberg.casino.CardGames;

import ginzberg.casino.CardGames.BlackJack.BlackJack;
import ginzberg.casino.CardGames.Cart.AsciiImages;
import ginzberg.casino.CardGames.CasinoWars.Casino_Wars;
import ginzberg.casino.CardGames.Poker.PokerGameController;

/**
 * Created by ryangross on 1/25/17.
 */
public class Casino {

    String selection;
    AsciiImages images = new AsciiImages();

    public void playBJ(UserIO aUI) {
            images.showLetsPlayBlackJack();
            BlackJack newBJ = new BlackJack();
            newBJ.playRound(aUI);
            aUI.setPlayAgain(aUI.anotherRound());
    }

    public void playWar(UserIO aUI) {
            images.showLetsPlayCasinoWar();
            Casino_Wars newCW = new Casino_Wars();
            newCW.playRound(aUI);
            aUI.setPlayAgain(aUI.anotherRound());
    }

    public void playPoker(UserIO aUI){
            images.showLetsPlayPoker();
            PokerGameController pokerGameController = new PokerGameController();
            pokerGameController.playPoker();
            aUI.setPlayAgain(aUI.anotherRound());
    }


    public void startGame(UserIO aUI) {
        selection = aUI.gameUserWantsToPlay();
        if (selection.equalsIgnoreCase("1")) {
            this.playBJ(aUI);
        } else if (selection.equalsIgnoreCase("2")){
            this.playPoker(aUI);
        } else if (selection.equalsIgnoreCase("3")) {
            this.playWar(aUI);
        }
    }

    public void startGame2(UserIO aUI) {

        if (this.selection.equalsIgnoreCase("1")) {
            this.playBJ(aUI);
        } else if (this.selection.equalsIgnoreCase("2")){
            this.playPoker(aUI);
        } else if (this.selection.equalsIgnoreCase("3")) {
            this.playWar(aUI);
        }
    }

    public void play(UserIO anIO, int playCounter) {
        if (playCounter == 0) {
            startGame(anIO);
        } else startGame2(anIO);

    }

}
