package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    class valid implements MoveValidator {
        public boolean canMoveTo(Vector2d position) {
            return true;
        }
    }
    valid validator = new valid();
    @Test
    void isAtTest() {
        Animal animalTested0 = new Animal();

        assertTrue(animalTested0.isAt(new Vector2d(2,2)));
        assertFalse(animalTested0.isAt(new Vector2d(6,9)));
    }
    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f"};
    List<MoveDirection> directions = OptionsParser.parse(args);
    @Test
    void moveTest() {
        Animal animalTested2 = new Animal(new Vector2d(2,1));
        Animal animalTested3 = new Animal(new Vector2d(1,3));

        animalTested2.move(directions.get(0),validator);
        assertTrue(animalTested2.isAt(new Vector2d(2, 2)));
        animalTested3.move(directions.get(1),validator);
        assertTrue(animalTested3.isAt(new Vector2d(1, 2)));
        animalTested2.move(directions.get(2),validator);
        assertTrue(animalTested2.isAt(new Vector2d(2, 2)));
        animalTested3.move(directions.get(3),validator);
        assertTrue(animalTested3.isAt(new Vector2d(1, 2)));
        animalTested2.move(directions.get(4),validator);
        assertTrue(animalTested2.isAt(new Vector2d(3, 2)));
        animalTested3.move(directions.get(5),validator);
        assertTrue(animalTested3.isAt(new Vector2d(0, 2)));
        animalTested2.move(directions.get(6),validator);
        assertTrue(animalTested2.isAt(new Vector2d(3, 2)));
        animalTested3.move(directions.get(7),validator);
        assertTrue(animalTested3.isAt(new Vector2d(0, 2)));
        animalTested2.move(directions.get(8),validator);
        assertTrue(animalTested2.isAt(new Vector2d(3, 1)));
        animalTested3.move(directions.get(9),validator);
        assertTrue(animalTested3.isAt(new Vector2d(0, 3)));
    }

    @Test
    void orientationTest() {
        Animal animalTested4 = new Animal();

        animalTested4.move(MoveDirection.RIGHT,validator);
        animalTested4.move(MoveDirection.FORWARD,validator);
        assertTrue(animalTested4.isAt(new Vector2d(3,2)));
        animalTested4.move(MoveDirection.RIGHT,validator);
        animalTested4.move(MoveDirection.FORWARD,validator);
        assertTrue(animalTested4.isAt(new Vector2d(3,1)));
        animalTested4.move(MoveDirection.RIGHT,validator);
        animalTested4.move(MoveDirection.FORWARD,validator);
        assertTrue(animalTested4.isAt(new Vector2d(2,1)));
        animalTested4.move(MoveDirection.RIGHT,validator);
        animalTested4.move(MoveDirection.FORWARD,validator);
        assertTrue(animalTested4.isAt(new Vector2d(2,2)));
    }
}
