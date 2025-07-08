import java.util.Scanner;
import java.util.Random;

public class Main {

    private static final Random rand = new Random(); // A shared Random instance

    public static void main(String[] args) {
        int crapsRoll;
        boolean playAgain = true;
        String gameResult;
        Scanner pipe = new Scanner(System.in);

        System.out.println("Welcome to Craps!");
        
        while (playAgain) {
            System.out.println("Rolling the dice!");
            crapsRoll = rollDice();
            System.out.println("You rolled a " + crapsRoll + "!");

            if (crapsRoll == 7 || crapsRoll == 11) {
                gameResult = "That's a natural! Congratulations, you win!";
            } else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                gameResult = "That's a craps! Sorry, you lose.";
            } else {
                gameResult = rollForPoint(crapsRoll);
            }

            System.out.println(gameResult);

            playAgain = checkPlayAgain(pipe);
        }
        System.out.println("Thanks for playing Craps! Goodbye!");

        pipe.close();
    }

    private static boolean checkPlayAgain(Scanner pipe) {
        return SafeInput.getYNConfirm(pipe, "Would you like to play again?");
    }

    private static String rollForPoint(int crapsRoll) {
        System.out.println("Rolling for a point!");
        while (true) {
            System.out.print("Rolling the dice!\t");
            int pointRoll = rollDice();
            System.out.print("You rolled a " + pointRoll + "!\n");
            if (pointRoll == 7) {
                return "That's a craps! Sorry, you lose.";
            } else if (pointRoll == crapsRoll) {
                return "That's a point! Congratulations, you win!";
            }
        }
    }

    private static int rollDice() {
        int die1 = rollDie();
        int die2 = rollDie();
        return die1 + die2;
    }

    private static int rollDie() {
        return rand.nextInt(6) + 1;
    }
}