package agh.ics.oop;

import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.precedes(position2));
        System.out.println(position1.follows(position2));
        System.out.println(position1.add(position2));
        System.out.println(position1.subtract(position2));
        System.out.println(position1.upperRight(position2));
        System.out.println(position1.lowerLeft(position2));
        System.out.println(position1.opposite());
        System.out.println(position2.opposite());
    }
}
