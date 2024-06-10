package jtadventure;

import jtadventure.world.Room;

public class util {
    public static Boolean checkDir(Room r, Room rr, String dir) {
        if (r == rr) { return false; }
        if (!r.getRoomExits().contains(dir)) { return false; };
        boolean sameSpot = (r.getX() == rr.getX() && r.getY() == r.getY());
        boolean sameX = (r.getX() == rr.getX());
        boolean sameY = (r.getY() == rr.getY());
        boolean sameZ = (r.getZ() == rr.getZ());
        boolean northY = (r.getY() == rr.getY() - 1);
        boolean southY = (r.getY() == rr.getY() + 1);
        boolean eastX = (r.getX() == rr.getX() - 1);
        boolean westX = (r.getX() == rr.getX() + 1);
        boolean upZ = r.getZ() == rr.getZ() - 1;
        boolean downZ = r.getZ() == rr.getZ() + 1;
        return switch (dir) {
            case ("north") -> (sameX && northY && sameZ);
            case ("south") -> (sameX && southY && sameZ);
            case ("east") -> (sameY && eastX && sameZ);
            case ("west") -> (sameY && westX && sameZ);
            case ("northeast") -> (northY && eastX && sameZ);
            case ("southeast") -> (southY && eastX && sameZ);
            case ("northwest") -> (northY && westX && sameZ);
            case ("southwest") -> (southY && westX && sameZ);
            case ("up") -> (sameSpot && upZ);
            case ("down") -> (sameSpot && downZ);
            default -> false;
        };
    }
}
