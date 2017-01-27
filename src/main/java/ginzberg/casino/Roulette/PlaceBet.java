package ginzberg.casino.Roulette;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rickjackson on 1/26/17.
 */
public class PlaceBet extends Bet {
    private Input in;
    private Output out;
    Map<String, Integer> straightUp;
    Map<Integer, Integer> column;
    Map<Integer, Integer> dozen;
    Map<Integer, Integer> redBlack;
    Map<Integer, Integer> highLow;
    Map<Integer, Integer> evenOdd;
    Map<Integer, Integer> splitDown;
    Map<Integer, Integer> splitRight;
    Map<Integer, Integer> street;
    Map<Integer, Integer> corner;
    Map<Integer, Integer> topline;
    Map<Integer, Integer> line;
    Map<Integer, Integer> zeroDoubleZero;
    Map<Integer, Integer> courtesy;

    PlaceBet() {
        in = new Input();
        out = new Output();
        straightUp = new HashMap<>();
        column = new HashMap<>();
        dozen = new HashMap<>();
        redBlack = new HashMap<>();
        highLow = new HashMap<>();
        evenOdd = new HashMap<>();
        splitDown = new HashMap<>();
        splitRight = new HashMap<>();
        street = new HashMap<>();
        corner = new HashMap<>();
        topline = new HashMap<>();
        line = new HashMap<>();
        zeroDoubleZero = new HashMap<>();
        courtesy = new HashMap<>();
        constructStraightUp();
        constructColumn();
        constructDozen();
        constructRedBlack();
        constructHighLow();
        constructEvenOdd();
        constructSplitDown();
        constructSplitRight();
        constructStreet();
        constructCorner();
        constructTopline();
        constructLine();
        constructZeroDoubleZero();
        constructCourtesy();
    }

    public String chooseBetType(String input) {
        return getBetType(input);
    }

    public Integer getStraightUp(String key) {
        return straightUp.get(key);
    }

    public void setStraightUp(String key, Integer money) {
        straightUp.replace(key, money);
    }

    public Integer getColumn(Integer key) {
        return column.get(key);
    }

    public void setColumn(Integer key, Integer money) {
        column.replace(key, money);
    }

    public Integer getDozen(Integer key) {
        return dozen.get(key);
    }

    public void setDozen(Integer key, Integer money) {
        dozen.replace(key, money);
    }

    public Integer getRedBlack(Integer key) {
        return redBlack.get(key);
    }

    public void setRedBlack(Integer key, Integer money) {
        redBlack.replace(key, money);
    }

    public Integer getHighLow(Integer key) {
        return highLow.get(key);
    }

    public void setHighLow(Integer key, Integer money) {
        highLow.put(key, money);
    }

    public Integer getEvenOdd(Integer key) {
        return evenOdd.get(key);
    }

    public void setEvenOdd(Integer key, Integer money) {
        evenOdd.replace(key, money);
    }

    public Integer getSplitDown(Integer key) {
        return splitDown.get(key);
    }

    public void setSplitDown(Integer key, Integer money) {
        splitDown.replace(key, money);
    }

    public Integer getSplitRight(Integer key) {
        return splitRight.get(key);
    }

    public void setSplitRight(Integer key, Integer money) {
        splitRight.replace(key, money);
    }

    public Integer getStreet(Integer key) {
        return street.get(key);
    }

    public void setStreet(Integer key, Integer money) {
        street.replace(key, money);
    }

    public Integer getCorner(Integer key) {
        return corner.get(key);
    }

    public void setCorner(Integer key, Integer money) {
        corner.replace(key, money);
    }

    public Integer getTopline(Integer key) {
        return topline.get(key);
    }

    public void setTopline(Integer key, Integer money) {
        topline.replace(key, money);
    }

    public Integer getLine(Integer key) {
        return line.get(key);
    }

    public void setLine(Integer key, Integer money) {
        line.replace(key, money);
    }

    public Integer getZeroDoubleZero(Integer key) {
        return zeroDoubleZero.get(key);
    }

    public void setZeroDoubleZero(Integer key, Integer money) {
        zeroDoubleZero.replace(key, money);
    }

    public Integer getCourtesy(Integer key) {
        return courtesy.get(key);
    }

    public void setCourtesy(Integer key, Integer money) {
        courtesy.replace(key, money);
    }

    private void constructStraightUp() {
        for (int i = 0; i < 38; i++) {
            if (i == 37) {
                straightUp.put("00", 0);
            } else {
                straightUp.put(Integer.toString(i), 0);
            }
        }
    }

    private void constructColumn() {
        column.put(1, 0);
        column.put(2, 0);
        column.put(3, 0);
    }

    private void constructDozen() {
        dozen.put(1, 0);
        dozen.put(2, 0);
    }

    private void constructRedBlack() {
        redBlack.put(1, 0);
        redBlack.put(2, 0);
    }

    private void constructHighLow() {
        highLow.put(1, 0);
        highLow.put(2, 0);
    }

    private void constructEvenOdd() {
        evenOdd.put(1, 0);
        evenOdd.put(2, 0);
    }

    private void constructSplitDown() {
        for (int i = 1; i < 34; i++) {
            splitDown.put(i, 0);
        }
    }

    private void constructSplitRight() {
        for (int i = 1; i < 37; i++) {
            if (i % 3 != 0) {
                splitRight.put(i, 0);
            }
        }
    }

    private void constructStreet() {
        for (int i = 1; i < 13; i++) {
            street.put(i, 0);
        }
    }

    private void constructCorner() {
        for (int i = 1; i < 34; i++) {
            corner.put(i, 0);
        }
    }

    private void constructTopline() {
        topline.put(1, 0);
    }

    private void constructLine() {
        for (int i = 1; i < 13; i++) {
            line.put(i, 0);
        }
    }

    private void constructZeroDoubleZero() {
        zeroDoubleZero.put(1, 0);
    }

    private void constructCourtesy() {
        courtesy.put(1, 0);
    }
}
