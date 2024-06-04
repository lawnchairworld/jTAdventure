package lawnchairworld.World;


import java.util.HashMap;

/*
    this should --
    1. read and parse a map of all desired rooms & their attributes
    2. create a data structure consisting of rooms from said file
    things should be hardcoded as little as possible, as a rule
 */
public class RoomFactory {
        public static HashMap<Integer, Room> make() {
            //ugly
            Room startRoom = new Room("Test Room", "Hello, World!", 0, 0);
            Room testRoom = new Room("DEADLY LAIR OF LAVA", "Hello, World!", 0, 1);
            HashMap<Integer, Room> map = new HashMap<>();
            map.put(0, startRoom);
            map.put(1, testRoom);
            return map;
    }
}
