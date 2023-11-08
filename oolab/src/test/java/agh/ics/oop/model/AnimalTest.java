package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void isAtTest() {
        Animal animalTested0 = new Animal();

        assertTrue(animalTested0.isAt(new Vector2d(2,2)));
        assertFalse(animalTested0.isAt(new Vector2d(6,9)));
    }

    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f"};
    List<MoveDirection> directions = OptionsParser.parse(args);

    @Test
    void parserTest() {
        assertEquals(MoveDirection.FORWARD, directions.get(0));
        assertEquals(MoveDirection.BACKWARD, directions.get(1));
        assertEquals(MoveDirection.RIGHT, directions.get(2));
        assertEquals(MoveDirection.LEFT, directions.get(3));
        assertEquals(MoveDirection.FORWARD, directions.get(4));
    }

    @Test
    void borderTest() {
        Animal animalTested1 = new Animal(new Vector2d(1,1));

        animalTested1.move(MoveDirection.BACKWARD);
        assertTrue(animalTested1.isAt(new Vector2d(1,0)));
        animalTested1.move(MoveDirection.BACKWARD);
        assertFalse(animalTested1.isAt(new Vector2d(1,-1)));
        animalTested1.move(MoveDirection.LEFT);
        assertTrue(animalTested1.isAt(new Vector2d(1,0)));
        animalTested1.move(MoveDirection.FORWARD);
        assertTrue(animalTested1.isAt(new Vector2d(0,0)));
        animalTested1.move(MoveDirection.FORWARD);
        assertFalse(animalTested1.isAt(new Vector2d(-1,0)));
    }

    @Test
    void moveTest() {
        Animal animalTested2 = new Animal(new Vector2d(2,1));
        Animal animalTested3 = new Animal(new Vector2d(1,3));

        animalTested2.move(directions.get(0));
        assertTrue(animalTested2.isAt(new Vector2d(2, 2)));
        animalTested3.move(directions.get(1));
        assertTrue(animalTested3.isAt(new Vector2d(1, 2)));
        animalTested2.move(directions.get(2));
        assertTrue(animalTested2.isAt(new Vector2d(2, 2)));
        animalTested3.move(directions.get(3));
        assertTrue(animalTested3.isAt(new Vector2d(1, 2)));
        animalTested2.move(directions.get(4));
        assertTrue(animalTested2.isAt(new Vector2d(3, 2)));
        animalTested3.move(directions.get(5));
        assertTrue(animalTested3.isAt(new Vector2d(0, 2)));
        animalTested2.move(directions.get(6));
        assertTrue(animalTested2.isAt(new Vector2d(3, 2)));
        animalTested3.move(directions.get(7));
        assertTrue(animalTested3.isAt(new Vector2d(0, 2)));
        animalTested2.move(directions.get(8));
        assertTrue(animalTested2.isAt(new Vector2d(3, 1)));
        animalTested3.move(directions.get(9));
        assertTrue(animalTested3.isAt(new Vector2d(0, 3)));
    }

    @Test
    void orientationTest() {
        Animal animalTested4 = new Animal();

        animalTested4.move(MoveDirection.RIGHT);
        animalTested4.move(MoveDirection.FORWARD);
        assertTrue(animalTested4.isAt(new Vector2d(3,2)));
        animalTested4.move(MoveDirection.RIGHT);
        animalTested4.move(MoveDirection.FORWARD);
        assertTrue(animalTested4.isAt(new Vector2d(3,1)));
        animalTested4.move(MoveDirection.RIGHT);
        animalTested4.move(MoveDirection.FORWARD);
        assertTrue(animalTested4.isAt(new Vector2d(2,1)));
        animalTested4.move(MoveDirection.RIGHT);
        animalTested4.move(MoveDirection.FORWARD);
        assertTrue(animalTested4.isAt(new Vector2d(2,2)));
    }
}
