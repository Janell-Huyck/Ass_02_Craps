import java.util.Scanner;
import java.util.Random;

public class Main {

    private static final Random rand = new Random(); // Shared Random instance for consistent dice rolls

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Craps!");
        playCraps(scanner);
        System.out.println("Thanks for playing Craps! Goodbye!");
        scanner.close();
    }

    private static void playCraps(Scanner scanner) {
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Rolling the dice!");
            int crapsRoll = rollDice();
            System.out.println("You rolled a " + crapsRoll + "!");

            String gameResult = getGameResult(crapsRoll);
            System.out.println(gameResult);

            playAgain = checkPlayAgain(scanner);
        }
    }

    private static boolean checkPlayAgain(Scanner scanner) {
        return SafeInput.getYNConfirm(scanner, "Would you like to play again?");
    }

    private static String getGameResult(int crapsRoll) {
        if (crapsRoll == 7 || crapsRoll == 11) {
            return "That's a natural! Congratulations, you win!";
        } else if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
            return "That's a craps! Sorry, you lose.";
        } else {
            return rollForPoint(crapsRoll);
        }
    }

    private static String rollForPoint(int crapsRoll) {
        System.out.println("Rolling for a point!");
        while (true) {
            System.out.print("Rolling the dice!\t");
            int pointRoll = rollDice();
            System.out.println("You rolled a " + pointRoll + "!");
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