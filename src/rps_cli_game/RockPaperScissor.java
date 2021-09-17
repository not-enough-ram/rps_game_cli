package rps_cli_game;

import java.util.Random;
import java.util.Scanner;


public class RockPaperScissor {
    private static final Scanner scanner = new Scanner(System.in);

    private static void gameLoop() {
        while (true) {
            String playerMove = getPlayerInput();
            if (playerMove.equalsIgnoreCase("quit")) break;
            if (playerMove.equalsIgnoreCase("invalid")) {
                System.out.println("Ungueltiger Spielzug!");
                continue;
            }
            System.out.println(getGameResults(playerMove));
        }
    }

    private static String getPlayerInput() {
        System.out.println("Dein Spielzug: 'Schere', 'Stein' oder 'Papier' ('Quit'?)");
        String playerMove = scanner.nextLine();
        if (playerMove.equalsIgnoreCase("quit")) {
            return "quit";
        } else if (playerMove.equalsIgnoreCase("schere") ||
                playerMove.equalsIgnoreCase("stein") ||
                playerMove.equalsIgnoreCase("papier")) {
            return playerMove;
        } else
            return "invalid";
    }

    private static String getGameResults(String playerMove) {
        String cpuMove = getRandomChoice();
        return compareMoves(playerMove, cpuMove);
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
