package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void equalsTest() {
        assertTrue(new Vector2d(7,7).equals(new Vector2d(7,7)));
        assertFalse(new Vector2d(3,6).equals(new Vector2d(1,6)));
        assertTrue(new Vector2d(9,6).equals(new Vector2d(9,6)));
        assertFalse(new Vector2d(2,1).equals(new Vector2d(3,7)));
    }

    @Test
    void toStringTest() {
        assertTrue(new Vector2d(3, 7).toString().equals("(3,7)"));
        assertTrue(new Vector2d(9, 1).toString().equals("(9,1)"));
        assertFalse(new Vector2d(3,3).toString().equals("(1,1)"));
        assertFalse(new Vector2d(2,1).toString().equals("(3,7)"));
    }
    @Test
    void precedesTest() {
        assertTrue(new Vector2d(1,1).precedes(new Vector2d(1,1)));
        assertTrue(new Vector2d(2,2).precedes(new Vector2d(3,4)));
        assertFalse(new Vector2d(8,1).precedes(new Vector2d(5,9)));
        assertFalse(new Vector2d(8,8).precedes(new Vector2d(7,7)));
    }
    @Test
    void followsTest() {
        assertTrue(new Vector2d(1,1).follows(new Vector2d(1,1)));
        assertFalse(new Vector2d(2,2).follows(new Vector2d(3,4)));
        assertFalse(new Vector2d(8,1).follows(new Vector2d(5,9)));
        assertTrue(new Vector2d(8,8).follows(new Vector2d(7,7)));
    }
    @Test
    void upperRightTest() {
        assertTrue(new Vector2d(0, 5).upperRight(new Vector2d(5, 5)).equals(new Vector2d(5, 5)));
        assertTrue(new Vector2d(3, 3).upperRight(new Vector2d(3, 5)).equals(new Vector2d(3, 5)));
        assertTrue(new Vector2d(4, 2).upperRight(new Vector2d(4, 2)).equals(new Vector2d(4, 2)));
        assertFalse(new Vector2d(8, 8).upperRight(new Vector2d(9, 8)).equals(new Vector2d(0, 0)));
    }
    @Test
    void lowerLeftTest() {
        assertFalse(new Vector2d(0, 5).lowerLeft(new Vector2d(5, 5)).equals(new Vector2d(5, 5)));
        assertFalse(new Vector2d(3, 3).lowerLeft(new Vector2d(3, 5)).equals(new Vector2d(3, 5)));
        assertTrue(new Vector2d(4, 2).lowerLeft(new Vector2d(4, 2)).equals(new Vector2d(4, 2)));
        assertFalse(new Vector2d(8, 8).lowerLeft(new Vector2d(9, 8)).equals(new Vector2d(0, 0)));
    }
    @Test
    void addTest() {
        assertTrue(new Vector2d(3, 3).add(new Vector2d(2, 2)).equals(new Vector2d(5, 5)));
        assertTrue(new Vector2d(1, 1).add(new Vector2d(0, 0)).equals(new Vector2d(1, 1)));
        assertTrue(new Vector2d(2, 1).add(new Vector2d(3, 7)).equals(new Vector2d(5, 8)));
        assertFalse(new Vector2d(2, 1).add(new Vector2d(3, 7)).equals(new Vector2d(6, 9)));
    }
    @Test
    void subtractTest() {
        assertTrue(new Vector2d(3, 3).subtract(new Vector2d(2, 2)).equals(new Vector2d(1, 1)));
        assertTrue(new Vector2d(1, 1).subtract(new Vector2d(0, 0)).equals(new Vector2d(1, 1)));
        assertTrue(new Vector2d(2, 1).subtract(new Vector2d(3, 7)).equals(new Vector2d(-1, -6)));
        assertFalse(new Vector2d(2, 1).subtract(new Vector2d(3, 7)).equals(new Vector2d(6, 9)));
    }
    @Test
    void oppositeTest() {
        assertTrue(new Vector2d(1,3).opposite().equals(new Vector2d(3,1)));
        assertTrue(new Vector2d(9,6).opposite().equals(new Vector2d(6,9)));
        assertFalse(new Vector2d(2,3).opposite().equals(new Vector2d(2,3)));
        assertFalse(new Vector2d(7,5).opposite().equals(new Vector2d(8,8)));
    }
}
