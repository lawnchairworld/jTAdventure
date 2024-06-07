package lawnchairworld.Commander;

import lawnchairworld.Color;
import lawnchairworld.Entity.Player;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;


//regex magic goes here
//must extract an initial command verb, then an argument (if any), then any modifiers (if any)
//if an input is invalid it should be able to pattern match and suggest what might have been meant
public class Parser {
    //grab all methods (and presumably all information like annotations)
    Method[] commands = Commands.class.getMethods();
    Command command;
    Commands com;
    HashMap<String[], Method> commandMap;
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
    }

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
                System.out.println(Color.color(input, Color.ANSI_RED) + " was not understood.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
