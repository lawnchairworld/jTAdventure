package jtadventure.commander;

//format input text for easy command parsing
public class InputHandler {
    public static String commandSmoother(String input) {
        input = input.toLowerCase().trim();
        if (input.startsWith("go")) {
            input = input.substring(2);
        }
        return switch (input) {
            case "n" -> "north";
            case "s" -> "south";
            case "e" -> "east";
            case "w" -> "west";
            case "sw" -> "southwest";
            case "nw" -> "northwest";
            case "se" -> "southeast";
            case "ne" -> "northeast";
            case "d" -> "down";
            case "u" -> "up";
            default -> input;
        };
    }
}
