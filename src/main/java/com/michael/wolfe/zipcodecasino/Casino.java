package com.michael.wolfe.zipcodecasino;

/**
 * Created by ryangross on 1/25/17.
 */
public class Casino {

    // test
    // mockito: optional

    public void playBJ(UserIO aUI) {

        while (aUI.playAgain == true) {
            BlackJack newBJ = new BlackJack();
            newBJ.playRound(aUI);
            aUI.anotherRound();
        }
    }


    public void startGame(UserIO aUI) {
        String selection = aUI.gameUserWantsToPlay();
        if (selection.equalsIgnoreCase("1")) {
            //BlackJack newBJ = new BlackJack();
            this.playBJ(aUI);
            // newBJ.playRound(aUI);
        }
    }


    public void play(UserIO anIO) {
        anIO.welcome();
        startGame(anIO);
    }


}
