import Exceptions.SizeException;
import Objects.Game;
import Objects.Map;
import Objects.Player;
import Objects.Team;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rodemic on 07/04/2017.
 */
public class Launcher {

    public static void main(String[] args) {
        Game game = setup();
        game.startGame();

    }

    public static int getIntegerInput(int min, int max, Scanner sc) {
        boolean check = false;
        int input = min - 1;
        do {
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) throw new SizeException(min + " and " + max);
                check = true;
            } catch (NumberFormatException ex) {
                System.out.println("Incorrect input. Numbers only. Try again: ");
                check = false;
            } catch (SizeException ex) {
                System.out.println("The range is between " + ex.getMessage() + ". Try again: ");
                check = false;
            }
        } while (!check);
        return input;
    }

    public static Game setup() {
        int numPlayer;
        int numTeam;
        int mapSize;
        int mapType;
        int gameType;

        Team[] teams;
        Player[] players;
        Map map = new Map();
        Game game;
        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Welcome to the game!");
        System.out.println("Choose game type: (1) Individual - (2) Collaborative");

        gameType = getIntegerInput(1, 2, sc);

        System.out.println("Choose map type: (1) Safe - (2) Hazardous");

        mapType = getIntegerInput(1, 2, sc);

        System.out.println("How many users will be playing? (2-8 Players)");

        numPlayer = getIntegerInput(2, 8, sc);
        players = new Player[numPlayer];
        if (numPlayer < 5) {
            System.out.println("How big  will the map be? (Between 5x5 and 50x50)");
            mapSize = getIntegerInput(5, 50, sc);
        } else {
            System.out.println("How big  will the map be? (Between 8x8 and 50x50)");
            mapSize = getIntegerInput(8, 50, sc);
        }
        map.setMapSize(mapSize, numPlayer, mapType);

        if (gameType == 2) {
            int max = (int) Math.ceil(numPlayer / 2.0);
            System.out.println("How many teams will be playing? (2-" + max + " Teams)");
            numTeam = getIntegerInput(2, max, sc);
            teams = new Team[numTeam];

            int maxSize = (int) Math.ceil((double) numPlayer / numTeam);

            for (int i = 0; i < numTeam; i++) {
                teams[i] = new Team();
            }

            for (int i = 0; i < numPlayer; i++) {
                int randTeam;
                Team chosenTeam;
                do {
                    randTeam = ThreadLocalRandom.current().nextInt(0, numTeam);
                    chosenTeam = teams[randTeam];
                } while (chosenTeam.getSize() > maxSize);
                chosenTeam.incrementSize();
                System.out.println("Team " + randTeam + " added to player " + i);
                players[i] = new Player(map, chosenTeam);
            }
        } else {
            for (int i = 0; i < numPlayer; i++) {
                players[i] = new Player(map);
            }
        }
        game = new Game(players, map);
        game.generateHTMLFiles();
        return game;
    }
}
