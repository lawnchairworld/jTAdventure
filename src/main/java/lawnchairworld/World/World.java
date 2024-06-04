package lawnchairworld.World;

import lawnchairworld.Commander.Parser;
import lawnchairworld.Entity.Player;

import java.util.Scanner;

public class World {
    //a STATIC map means the map can't change... which means no user-created worlds like other MUDs
    static Map map = new Map(RoomFactory.make());
    Player player = new Player("dev");
    public Parser parser = new Parser(player);
    Scanner scan = new Scanner(System.in);

    public static Map getMap() {
        return map;
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void Run() {
        map.getRoom(0).addPlayer(player);
        while (true) {
            String input = scan.nextLine();
            parser.parse(input);
        }
    }

}
