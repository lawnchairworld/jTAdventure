package jtadventure.entity;

/*
    default null entity should be a Perfectly Generic Object
    otherwise monsters/players/items (anything that ISNT a room i.e. interactable) should extend this
 */
public class Entity {
    String name;
    float hp;
}
