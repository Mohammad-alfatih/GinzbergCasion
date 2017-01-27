package ginzberg.casino.CardGames.Poker;

import ginzberg.casino.CardGames.Card;
import ginzberg.casino.CardGames.Suits;

import java.util.*;

/**
 * Created by williammattern on 1/25/17.
 */
public class PokerChecker {

    public boolean flushChecker(HashMap<Integer, Card> hand){
        Suits[] suitArray = new Suits[5];
        for (int i = 0; i < 5; i++){
            suitArray[i] = hand.get(i).getSuit();
        }

        for (int i = 1; i < suitArray.length ; i++) {
            if (suitArray[i] != suitArray[0]) {
                return false;
            }
        }
        return true;
    }

    public boolean straightChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        Arrays.sort(rankOrdinalArray);
        //The ordinal sequence of the Ranks enum lists Ace as the lowest value.
        //This first if statement handles generic straights or the case of a ace high flush.
        if (rankOrdinalArray[0] == (rankOrdinalArray[1] - 1 )|| rankOrdinalArray[0] == (rankOrdinalArray[1] - 9)){
            if(rankOrdinalArray[1] == rankOrdinalArray[2] - 1){
                if(rankOrdinalArray[2] == rankOrdinalArray[3] - 1){
                    if(rankOrdinalArray[3] == rankOrdinalArray[4] -1){
                        return true;
                    } else {return false;}
                } else { return false;}
            } else { return false; }
        } else { return false; }
    }

    public boolean royalChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        for (int i: rankOrdinalArray){
            if (i > 0 && i < 9){
                return false;
            }
        } return true;
    }

    public int[] convertToRankOrdinalArray(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = new int[5];
        for (int i = 0; i < 5; i++){
            rankOrdinalArray[i] = hand.get(i).getRank().ordinal();
        }
        Arrays.sort(rankOrdinalArray);
        return rankOrdinalArray;
    }

    public boolean fourOfAKindChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        Arrays.sort(rankOrdinalArray);
        int countFromLeft = countOfMatchesFromLeft(rankOrdinalArray);
        int countFromRight = countOfMatchesFromRight(rankOrdinalArray);
        if(countFromLeft == 4 || countFromRight == 4){
            return true;
        } else {return false;}
    }

    public int countOfMatchesFromLeft(int[] rankOrdinalArray){
        int countOfMatchesFromLeft = 1;
        for (int i = 0; i < rankOrdinalArray.length; i++){
            if (rankOrdinalArray[i] == rankOrdinalArray[i + 1]){
                countOfMatchesFromLeft++;
            } else {return countOfMatchesFromLeft;}
        }
        return countOfMatchesFromLeft;
    }

    public int countOfMatchesFromRight(int[] rankOrdinalArray){
        int countOfMatchesFromRight = 1;
        for (int i = rankOrdinalArray.length - 1; i > 0; i--){
            if (rankOrdinalArray[i] == rankOrdinalArray[i-1]){
                countOfMatchesFromRight++;
            } else {return countOfMatchesFromRight;}
        }
        return countOfMatchesFromRight;
    }

    public boolean fullHouseChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        Arrays.sort(rankOrdinalArray);
        int countFromLeft = countOfMatchesFromLeft(rankOrdinalArray);
        int countFromRight = countOfMatchesFromRight(rankOrdinalArray);
        if((countFromLeft == 3 && countFromRight == 2) || (countFromLeft == 2 && countFromRight == 3)){
            return true;
        } else {return false;}
    }

    public int countOfMatchesFromPosition2(int[] rankOrdinalArray){
        int countOfMatchesFromPosition2 = 1;
        for (int i = 1; i < rankOrdinalArray.length; i++){
            if (rankOrdinalArray[i] == rankOrdinalArray[i+1]){
                countOfMatchesFromPosition2++;
            } else {return countOfMatchesFromPosition2;}
        }
        return countOfMatchesFromPosition2;
    }

    public boolean tripsChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        int countFromLeft, countFromRight, countFromPosition2;
        countFromLeft = countOfMatchesFromLeft(rankOrdinalArray);
        countFromRight = countOfMatchesFromRight(rankOrdinalArray);
        countFromPosition2 = countOfMatchesFromPosition2(rankOrdinalArray);
        if (countFromLeft == 3 || countFromPosition2 == 3 || countFromRight == 3){
            return true;
        } else
            return false;
    }

    public boolean checkForPairAroundPosition2(int[] rankOrdinalArray){
        if (rankOrdinalArray[1] == rankOrdinalArray[0] || rankOrdinalArray[1] == rankOrdinalArray[2]){
            return true;
        } else {return false;}
    }

    public boolean checkForPairAroundPosition4(int[] rankOrdinalArray){
        if (rankOrdinalArray[3] == rankOrdinalArray[2] || rankOrdinalArray[3] == rankOrdinalArray[4]){
            return true;
        } else {return false;}
    }

    public boolean checkForJacksOrBetterPairAroundPosition2(int[] rankOrdinalArray){
        if (rankOrdinalArray[1] == rankOrdinalArray[0] && (rankOrdinalArray[1] == 0 || rankOrdinalArray[1] > 9)){
            return true;
        } else if (rankOrdinalArray[1] == rankOrdinalArray[2] && (rankOrdinalArray[1] == 0 || rankOrdinalArray[1] > 9)) {
            return true;
        } else { return false;}
    }

    public boolean checkForJacksOrBetterPairAroundPosition4(int[] rankOrdinalArray){
        if (rankOrdinalArray[3] == rankOrdinalArray[2] && (rankOrdinalArray[3] == 0 || rankOrdinalArray[3] > 9)){
            return true;
        } else if (rankOrdinalArray[3] == rankOrdinalArray[4] && (rankOrdinalArray[3] == 0 || rankOrdinalArray[3] > 9)){
            return true;
        } else {
            return false;
        }
    }

    public boolean twoPairChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        if(checkForPairAroundPosition2(rankOrdinalArray) && checkForPairAroundPosition4(rankOrdinalArray)){
            return true;
        } else {return false;}
    }

    public boolean jacksOrBetterChecker(HashMap<Integer, Card> hand){
        int[] rankOrdinalArray = convertToRankOrdinalArray(hand);
        if(checkForJacksOrBetterPairAroundPosition2(rankOrdinalArray) || checkForJacksOrBetterPairAroundPosition4(rankOrdinalArray)){
            return true;
        } else {return false;}
    }

    public String getWinConditionThatIsMet(HashMap<Integer, Card> playerHand){
        if (flushChecker(playerHand) && straightChecker(playerHand) && royalChecker(playerHand)){
            return "royalFlush";
        } else if (flushChecker(playerHand) && straightChecker(playerHand) ){
            return "straightFlush";
        } else if (fourOfAKindChecker(playerHand)){
            return "fourOfAKind";
        } else if (fullHouseChecker(playerHand)) {
            return "fullHouse";
        } else if (flushChecker(playerHand)){
            return "flush";
        } else if (straightChecker(playerHand)){
            return "straight";
        } else if (tripsChecker(playerHand)){
            return "threeOfAKind";
        } else if (twoPairChecker(playerHand)){
            return "twoPair";
        } else if (jacksOrBetterChecker(playerHand)){
            return "jacksOrBetter";
        } else { return "lostHand";}
    }
}