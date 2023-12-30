package agh.ics.oop;

import agh.ics.oop.model.*;
import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.print("system wystartował \n");
        ConsoleMapDisplay consoleMapDisplay = new ConsoleMapDisplay();
        List<MoveDirection> directions;
        List<Simulation> simulations = new ArrayList<>();
        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return;
        }
        for(int i=0;i<1000;i++) {
//            AbstractWorldMap map = new GrassField((int)(Math.random()*100)+1);
            AbstractWorldMap map = new GrassField(15);
            AbstractWorldMap map2 = new RectangularMap(10,10);
            map.addObserver(consoleMapDisplay);
            map2.addObserver(consoleMapDisplay);
            List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
            simulations.add(new Simulation(positions, directions, map));
        }
        SimulationEngine simulationEngine = new SimulationEngine(simulations);
//        simulationEngine.runAsync();
        simulationEngine.runAsyncInThreadPool();
        simulationEngine.awaitSimulationsEnd();
        System.out.println("System zakończył działanie.");
    }
}
