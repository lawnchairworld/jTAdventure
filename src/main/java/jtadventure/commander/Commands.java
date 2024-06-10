package jtadventure.commander;

import jtadventure.Color;
import jtadventure.entity.Player;
import jtadventure.world.Room;
import jtadventure.world.World;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Commands {
    Player player;
    // MUD framework should pass a player(s) for each command
    public Commands(Player player) {
        this.player = player;
    }

    @Command(aliases={"help", "info"}, helpinfo="List all available commands, or inquire about a specific command")
    public void help(String input) {
        System.out.println("Known commands:");
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
        System.out.println(Color.color("Goodbye!", Parser.colorMap.get("CYAN")));
        System.exit(0);
    }

    @Command(aliases={
            "go", "down", "up", "d", "u", "north", "n", "s", "south", "w", "west", "e", "east", "ne", "northeast", "nw",
            "northwest", "se", "southeast", "sw", "southwest",}, helpinfo="Go north.")
    public void move(String input) throws InvocationTargetException, IllegalAccessException {
        World.map.movePlayer(InputHandler.commandSmoother(input), player);
    }

    @Command(aliases={"look", "l"}, helpinfo="Look at your surroundings.")
    public void look(String input) {
        Room playerRoom = World.map.getRoomOfPlayer(player);
        System.out.print(Color.color(playerRoom.getGlyph(),
                Parser.colorMap.get(playerRoom.getColor())) + " ");
        System.out.println(Color.color(playerRoom.getTitle(),
                Parser.colorMap.get(playerRoom.getColor())));
        System.out.println(playerRoom.getDescription());
        System.out.print("{exits: ");
        for (String dir : World.map.getRoomOfPlayer(player).getNeighbors()) {
            System.out.print(dir + " ");
        }
        System.out.println("}");
    }
}
