package agh.ics.oop.model;

import java.sql.SQLOutput;

public class ConsoleMapDisplay implements MapChangeListener{
    private int updates = 0;
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        updates++;
        System.out.println(message);
        System.out.println(worldMap.toString());
        System.out.println("Number of updates: " + updates);
    }
}
