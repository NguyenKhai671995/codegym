package ss8_cleancode.bai_tap;

public class TennisGame {
    private static final String ZERO_SCORE = "Love";
    private static final String ONE_SCORE = "Fifteen";
    private static final String TWO_SCORE = "Thirty";
    private static final String THREE_SCORE = "Forty";
    private static final String ALL = "All";
    private static final String WIN = "Win";
    private static final String DEUCE = "Deuce";
    private static final String ADVANTAGE = "Advantage";


    public static String getScore(String playerOneName, String playerTwoName, int playerOneScore, int playerTwoScore) {

        if (playerOneScore == playerTwoScore) {
            return displayDeuce(playerOneScore);
        }
        if (playerOneScore >= 4 || playerTwoScore >= 4) {
            return displayAdvantageOrWin(playerOneName, playerTwoName, playerOneScore, playerTwoScore);
        }
        return displayScore(playerOneScore, playerTwoScore);
    }

    private static String displayDeuce(int score) {
        return translateScore(score) + "-" + ALL;
    }

    private static String displayAdvantageOrWin(String playerOneName, String playerTwoName, int playerOneScore, int playerTwoScore) {
        int minusResult = playerOneScore - playerTwoScore;

        if (minusResult == 1) {
            return ADVANTAGE + " " + playerOneName;
        } else if (minusResult == -1) {
            return ADVANTAGE + " " + playerTwoName;
        } else if (minusResult >= 2) {
            return WIN + " " + playerOneName;
        } else {
            return WIN + " " + playerTwoName;
        }
    }

    private static String displayScore(int playerOneScore, int playerTwoScore) {
        return translateScore(playerOneScore) + "-" + translateScore(playerTwoScore);
    }

    private static String translateScore(int score) {
        switch (score) {
            case 0:
                return ZERO_SCORE;
            case 1:
                return ONE_SCORE;
            case 2:
                return TWO_SCORE;
            case 3:
                return THREE_SCORE;
            default:
                return DEUCE;
        }

    }

}

