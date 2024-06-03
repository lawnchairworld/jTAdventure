package lawnchairworld;

import java.util.Scanner;
/*
    this is the main game loop. all it should do is display events in the text log and await player input,
    while advancing time in the background (when time is added). all events should be handled by other
    classes
 */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.println("Hello world!");
        System.out.println("Starting....\n");
        while (true) {
            input = scan.nextLine();
            Commander.execute(input);
        }
    }
}