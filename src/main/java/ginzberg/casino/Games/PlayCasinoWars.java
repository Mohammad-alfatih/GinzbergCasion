package ginzberg.casino.Games;

/**
 * Created by mkulima on 1/25/17.
 */
public class PlayCasinoWars {
    Casino_Wars casinoWars = new Casino_Wars();
    User wooMan = new User("Woo Man", 1000);
    double userBet = 0;


    /* public boolean isUserCardGreaterThanDealerCard(){
        casinoWars.userCard = casinoWars.dealCard(casinoWars.userDeck, 3);
        casinoWars.dealerCard = casinoWars.dealCard(casinoWars.dealerDeck, 3);
        return getCardValue(casinoWars.userCard)>getCardValue(casinoWars.dealerCard);
    } */

    public boolean isUserCardGreaterThanDealerCard(Card userCard, Card dealerCard){
        return userCard.getRank().ordinal() > dealerCard.getRank().ordinal();
    }

    /* public int getCardValue(Card card){
        HashMap<String, Integer> cardOrder = new HashMap<String, Integer>(13);
        cardOrder.put("ONE",1);
        cardOrder.put("TWO",2);
        cardOrder.put("THREE",3);
        cardOrder.put("FOUR",4);
        cardOrder.put("FIVE",5);
        cardOrder.put("SIX",6);
        cardOrder.put("SEVEN",7);
        cardOrder.put("EIGHT",8);
        cardOrder.put("NINE",9);
        cardOrder.put("TEN",10);
        cardOrder.put("JACK",11);
        cardOrder.put("QUEEN",12);
        cardOrder.put("KING",13);
        cardOrder.put("ACE",14);

        return cardOrder.get(card.getRank().ordinal());
    } */


}
