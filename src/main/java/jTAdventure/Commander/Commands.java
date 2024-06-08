package jTAdventure.Commander;

import jTAdventure.Color;
import jTAdventure.Entity.Player;
import jTAdventure.World.World;

import java.lang.reflect.Method;

/*
    commands should be methods that contain
    a. the command
    b. a description of that command for 'help'
    c. command aliases
 */
public class Commands {
    Player player;
    public Commands(Player player) {
        this.player = player;
    }

    @Command(aliases={"help", "info"}, helpinfo="List all available commands, or inquire about a specific command")
    public void help(String input) {
        for (Method m : Commands.class.getMethods()) {
            if (m.isAnnotationPresent(Command.class)) {
                //only the first primary name for each command
                //display other aliases when a specific command is specified
                System.out.println(m.getAnnotation(Command.class).aliases()[0]);
            }
        }
        //if no arguments: display own helpinfo
        //if argument: display commands helpinfo
    }

    @Command(aliases={"quit", "exit", "logout", "disconnect", "dc"}, helpinfo="Quits the game.")
    public void exitGame(String input) {
        System.out.println(Color.ANSI_CYAN + "Goodbye!" + Color.ANSI_RESET);
        System.exit(0);
    }

    @Command(aliases={
            "north", "n", "s", "south", "w", "west", "e", "east", "ne", "northeast", "nw", "northwest",
            "se", "southeast", "sw", "southwest"
    }, helpinfo="Go north.")
    public void move(String input) {
        switch (input) {
            case "n":
            case "north":
                World.map.movePlayer("n", player);
                break;
            case "s":
            case "south":
                World.map.movePlayer("s", player);
                break;
            case "w":
            case "west":
                World.map.movePlayer("w", player);
                break;
            case "e":
            case "east":
                World.map.movePlayer("e", player);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
    }
}
