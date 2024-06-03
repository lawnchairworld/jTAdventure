package lawnchairworld;

public class Commander {
    public static void execute(String input) {
        if (input.equals("quit") || input.equals("exit")) {
            Commands.exitGame();
        }
        else {
            System.out.println(Color.ANSI_RED + input + Color.ANSI_RESET + " was not understood.");
        }
    }

}
