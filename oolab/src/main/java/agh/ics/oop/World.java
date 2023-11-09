package agh.ics.oop;

import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.MapDirection;

public class World {
    public static void main() {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}
