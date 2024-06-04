package lawnchairworld.World;

import lawnchairworld.Entity.Player;

import java.util.ArrayList;

public class Room {
    ArrayList<Player> players;
    String title;
    String description;
    public int x;
    public int y;

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    Room(String title, String description, int x, int y) {
        this.title = title;
        this.description = description;
        this.x = x;
        this.y = y;
        this.players = new ArrayList<>();
    }
}
