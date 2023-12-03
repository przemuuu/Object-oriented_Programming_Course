package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

public class GrassTest {
    @Test
    public void getPositionTest() {
        Grass grassTested1 = new Grass(new Vector2d(1, 1));
        Grass grassTested2 = new Grass(new Vector2d(2, 2));
        assert grassTested1.getPosition().equals(new Vector2d(1, 1));
        assert grassTested2.getPosition().equals(new Vector2d(2, 2));
        assert !grassTested1.getPosition().equals(new Vector2d(2, 2));
    }
    @Test
    public void toStringTest() {
        Grass grassTested3 = new Grass(new Vector2d(1, 1));
        Grass grassTested4 = new Grass(new Vector2d(2, 2));
        assert grassTested3.toString().equals("*");
        assert grassTested4.toString().equals("*");
        assert !grassTested3.toString().equals(" ");
    }
    @Test
    public void isAtTest() {
        Grass grassTested5 = new Grass(new Vector2d(1, 1));
        Grass grassTested6 = new Grass(new Vector2d(2, 2));
        assert grassTested5.isAt(new Vector2d(1, 1));
        assert grassTested6.isAt(new Vector2d(2, 2));
        assert !grassTested5.isAt(new Vector2d(2, 2));
    }
}
