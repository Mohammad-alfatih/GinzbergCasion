package ginzberg.casino;

import ginzberg.casino.CardGames.CardDeck;
import org.junit.Test;

/**
 * Created by williammattern on 1/24/17.
 */
public class CardDeckTest {

    @Test
    public void seeCardDeckTest() {
        CardDeck cardDeck = new CardDeck();
        cardDeck.seeFullDeck();
    }
}
