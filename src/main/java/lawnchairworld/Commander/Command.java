package lawnchairworld.Commander;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Command {
    String[] aliases();
    String helpinfo();
}
