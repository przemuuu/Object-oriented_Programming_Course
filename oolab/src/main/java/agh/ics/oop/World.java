package agh.ics.oop;

import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        System.out.print("system wystartował \n");
        MovDir.MoveDirection[] directions = OptionsParser.OptPar(args);
        run(directions);
        System.out.println("system zakończył działanie");
    }
    public static void run(MovDir.MoveDirection[] directions) {
        for (MovDir.MoveDirection direction : directions) {
            switch(direction) {
                case FORWARD:
                    System.out.println("zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("zwierzak skręca w prawo");
                    break;
                case LEFT:
                    System.out.println("zwierzak skręca w lewo");
                    break;
            }
        }
    }
}
