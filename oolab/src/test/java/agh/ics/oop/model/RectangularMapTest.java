package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    RectangularMap map = new RectangularMap(8,8);
    @Test
    void lowerLeftTest() {
        assertEquals(map.getLowerLeft(),new Vector2d(0,0));
    }
    @Test
    void upperRightTest() {
        assertFalse(map.getUpperRight().equals(new Vector2d(8,8)));
        assertTrue(map.getUpperRight().equals(new Vector2d(7,7)));
    }
    @Test
    void placeTest() {
        Animal animalTested1 = new Animal(new Vector2d(2,1));
        Animal animalTested2 = new Animal(new Vector2d(3,7));
        Animal animalTested3 = new Animal(new Vector2d(3,7));
        assertTrue(map.place(animalTested1,animalTested1.getPosition()));
        assertTrue(map.place(animalTested2,animalTested2.getPosition()));
        assertFalse(map.place(animalTested3,animalTested3.getPosition()));
    }
    @Test
    void isOccupiedTest() {
        Animal animalTested4 = new Animal(new Vector2d(6,9));
        map.place(animalTested4,animalTested4.getPosition());
        assertTrue(map.isOccupied(new Vector2d(6,9)));
        assertFalse(map.isOccupied(new Vector2d(6,6)));
    }
    @Test
    void objectAtTest() {
        Animal animalTested5 = new Animal(new Vector2d(2,2));
        map.place(animalTested5,animalTested5.getPosition());
        assertEquals(map.objectAt(new Vector2d(2,2)),animalTested5);
        assertNotEquals(map.objectAt(new Vector2d(3,3)),animalTested5);
    }
    @Test
    void toStringTest() {
        System.out.println(map.toString());
        Animal animalTested6 = new Animal(new Vector2d(4,4));
        map.place(animalTested6,animalTested6.getPosition());
        System.out.println(map.toString());
    }
    @Test
    void canMoveToTest() {
        Animal animalTested7 = new Animal(new Vector2d(5,5));
        map.place(animalTested7,animalTested7.getPosition());
        assertTrue(map.canMoveTo(new Vector2d(4,5)));
        assertFalse(map.canMoveTo(new Vector2d(5,5)));
    }
    @Test
    void moveTest() {
        Animal animalTested8 = new Animal(new Vector2d(7,7));
        map.place(animalTested8,animalTested8.getPosition());
        map.move(animalTested8,MoveDirection.BACKWARD);
        assertTrue(map.isOccupied(new Vector2d(7,6)));
        map.move(animalTested8,MoveDirection.BACKWARD);
        assertTrue(map.isOccupied(new Vector2d(7,5)));
        map.move(animalTested8,MoveDirection.LEFT);
        assertFalse(map.isOccupied(new Vector2d(6,5)));
    }
}
