package com.michael.wolfe.zipcodecasino;

/**
 * Created by rickjackson on 1/25/17.
 */
public class Main {

    public static void main(String[] args) {
        PlaceBet placeBet = new PlaceBet();
        Table table = new Table();
        System.out.println(placeBet.getBetType('N'));
        System.out.println(table.getNumber(38));
    }
}