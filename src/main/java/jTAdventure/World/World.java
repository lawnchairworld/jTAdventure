package jTAdventure.World;

import jTAdventure.Commander.Parser;
import jTAdventure.Entity.Player;

import java.util.Arrays;
import java.util.Scanner;

public class World {
    public static Map map;
    Player player = new Player("dev");
    public Parser parser = new Parser(player);
    Scanner scan = new Scanner(System.in);
    public World() {
        try {
            map = new Map(RoomFactory.make());
        } catch (Exception e) {
            System.out.println("Map creation failed.");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void Run() {
        map.getRoom(0).addPlayer(player);
        while (true) {
            String input = scan.nextLine();
            parser.parse(input);
        }
    }

    public Map getMap() {
        return map;
    }
}
