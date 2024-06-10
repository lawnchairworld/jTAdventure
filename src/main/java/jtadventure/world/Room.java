package jtadventure.world;

import jtadventure.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Room {
    ArrayList<Player> players;
    String title;
    String description;
    public int x;
    public int y;
    public int z;
    String color;
    String glyph;
    HashMap<String, Room> neighbors = new HashMap<>();
    ArrayList<String> roomExits;

    Room(String title, String description, int x, int y, int z, String color, String glyph,
         ArrayList<String> roomExits) {
        this.title = title;
        this.description = description;
        this.x = x;
        this.y = y;
        this.z = z;
        this.players = new ArrayList<>();
        this.color = color;
        this.glyph = glyph;
        this.roomExits = roomExits;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) { this.players.add(player); }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() { return z; }

    public String getTitle() {
        return title;
    }

    public String getColor() {
        return color;
    }

    public String getGlyph() {
        return glyph;
    }

    public ArrayList<String> getRoomExits() {
        return roomExits;
    }

    public String getDescription() {return description; }

    public Room findNeighbor(String dir) {
        return neighbors.get(dir);
    }

    public Set<String> getNeighbors() {
        return neighbors.keySet();
    }

    public void addNeighbor(String dir, Room neighbor) {
        this.neighbors.put(dir, neighbor);
    }
}
