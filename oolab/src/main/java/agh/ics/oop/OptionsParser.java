package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) {
        int argLength = args.length;
        MoveDirection[] directions = new MoveDirection[argLength];
        int i=0;
        for(String arg : args) {
            switch(arg) {
                case "f":
                    directions[i] = MoveDirection.FORWARD;
                    i++;
                    break;
                case "b":
                    directions[i] = MoveDirection.BACKWARD;
                    i++;
                    break;
                case "r":
                    directions[i] = MoveDirection.RIGHT;
                    i++;
                    break;
                case "l":
                    directions[i] = MoveDirection.LEFT;
                    i++;
                    break;
            }
        }
        return Arrays.copyOfRange(directions,0,i);
    }
}
