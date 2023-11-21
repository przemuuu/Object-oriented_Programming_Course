package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.print("system wystartował \n");
        List<MoveDirection> directions = OptionsParser.parse(args);
        WorldMap map = new RectangularMap(9,9);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();
        System.out.println("system zakończył działanie");
    }
}
