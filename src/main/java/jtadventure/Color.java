package jtadventure;

import jtadventure.commander.Parser;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Color {

    public static String color(String string, String ansi) {
        return ansi + string + Parser.colorMap.get("RESET");
    }
    //slightly less sucky
    public enum ColorCode {
        RESET ("[0m"),
        BLACK ("[30m"),
        RED ("[31m"),
        GREEN ("[32m"),
        YELLOW ("[33m"),
        BLUE ("[34m"),
        PURPLE ("[35m"),
        CYAN ("[36m"),
        WHITE ("[37m"),
        BRIGHT_BLACK ("[90m"),
        ESC ("[");
        public final String code;
        ColorCode(String code) {
            this.code = code;
        }
    }
    //regular background
    public static final String BG_BLACK = "[40m";
    public static final String BG_RED = "[41m";
    public static final String BG_GREEN = "[42m";
    public static final String BG_YELLOW = "[43m";
    public static final String BG_BLUE = "[44m";
    public static final String BG_PURPLE = "[45m";
    public static final String BG_CYAN = "[46m";
    public static final String BG_WHITE = "[47m";
    //bright
    public static final String BRIGHT_BLACK = "[90m";
    public static final String BRIGHT_RED = "[91m";
    public static final String BRIGHT_GREEN = "[92m";
    public static final String BRIGHT_YELLOW = "[93m";
    public static final String BRIGHT_BLUE = "[94m";
    public static final String BRIGHT_PURPLE = "[95m";
    public static final String BRIGHT_CYAN = "[96m";
    public static final String BRIGHT_WHITE = "[97m";
    //bright background
    public static final String BRIGHT_BG_BLACK = "[100m";
    public static final String BRIGHT_BG_RED = "[101m";
    public static final String BRIGHT_BG_GREEN = "[102m";
    public static final String BRIGHT_BG_YELLOW = "[103m";
    public static final String BRIGHT_BG_BLUE = "[104m";
    public static final String BRIGHT_BG_PURPLE = "[105m";
    public static final String BRIGHT_BG_CYAN = "[106m";
    public static final String BRIGHT_BG_WHITE = "[107m";
    //bold
    public static final String BOLD_BLACK = "[1;30m";
    public static final String BOLD_RED = "[1;31m";
    public static final String BOLD_GREEN = "[1;32m";
    public static final String BOLD_YELLOW = "[1;33m";
    public static final String BOLD_BLUE = "[1;34m";
    public static final String BOLD_PURPLE = "[1;35m";
    public static final String BOLD_CYAN = "[1;36m";
    public static final String BOLD_WHITE = "[1;37m";
    // dim/faint 2;
    // italic 3;
    // underline 4;
    // blinking 5;
    // 6; idek
    // 7: inverse
    // 8: hidden
    // 9: strikethrough


}
