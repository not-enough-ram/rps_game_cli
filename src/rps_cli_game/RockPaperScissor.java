package rps_cli_game;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissor {
    private static final Scanner scanner = new Scanner(System.in);

    private static void gameLoop() {
        while (true) {
            String userInput = getPlayerInput();
            if (userInput.equals("quit")) break;
            if (userInput.equals("invalid")) {
                System.out.println("Ungueltiger Spielzug!");
                continue;
            }
            System.out.println(getGameResults(userInput));
        }
    }

    private static String getPlayerInput() {
        System.out.println("Dein Spielzug: 'Schere', 'Stein' oder 'Papier' ('Quit'?)");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("quit")) {
            return "quit";
        } else if (userInput.equalsIgnoreCase("schere") ||
                userInput.equalsIgnoreCase("stein") ||
                userInput.equalsIgnoreCase("papier")) {
            return userInput.toLowerCase();
        } else
            return "invalid";
    }

    private static String getGameResults(String userInput) {
        String cpuMove = getRandomChoice();
        return compareMoves(userInput, cpuMove);
    }

    private static String compareMoves(String playerMove, String cpuMove) {
        System.out.println("Spieler spielt " + playerMove + ". Computer spielt " + cpuMove + ".");
        if (playerMove.equalsIgnoreCase(cpuMove)) {
            return "Unentschieden";
        }

        if (playerMove.equalsIgnoreCase("schere")) {
            if (cpuMove.equalsIgnoreCase("papier")) {
                return "Gewonnen!";
            } else
                return "Verloren...";
        } else if (playerMove.equalsIgnoreCase("stein")) {
            if (cpuMove.equalsIgnoreCase("schere")) {
                return "Gewonnen!";
            } else
                return "Verloren...";
        } else {
            if (cpuMove.equalsIgnoreCase("stein")) {
                return "Gewonnen!";
            } else
                return "Verloren...";
        }
    }

    private static String getRandomChoice() {
        String[] choices = new String[]{"Schere", "Stein", "Papier"};
        Random r = new Random();
        return choices[r.nextInt(choices.length)];
    }

    public static void main(String[] args) {
        gameLoop();
    }
}
