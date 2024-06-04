package lawnchairworld.World;

import lawnchairworld.Entity.Player;

import java.util.HashMap;

public class Map {
    HashMap<Integer, Room> rooms;

    Map(HashMap<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoomOfPlayer(Player player) {
        for (Room r : rooms.values()) {
            if (r.getPlayers().contains(player)) {
                System.out.println(r);
                return r;
            }
        } return null;
    }

    public Room getRoom(Integer key) {
        return rooms.get(key);
    }

    public void movePlayer(String dir, Player player) {
        Room pr = getRoomOfPlayer(player);
        if (dir.equals("n")) {
            for (Room r : rooms.values()) {
                if (r.getY() == pr.getY() + 1) {
                    pr.removePlayer(player);
                    r.addPlayer(player);
                }
            }
        }
    }
}
