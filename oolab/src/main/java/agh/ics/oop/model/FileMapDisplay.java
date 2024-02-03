package agh.ics.oop.model;

import java.io.FileWriter;

public class FileMapDisplay implements MapChangeListener {
    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        int map_id = worldMap.getId();
        try(FileWriter file = new FileWriter(map_id + ".log",true)) {
            file.write(message + "\n");
            file.write(worldMap.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
