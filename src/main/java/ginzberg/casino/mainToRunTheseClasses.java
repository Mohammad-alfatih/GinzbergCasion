package ginzberg.casino;

/**
 * Created by mkulima on 1/25/17.
 */
public class mainToRunTheseClasses {

     public static void main(String[] args) {
        Casino_Wars casinoWars = new Casino_Wars();
        User wooMan = new User("Woo Man", 1000);
        double userBet = 0;

         System.out.println("Woo Man's info");
         //wooMan.changeUserBalance(-2500);
         System.out.println(wooMan.toString());
         System.out.println("\n ");
         userBet = wooMan.getUserBet();

        //System.out.println(casinoWars.dealerDeck.toString());
        System.out.println("\n player hand:");
        Card userHand = casinoWars.dealCard(casinoWars.dealerDeck,4);
        System.out.println(userHand.toString());

        System.out.println("\n dealer hand:");
        Card dealerHand = casinoWars.dealCard(casinoWars.dealerDeck,4);
        System.out.println(dealerHand.toString());

        System.out.println("");
         if(casinoWars.isUserCardGreaterThanDealerCard(userHand, dealerHand)){
             wooMan.changeUserBalance(userBet*2);
             userBet = 0;
             System.out.println("YOU WIN!");
             System.out.println("Your new balance is: " + wooMan.getBalance());
         } else {
             userBet = 0;
             System.out.println("YOU LOSE!");
             System.out.println("Your new balance is: " + wooMan.getBalance());
         }
        //System.out.println(casinoWars.dealerDeck.toString());

    }  // end main method number 1

    /* public static void main(String[] args) {
        PlayCasinoWars playCasinoWars = new PlayCasinoWars();
        playCasinoWars.userBet = playCasinoWars.wooMan.getUserBet();
        //playCasinoWars.wooMan.changeUserBalance(playCasinoWars.userBet);
        System.out.println("Your new balance: " + playCasinoWars.wooMan.getBalance());

        if(playCasinoWars.isUserCardGreaterThanDealerCard()){
            playCasinoWars.wooMan.changeUserBalance(playCasinoWars.userBet*2);
            playCasinoWars.userBet = 0;
            System.out.println("YOU WIN!");
            System.out.println("Your new balance is: " + playCasinoWars.wooMan.getBalance());
        } else {
            playCasinoWars.userBet = 0;
            System.out.println("YOU LOSE!");
            System.out.println("Your new balance is: " + playCasinoWars.wooMan.getBalance());
        }

    } */

}
