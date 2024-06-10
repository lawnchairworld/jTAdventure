package jtadventure.entity;

public class Player extends Entity {
    //gurps stats
    public Player(String name) {
        this.name = name;
        this.hp = 10;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
}
