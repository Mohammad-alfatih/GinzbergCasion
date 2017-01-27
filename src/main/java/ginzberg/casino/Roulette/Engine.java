package ginzberg.casino.Roulette;

import ginzberg.casino.Games.UserIO;

/**
 * Created by rickjackson on 1/25/17.
 */
public class Engine {
    private int step;
    private Input in;
    private Output out;
    private PlaceBet placeBet;
    private UserIO userIO;
    private Double balance;
    private Bet bet;
    private Chip chip;
    private Help help;
    private MinimumBet minimumBet;
    private Payout payout;
    private Wheel wheel;
    private Integer winningNumber;
    private String betType;
    private boolean ballSpinning;
    private Integer stack;
    private String result;
    private String input;
    private String output;
    private Integer amount;
    private String number;
    private Integer winnings;
    private Integer pocket;
    private Integer chipRequest;
    private String holder;
    private Integer tempInteger;

    Engine() {
        step = 0;
        in = new Input();
        out = new Output();
        placeBet = new PlaceBet();
        userIO = new UserIO();
        balance = userIO.getUserBalance();
        bet = new Bet();
        chip = new Chip();
        help = new Help();
        minimumBet = new MinimumBet();
        payout = new Payout();
        wheel = new Wheel();
        winningNumber = null;
        result = "WELCOME";
        input = "";
        output = "";
        stack = 0;
        betType = "";
        ballSpinning = false;
        amount = 0;
        number = "";
        winnings = 0;
        pocket = null;
        chipRequest = null;
        holder = "";
        tempInteger = 0;
    }

    public void run() {
        String s = "WELCOME";

        while (!s.equals("QUIT")) {
            s = gameflow(s);
        }
    }

    private String gameflow(String s) {
        s = s.toUpperCase();

        switch (s) {
            case "HELP":
                // show help files
                break;

            case "WELCOME":
                help.showTable();
                out.casinoOutput("WELCOME TO ROULETTE\n");
                result = "CHIP REQUEST";
                break;

            case "CHIP REQUEST":
                out.casinoOutput("How many chips would you like?");
                chipRequest = chip.requestChips(balance);
                out.casinoOutput("");

                if (chipRequest >= 1) {
                    result = "GIVE CHIPS";
                } else if (chipRequest == 0) {
                    out.casinoOutput("You do not have enough money for that many chips.");
                    result = "CHIP REQUEST";
                } else if (chipRequest == -1) {
                    result = "QUIT";
                } else if (chipRequest == -2) {
                    out.casinoOutput("I can not give you free chips.");
                    result = "CHIP REQUEST";
                } else {
                    out.casinoOutput("What?");
                    result = "CHIP REQUEST";
                }
                break;

            case "GIVE CHIPS":
                chip.getChips(chipRequest, balance, minimumBet.getMinimum());
                balance -= stack;
                result = "CHOOSE BET TYPE";
                break;

            case "CHOOSE BET TYPE":
                out.casinoOutput("Choose your bet type.");
                input = in.userInput();
                result = bet.validateBetType(input);
                break;

            case "GET BET TYPE":
                input = bet.getBetType(input.toUpperCase());
                input = input.toUpperCase();
                result = input;
                break;

            case "STRAIGHT UP":
                out.casinoOutput("Choose a Straight Up number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setStraightUp(number, amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "COLUMN":
                out.casinoOutput("Choose a Column number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Column " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setColumn(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "ANY DOZEN":
                out.casinoOutput("Choose a Dozen number.");
                number = in.userInput();
                switch (number) {
                    case "1":
                        holder = "1st Dozen";
                        break;
                    case "2":
                        holder = "2nd Dozen";
                        break;
                    case "3":
                        holder = "3rd Dozen";
                        break;
                    default:
                        break;
                }
                out.casinoOutput("How much would you like to bet on " + holder + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setDozen(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "RED OR BLACK":
                out.casinoOutput("Choose a Red or Black number.");
                number = in.userInput();
                switch (number) {
                    case "1":
                        holder = "Red";
                        break;
                    case "2":
                        holder = "Black";
                        break;
                    default:
                        break;
                }
                out.casinoOutput("How much would you like to bet on " + holder + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setRedBlack(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "1-18 OR 19-36":
                out.casinoOutput("Choose a High or Low number.");
                number = in.userInput();
                switch (number) {
                    case "1":
                        holder = "Low 1 to 18";
                        break;
                    case "2":
                        holder = "High 19 to 36";
                        break;
                    default:
                        break;
                }
                out.casinoOutput("How much would you like to bet on " + holder + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                payout.setHighLow(Integer.parseInt(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "EVEN OR ODD":
                out.casinoOutput("Choose an Even or Odd number.");
                number = in.userInput();
                switch (number) {
                    case "1":
                        holder = "Even";
                        break;
                    case "2":
                        holder = "Odd";
                        break;
                    default:
                        break;
                }
                out.casinoOutput("How much would you like to bet on " + holder + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setEvenOdd(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "SPLIT BET RIGHT":
                out.casinoOutput("Choose a Split Right number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Split Right " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setSplitRight(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "SPLIT BET DOWN":
                out.casinoOutput("Choose a Split Down number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Split Down " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setSplitDown(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "STREET":
                out.casinoOutput("Choose a Street number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Street " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setStreet(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "CORNER":
                out.casinoOutput("Choose a Corner number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Corner " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setCorner(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "TOPLINE":
                out.casinoOutput("Choose a Topline number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Topline " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setTopline(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "LINE":
                out.casinoOutput("Choose a Line number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Line " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setLine(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "0/00 SPLIT":
                out.casinoOutput("Choose a 0/00 Split number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on 0/00 Split " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setZeroDoubleZero(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "COURTESY WAGER":
                out.casinoOutput("Choose a Courtesy Wager number.");
                number = in.userInput();
                out.casinoOutput("How much would you like to bet on Courtesy Wager " + number + "?");
                input = in.userInput();
                amount = in.parseToInteger(input);
                placeBet.setCourtesy(Integer.valueOf(number), amount);
                out.casinoOutput("");
                result = "SPIN";
                break;

            case "SPIN":
                out.casinoOutput("---spinning---\n");
                wheel.spinBall();
                result = "NO MORE BETS";
                break;

            case "NO MORE BETS":
                out.casinoOutput("No more bets.\n");
                pocket = wheel.getWinningNumber();
                result = "GET WINNING NUMBER";
                break;

            case "GET WINNING NUMBER":
                winningNumber = wheel.getWinningNumberFromPocketSequence(pocket);
                result = "MARK WINNING NUMBER";
                break;

            case "MARK WINNING NUMBER":
                if (winningNumber == 37) {
                    out.casinoOutput("00" + "\n");
                } else {
                    out.casinoOutput(Integer.toString(winningNumber) + "\n");
                }
                result = "CLEAR ALL LOSING BETS";
                break;

            case "CLEAR ALL LOSING BETS":
                payout.clearLosingStraightUp(winningNumber);
//                payout.clearLosingBets(winningNumber, placeBet.column);
//                payout.clearLosingBets(winningNumber, placeBet.dozen);
//                payout.clearLosingBets(winningNumber, placeBet.redBlack);
                payout.clearLosingHighLowBets(winningNumber);
//                payout.clearLosingBets(winningNumber, placeBet.evenOdd);
//                payout.clearLosingBets(winningNumber, placeBet.splitDown);
//                payout.clearLosingBets(winningNumber, placeBet.splitRight);
//                payout.clearLosingBets(winningNumber, placeBet.street);
//                payout.clearLosingBets(winningNumber, placeBet.corner);
//                payout.clearLosingBets(winningNumber, placeBet.topline);
//                payout.clearLosingBets(winningNumber, placeBet.line);
//                payout.clearLosingBets(winningNumber, placeBet.zeroDoubleZero);
//                payout.clearLosingBets(winningNumber, placeBet.courtesy);
                result = "APPOLOGIZE TO PLAYER";
                break;

            case "APPOLOGIZE TO PLAYER":
//                out.casinoOutput("Sorry...\n");
                result = "PAYOUT ALL WINNING BETS";
                break;

            case "PAYOUT ALL WINNING BETS":
                winnings = 0;
                winnings += payout.payoutHalfBet(winningNumber, "E");
                winnings += payout.payoutEvenOddBet(winningNumber, "F");
                winnings += payout.payoutRedBlackBet(winningNumber, "D");
                winnings += payout.payoutDozenBet(winningNumber, "C");
                winnings += payout.payoutColumnBet(winningNumber, "B");
                winnings += payout.payoutLineBet(winningNumber, "K");
                winnings += payout.payoutToplineBet(winningNumber, "J");
                winnings += payout.payoutCornerBet(winningNumber, "I");
                winnings += payout.payoutStreetBet(winningNumber, "H");
                winnings += payout.payoutCourtesyBet(winningNumber, "M");
                winnings += payout.payoutZeroDoubleZero(winningNumber, "L");
                winnings += payout.payoutSplitRight(winningNumber, "GR");
                winnings += payout.payoutSplitDownBet(winningNumber, "GD");
                winnings += payout.payoutWinningStraightUp(winningNumber);
                result = "CONGRATULATE PLAYER";

//            case "PAYOUT ALL WINNING BETS":
//                winnings = 0;
//                out.casinoOutput("Winnings: $" + winnings);
//                tempInteger = bet.getWinningHalfBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.highLow, tempInteger, "E");
//                tempInteger = bet.getWinningEvenOddBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.evenOdd, tempInteger, "F");
//                tempInteger = bet.getWinningRedBlackBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.redBlack, tempInteger, "D");
//                tempInteger = bet.getWinningDozenBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.dozen, tempInteger, "C");
//                tempInteger = bet.getWinningColumnBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.column, tempInteger, "B");
//                tempInteger = bet.getWinningLineUpBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.line, tempInteger, "K");
//                tempInteger = bet.getWinningLineDownBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.line, tempInteger, "K");
//                tempInteger = bet.getWinningToplineBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.topline, tempInteger, "J");
//                tempInteger = bet.getWinningCornerUpLeftBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.corner, tempInteger, "I");
//                tempInteger = bet.getWinningCornerUpRightBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.corner, tempInteger, "I");
//                tempInteger = bet.getWinningCornerDownRightBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.corner, tempInteger, "I");
//                tempInteger = bet.getWinningCornerDownLeftBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.corner, tempInteger, "I");
//                tempInteger = bet.getWinningStreetBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.street, tempInteger, "H");
//                tempInteger = bet.getWinningCourtesyBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.courtesy, tempInteger, "M");
//                tempInteger = bet.getWinningZeroDoubleZeroBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.zeroDoubleZero, tempInteger, "L");
//                tempInteger = bet.getWinningSplitUpBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.splitDown, tempInteger, "GD");
//                tempInteger = bet.getWinningSplitDownBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.splitDown, tempInteger, "GD");
//                tempInteger = bet.getWinningSplitLeftBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.splitRight, tempInteger, "GR");
//                tempInteger = bet.getWinningSplitRightBet(winningNumber);
//                out.casinoOutput("tempInteger = " + tempInteger);
//                winnings += payout.payoutWinningBets(winningNumber, placeBet.splitRight, tempInteger, "GR");
//                winnings += payout.payoutWinningStraightUp(winningNumber);
//                result = "CONGRATULATE PLAYER";
//                break;

            case "CONGRATULATE PLAYER":
                out.casinoOutput("Winnings: $" + winnings);
                result = "QUIT";
                break;
            case "REMOVE MARKER":
                // dealer removes marker
                break;
            case "LET IT RIDE":
                // ask player if they would like to let it ride?
                break;
            case "ASK PLAYER WHAT THEY WOULD LIKE TO DO":
                //
                break;
            case "UPDATE MINIMUM BET":
                //
                break;
            default:
                break;
        }
        return result;
    }

//    private void gameflow(int i) {
//        while (i != -1) {
//            switch (i) {
//                case -1:
//                    // quit
//                    break;
//                case 0:
//                    // help
//                    break;
//                case 1:
//                    // greeting
//                    break;
//                case 2:
//                    // get chips
//                    break;
//                case 3:
//                    // get bet type
//                    break;
//                case 4:
//                    // get bet choice
//                    break;
//                case 5:
//                    // place bet amount
//                    break;
//                case 6:
//                    // spin wheel
//                    break;
//                case 7:
//                    // clear losing bets
//                    break;
//                case 8:
//                    // payout winning bets
//                    break;
//                case 9:
//                    // ask if they want to let it ride
//                    break;
//                case 10:
//                    // cash out
//                    break;
//            }
//        }
//
//    }
}
