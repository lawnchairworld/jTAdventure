package lawnchairworld;

import lawnchairworld.Commander.Parser;
import lawnchairworld.Entity.Player;

/*
    this should run through all setup functions and create everything necessary for the game
 */
public class Initializer {
    public static void init() {
        System.out.println("// CREATE A WORLD HERE");
        System.out.println("// FILL IT WITH THINGS HERE");
        /* todo write a function that goes through all rooms and stores their neighbors in an array
            to avoid doing that every time a player tries to move
         */
        System.out.println(Color.color("Starting...", Color.ANSI_GREEN));
    }
}
