package jTAdventure.World;

import jTAdventure.Entity.Player;

import java.util.HashMap;

public class Map {
    HashMap<Integer, Room> rooms;

    Map(HashMap<Integer, Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoomOfPlayer(Player player) {
        for (Room r : rooms.values()) {
            if (r.getPlayers().contains(player)) {
                return r;
            }
        }
        return null;
    }

    public Room getRoom(Integer key) {
        return rooms.get(key);
    }

    public void movePlayer(String dir, Player player) {
        Room pr = getRoomOfPlayer(player);
        String godir = "";
        //todo smoothly handle room transitions because might be slow for larger worlds
        switch (dir) {
            case "n":
            case "north":
                for (Room r : rooms.values()) {
                    if (r.getY() == pr.getY() + 1) {
                        pr.removePlayer(player);
                        r.addPlayer(player);
                        godir = "north";
                        break;
                    }
                }
                break;
            case "s":
            case "south":
                for (Room r : rooms.values()) {
                    if (r.getY() == pr.getY() - 1) {
                        pr.removePlayer(player);
                        r.addPlayer(player);
                        godir = "south";
                        break;
                    }
                }
                break;
            case "e":
            case "east":
                for (Room r : rooms.values()) {
                    if (r.getX() == pr.getX() + 1) {
                        pr.removePlayer(player);
                        r.addPlayer(player);
                        godir = "east";
                        break;
                    }
                }
                break;
            case "w":
            case "west":
                for (Room r : rooms.values()) {
                    if (r.getX() == pr.getX() - 1) {
                        pr.removePlayer(player);
                        r.addPlayer(player);
                        godir = "west";
                        break;
                    }
                }
                break;
                //todo diags
            default:
                godir = "";
        }
        if (!godir.isEmpty()) {
            System.out.println("You head " + godir + ".");
            System.out.println(World.map.getRoomOfPlayer(player).getTitle());
            System.out.println(World.map.getRoomOfPlayer(player).getDescription());
        } else {
            System.out.println("There is nothing this way.");
        }
    }
}
