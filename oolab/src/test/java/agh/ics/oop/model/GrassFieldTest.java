package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    AbstractWorldMap map = new GrassField(10);
    @Test
    public void placeTest() {
        Animal animalTested1 = new Animal(new Vector2d(2,1));
        Animal animalTested2 = new Animal(new Vector2d(3,7));
        Animal animalTested3 = new Animal(new Vector2d(3,7));
        assertTrue(map.place(animalTested1));
        assertTrue(map.place(animalTested2));
        assertFalse(map.place(animalTested3));
    }
    @Test
    public void isOccupiedTest() {
        Animal animalTested4 = new Animal(new Vector2d(6,9));
        map.place(animalTested4);
        assertTrue(map.isOccupied(new Vector2d(6,9)));
        assertFalse(map.isOccupied(new Vector2d(6,6)));
    }
    @Test
    public void objectAtTest() {
        Animal animalTested5 = new Animal(new Vector2d(2,2));
        map.place(animalTested5);
        assertEquals(map.objectAt(new Vector2d(2,2)),animalTested5);
        assertNotEquals(map.objectAt(new Vector2d(3,3)),animalTested5);
    }
    @Test
    public void toStringTest() {
        System.out.println(map.toString());
        Animal animalTested6 = new Animal(new Vector2d(4,4));
        map.place(animalTested6);
        System.out.println(map.toString());
    }
    @Test
    public void canMoveToTest() {
        Animal animalTested7 = new Animal(new Vector2d(5,5));
        map.place(animalTested7);
        assertTrue(map.canMoveTo(new Vector2d(4,5)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
    }
    @Test
    public void moveTest() {
        Animal animalTested8 = new Animal(new Vector2d(7,7));
        map.place(animalTested8);
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
        map.place(animalTested9);
        Animal animalTested10 = new Animal(new Vector2d(5,5));
        map.place(animalTested10);
        assertEquals(map.getElements().size(),12);
        Animal animalTested11 = new Animal(new Vector2d(1,1));
        map.place(animalTested11);
        Animal animalTested12 = new Animal(new Vector2d(-3,-5));
        map.place(animalTested12);
        assertEquals(map.getElements().size(),14);
    }
}