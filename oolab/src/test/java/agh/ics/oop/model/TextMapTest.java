package agh.ics.oop.model;

import org.junit.jupiter.api.Test;

public class TextMapTest {
    String[] args = {"Wiśnia","Borówka","Jabłko","Ananas","Gruszka","Truskawka","Poziomka"};

    @Test
    public void placeTest() {
        TextMap map = new TextMap();
        for(int i=0;i<args.length;i++) {
            map.place(args[i],i);
        }
        for(int i=0;i<args.length;i++) {
            assert(map.objectAt(i).equals(args[i]));
        }
    }
    @Test
    public void moveTest() {
        TextMap map = new TextMap();
        for(int i=0;i<args.length;i++) {
            map.place(args[i],i);
        }
        map.move("Borówka",MoveDirection.RIGHT);
        assert(map.objectAt(2).equals("Borówka"));
        assert(map.objectAt(1).equals("Jabłko"));
        map.move("Jabłko",MoveDirection.LEFT);
        assert(map.objectAt(1).equals("Wiśnia"));
        assert(map.objectAt(0).equals("Jabłko"));
        map.move("Jabłko",MoveDirection.LEFT);
        assert(map.objectAt(0).equals("Jabłko"));
        map.move("Truskawka",MoveDirection.RIGHT);
        assert(map.objectAt(6).equals("Truskawka"));
        assert(map.objectAt(5).equals("Poziomka"));
        map.move("Truskawka",MoveDirection.RIGHT);
        assert(map.objectAt(6).equals("Truskawka"));
    }
    @Test
    public void isOccupiedTest() {
        TextMap map = new TextMap();
        for(int i=0;i<args.length;i++) {
            map.place(args[i],i);
        }
        assert(map.isOccupied(0));
        assert(map.isOccupied(1));
        assert(map.isOccupied(2));
        assert(map.isOccupied(3));
        assert(map.isOccupied(4));
        assert(map.isOccupied(5));
        assert(map.isOccupied(6));
        assert(!map.isOccupied(7));
        assert(!map.isOccupied(8));
        assert(!map.isOccupied(9));
    }
    @Test
    public void getUpperRightTest() {
        TextMap map = new TextMap();
        for(int i=0;i<args.length;i++) {
            map.place(args[i],i);
        }
        assert(map.getUpperRight()==7);
    }
}
