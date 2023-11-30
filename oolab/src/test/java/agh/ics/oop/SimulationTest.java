package agh.ics.oop;

import agh.ics.oop.model.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimulationTest {

    @Test
    public void simulationTest1() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(args);
        AbstractWorldMap map = new RectangularMap(9,9);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertTrue(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(2,3)));
        assertFalse(map.isOccupied(new Vector2d(3,3)));
    }
    @Test
    public void simulationTest2() {
        String[] args = {"f", "b", "r", "l", "r", "f", "b", "r", "b", "f", "f", "l", "l", "f", "b", "f", "r", "f"};
        List<MoveDirection> directions = OptionsParser.parse(args);
        AbstractWorldMap map = new RectangularMap(5,5);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4), new Vector2d(2,3), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions, map);
        simulation.run();

        assertFalse(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.isOccupied(new Vector2d(3,4)));
        assertFalse(map.isOccupied(new Vector2d(2,3)));
        assertTrue(map.isOccupied(new Vector2d(1,3)));
        assertTrue(map.isOccupied(new Vector2d(2,1)));
        assertTrue(map.isOccupied(new Vector2d(3,1)));
    }
}
