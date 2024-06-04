package lawnchairworld.Commander;

import lawnchairworld.Color;
import lawnchairworld.Entity.Player;
import lawnchairworld.World.World;

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
    public void help() {
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
    public void exitGame() {
        System.out.println(Color.ANSI_CYAN + "Goodbye!" + Color.ANSI_RESET);
        System.exit(0);
    }

    @Command(aliases={"north", "n"}, helpinfo="Goes north")
    //ugly and just for testing
    public void goNorth() {
        System.out.println("You head north.");
        World.getMap().movePlayer("n", player);
        System.out.println(World.getMap().getRoomOfPlayer(player).getTitle());
        System.out.println(World.getMap().getRoomOfPlayer(player).getDescription());
    }
}
