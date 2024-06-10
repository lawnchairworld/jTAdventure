package jtadventure.commander;

import jtadventure.Color;
import jtadventure.entity.Player;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class Parser {
    //grab all methods (and presumably all information like annotations)
    Method[] commands = Commands.class.getMethods();
    Command command;
    Commands com;
    static HashMap<String[], Method> commandMap;
    public static HashMap<String, String> colorMap = new HashMap<>();
    Player player;
    public Parser(Player user) {
        this.player = user;
        com = new Commands(this.player);
        commandMap = new HashMap<>();
        //init cmdmap
        for (Method m : commands) {
            if (m.isAnnotationPresent(Command.class)) {
                command = m.getAnnotation(Command.class);
                commandMap.put(command.aliases(), m);
            }
        }
        for (Color.ColorCode c : Color.ColorCode.values()) {
            colorMap.put(c.toString(), c.code);
        }
    }

    //todo slice input into pieces, deduce command based off 1st word, then invoke command with args
    public void parse(String input) {
        try {
            int i = 0;
            for (String[] sa : commandMap.keySet()) {
                if (Arrays.asList(sa).contains(input)) {
                    Method m = commandMap.get(sa);
                    m.invoke(com, input);
                    //to avoid "not understanding" an understood command
                    break;
                }
                i += 1;
            }
            //when ran through all commands print error
            if (i == commandMap.keySet().size()) {
                System.out.println(Color.color(input, colorMap.get("RED")) + " was not understood.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static HashMap<String[], Method> getCommandMap() {
        return commandMap;
    }
}
