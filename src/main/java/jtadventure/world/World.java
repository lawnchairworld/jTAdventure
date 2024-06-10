package jtadventure.world;

import jtadventure.commander.Parser;
import jtadventure.entity.Player;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class World {
    public static Map map;
    static Player player = new Player("dev");
    public static Parser parser = new Parser(player);
    Scanner scan = new Scanner(System.in);
    public World() {
        try {
            System.out.println("Making rooms...");
            map = new Map(Objects.requireNonNull(RoomFactory.make()));
        } catch (Exception e) {
            System.out.println("Map creation failed.");
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void Run() {
        map.getRoom(0).addPlayer(player);
        while (true) {
            try {
                String input = scan.nextLine();
                parser.parse(input);
            } catch (Exception e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
    }

    public Map getMap() {
        return map;
    }
}
