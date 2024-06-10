package jtadventure.world;

import jtadventure.entity.Player;
import jtadventure.util;

import java.util.HashMap;

public class Map {
    HashMap<Integer, Room> rooms;

    Map(HashMap<Integer, Room> rooms) {
        this.rooms = rooms;
        System.out.println("Creating navmap....");
        for (Room r : rooms.values()) {
            for (Room rr : rooms.values()) {
                for (String dir : new String[]{"up", "down", "north", "south", "east", "west",
                "northeast", "southeast", "northwest", "southwest"}) {
                    if (util.checkDir(r, rr, dir)) {
                        r.addNeighbor(dir, rr);
                    }
                }
            }
        }
    }


    public Room getRoomOfPlayer(Player player) {
        for (Room pr : rooms.values()) {
            if (pr.getPlayers().contains(player)) {
                return pr;
            }
        }
        return null;
    }

    public Room getRoom(Integer key) {
        return rooms.get(key);
    }

    public void movePlayer(String dir, Player player) {
        Room pr = getRoomOfPlayer(player);
        if (pr.findNeighbor(dir) != null) {
            if (pr.getRoomExits().contains(dir)) {
                pr.removePlayer(player);
                System.out.println("You head " + dir + ".");
                pr.findNeighbor(dir).addPlayer(player);
                World.parser.parse("look");
            } else {
                System.out.println("You cannot go that way.");
            }
        } else {
            System.out.println("There is nothing this way.");
        }
    }
}
