package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    AbstractWorldMap map = new RectangularMap(10,10);
    @Test
    void placeTest() {
        Animal animalTested1 = new Animal(new Vector2d(2,1));
        Animal animalTested2 = new Animal(new Vector2d(3,7));
        Animal animalTested3 = new Animal(new Vector2d(3,7));
        try {
            assertTrue(map.place(animalTested1));
            assertTrue(map.place(animalTested2));
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        assertThrows(PositionAlreadyOccupiedException.class, () -> map.place(animalTested3));
    }
    @Test
    void isOccupiedTest() {
        Animal animalTested4 = new Animal(new Vector2d(6,9));
        try {
            map.place(animalTested4);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        assertTrue(map.isOccupied(new Vector2d(6,9)));
        assertFalse(map.isOccupied(new Vector2d(6,6)));
    }
    @Test
    void objectAtTest() {
        Animal animalTested5 = new Animal(new Vector2d(2,2));
        try {
            map.place(animalTested5);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(map.objectAt(new Vector2d(2,2)),animalTested5);
        assertNotEquals(map.objectAt(new Vector2d(3,3)),animalTested5);
    }
    @Test
    void toStringTest() {
        System.out.println(map.toString());
        Animal animalTested6 = new Animal(new Vector2d(4,4));
        try {
            map.place(animalTested6);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(map.toString());
    }
    @Test
    void canMoveToTest() {
        Animal animalTested7 = new Animal(new Vector2d(5,5));
        try {
            map.place(animalTested7);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        assertTrue(map.canMoveTo(new Vector2d(4,5)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
    }
    @Test
    void moveTest() {
        Animal animalTested8 = new Animal(new Vector2d(7,7));
        try {
            map.place(animalTested8);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        map.move(animalTested8,MoveDirection.BACKWARD);
        assertTrue(map.isOccupied(new Vector2d(7,6)));
        map.move(animalTested8,MoveDirection.BACKWARD);
        assertTrue(map.isOccupied(new Vector2d(7,5)));
        map.move(animalTested8,MoveDirection.LEFT);
        assertFalse(map.isOccupied(new Vector2d(6,5)));
    }
    @Test
    public void getElementsTest() {
        Animal animalTested9 = new Animal(new Vector2d(3,3));
        Animal animalTested10 = new Animal(new Vector2d(5,5));
        try {
            map.place(animalTested9);
            map.place(animalTested10);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(map.getElements().size(),2);
        Animal animalTested11 = new Animal(new Vector2d(1,1));
        Animal animalTested12 = new Animal(new Vector2d(1,1));
        try {
            map.place(animalTested11);
            map.place(animalTested12);
        } catch (PositionAlreadyOccupiedException e) {
            System.err.println(e.getMessage());
        }
        assertEquals(map.getElements().size(),3);
    }
}
