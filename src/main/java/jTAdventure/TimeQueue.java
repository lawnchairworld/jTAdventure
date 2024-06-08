package jTAdventure;

/*
    alternative name: TaskHandler/TaskScheduler
    desired game methods/cmdline output should be passed here
    every tick/time interval (some amount of irl time per 1 in-game second it will then process everything
    in the command queue, first all desired methods, then all print output, cleanly handling
    everything in a 'turn'
    possibly needed classes: a QueueHandler, an EventHandler, an OutputHandler (an OutputHandler specifically
    would decouple hardcoded printlns from client output and would make it easier to transition into a MOO
    as well as handle/format text behind the scenes (maybe a TextHandler.... that accepts a desired string
    output alongside and coloring and formatting arguments, regex might come in handy for that

    additionally, system output tasks (i.e. 'l'ooking, looking at your inventory/localmap) should
    be processed immediately, while Game Event actions should be processed according to the time system
    and, ideally, logged in some capacity, for server moderation
 */
public class TimeQueue {
    //
}
