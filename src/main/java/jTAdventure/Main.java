package jTAdventure;

import jTAdventure.World.World;

/*
    this is the main game loop. all it should do is display events in the text log and await player input,
    while advancing time in the background (when time is added). all events should be handled by other
    classes
 */
public class Main {
    public static void main(String[] args) {
        //init
        World world = new World();
        Initializer.init();
        //init
        world.Run();
    }
}