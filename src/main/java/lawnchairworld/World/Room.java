package lawnchairworld.World;

import lawnchairworld.Entity.Player;

import java.util.ArrayList;

public class Room {
    ArrayList<Player> players;
    String title;
    String description;
    public int x;
    public int y;
    public int z;
    String color;
    String glyph;

    Room(String title, String description, int x, int y, int z, String color, String glyph) {
        this.title = title;
        this.description = description;
        this.x = x;
        this.y = y;
        this.z = z;
        this.players = new ArrayList<>();
        this.color = color;
        this.glyph = glyph;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}
