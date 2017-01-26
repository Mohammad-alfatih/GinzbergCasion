package ginzberg.casino.Roulette;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 1/25/17.
 */
public class Table {
    private Map<Integer, String> numbersByInteger;
    private Map<String, Integer> numbersByString;

    Table() {
        numbersByInteger = new HashMap<>();
        numbersByString = new HashMap<>();
        constructNumbers();
    }

    private void constructNumbers() {

        for (int i = 0; i < 38; i++) {
            if (i == 37) {
                numbersByInteger.put(i, "00");
                numbersByString.put("00", i);
            } else {
                numbersByInteger.put(i, Integer.toString(i));
                numbersByString.put(Integer.toString(i), i);
            }
        }
    }

    String getNumber(Integer key) {
        return numbersByInteger.get(key);
    }

    Integer getNumber(String key) {
        return numbersByString.get(key);
    }
}