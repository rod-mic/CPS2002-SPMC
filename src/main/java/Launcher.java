import Exceptions.SizeException;
import Objects.Game;
import Objects.MapTypes.MapCreator;
import Objects.MapTypes.MapInterface;
import Objects.Observer.Player;
import Objects.Observer.Team;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by rodemic on 07/04/2017.
 */

public class Launcher {

    //Main method for running game
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n"); //creates a Scanner Object for use of user input
        Game game = setup(sc);
        game.startGame();   //Begins the game
    }

    //Function for getting an integer input from user taking a minimum and maximum input
    public static int getIntegerInput(int min, int max, Scanner sc) {
        boolean check;
        int input = min - 1;
        do {
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input < min || input > max) throw new SizeException(min + " and " + max);
                check = true;
            } catch (NumberFormatException ex) { //Handles input of non-digits
                System.out.print("Incorrect input. Numbers only. Try again: ");
                check = false;
            } catch (SizeException ex) {         //Handles when input is below or above the min or the maximum respectively
                System.out.print("The range is between " + ex.getMessage() + ". Try again: ");
                check = false;
            }
        } while (!check);
        return input;
    }

    //Function that sets up the game according to user input
    public static Game setup(Scanner sc) {

        //Settings variable initialisation
        int numPlayer;
        int mapSize;
        int mapType;
        int gameType;

        Player[] players;
        MapInterface map;
        Game game;

        System.out.println("Welcome to the game!");
        System.out.println("Choose game type: (1) Individual - (2) Collaborative"); //Choice for whether players to play in teams or solo

        gameType = getIntegerInput(1, 2, sc);

        System.out.println("Choose map type: (1) Safe - (2) Hazardous"); //Choice between two map types, safe and hazardous

        mapType = getIntegerInput(1, 2, sc);

        System.out.println("How many users will be playing? (2-8 Players)"); //Choice for amount of players in game

        numPlayer = getIntegerInput(2, 8, sc);
        players = new Player[numPlayer];
        if (numPlayer < 5) {
            System.out.println("How big  will the map be? (Between 5x5 and 50x50)"); //Choice for map size when players less than 5
            mapSize = getIntegerInput(5, 50, sc);
        } else {
            System.out.println("How big  will the map be? (Between 8x8 and 50x50)"); //Choice for map size when players 5 or more
            mapSize = getIntegerInput(8, 50, sc);
        }
        MapCreator mc = new MapCreator();
        map = mc.createMap(mapSize,numPlayer,mapType);

        if (gameType == 2) { //Section of code for setting up teams
            int max = numPlayer-1;
            System.out.println("How many teams will be playing? (2-" + max + " Teams)");
            int numTeam = getIntegerInput(2, max, sc);
            Team[] teams = new Team[numTeam];

            for (int i = 0; i < numTeam; i++) {
                teams[i] = new Team();
            }


            int playerCounter = 0; //counter for keeping track of players in a team
            int teamCounter = 0;   //counter for keeping track of team number index
            while(playerCounter < numPlayer){

                if(teamCounter >= numTeam)
                    teamCounter = 0;

                int randPlayer;
                Player chosenPlayer;
                Team currentTeam = teams[teamCounter];

                do {
                    randPlayer = ThreadLocalRandom.current().nextInt(0, numPlayer); //chooses a random player that has not yet been put in team
                    chosenPlayer = players[randPlayer];
                } while (chosenPlayer != null);
                System.out.println("Player "+randPlayer+" added to team "+teamCounter);
                players[randPlayer] = new Player(map,currentTeam); //creates a Player Object
                currentTeam.Attach(players[randPlayer]);
                teamCounter++;
                playerCounter++;
            }
        } else { //Setup for solo play
            for (int i = 0; i < numPlayer; i++) {
                players[i] = new Player(map);
            }
        }
        game = new Game(players, map); //creates a Game Object taking the set of players and created map
        game.generateHTMLFiles();   //generates html files for each player
        return game;
    }
}
