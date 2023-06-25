package com.epicness.endurtawer.game.logic;

public class Debugger extends GameLogicHandler {

    public static boolean debug = false;
    public static boolean onlyDebug = false;

    public void toggleDebug() {
        debug = !debug;
        onlyDebug = onlyDebug && debug;
    }

    public void toggleOnlyDebug() {
        onlyDebug = !onlyDebug;
        debug = debug || onlyDebug;
    }
}