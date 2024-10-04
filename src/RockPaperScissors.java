import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuePlaying;

        do {
            String movePlayer1 = promptForMove(scanner, "Player 1");
            String movePlayer2 = promptForMove(scanner, "Player 2");

            determineWinner(movePlayer1, movePlayer2);

            System.out.print("Would you like to play again? (Y/N): ");
            continuePlaying = scanner.nextLine().trim();
            while (continuePlaying.isEmpty()) {
                continuePlaying = scanner.nextLine().trim();
            }

        } while (continuePlaying.equalsIgnoreCase("Y"));
    }

    public static String promptForMove(Scanner scanner, String playerName) {
        String userMove;
        do {
            System.out.print(playerName + ", please enter your choice (R/P/S): ");
            userMove = scanner.nextLine().trim();
        } while (!isValidChoice(userMove));
        return userMove.toUpperCase();
    }

    public static boolean isValidChoice(String choice) {
        return choice.equalsIgnoreCase("R") || choice.equalsIgnoreCase("P") || choice.equalsIgnoreCase("S");
    }

    public static void determineWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            System.out.println("It's a draw! Both players chose " + move1 + ".");
        } else if (doesPlayer1Win(move1, move2)) {
            System.out.println(move1 + " defeats " + move2 + ". Player 1 wins!");
        } else {
            System.out.println(move2 + " defeats " + move1 + ". Player 2 wins!");
        }
    }

    public static boolean doesPlayer1Win(String move1, String move2) {
        return (move1.equals("R") && move2.equals("S")) ||
                (move1.equals("P") && move2.equals("R")) ||
                (move1.equals("S") && move2.equals("P"));
    }
}
