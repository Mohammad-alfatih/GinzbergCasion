
package ginzberg.casino.CardGames.Poker;

/**
 * Created by anthonypajerowski on 1/25/17.
 */
public class PokerInputParser {
    int[] results;
    public int[] parseUserInput(String input) {
            if (input.equals("none")) {
                results = new int[0];
                return results;
            }
            String[] items = input.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
            results = new int[items.length];
            for (int i = 0; i < items.length; i++) {
                try {
                    results[i] = Integer.parseInt(items[i]);
                } catch (NumberFormatException nfe) {
                    System.out.println(nfe);
                }
            }

        return results;
    }
}