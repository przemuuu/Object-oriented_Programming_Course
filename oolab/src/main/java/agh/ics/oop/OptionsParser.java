package agh.ics.oop;

import agh.ics.oop.model.MovDir;

import java.util.Arrays;

public class OptionsParser {
    public static MovDir.MoveDirection[] OptPar(String[] args) {
        int argLength = args.length;
        MovDir.MoveDirection directions[] = new MovDir.MoveDirection[argLength];
        int i=0;
        for(String arg : args) {
            switch(arg) {
                case "f":
                    directions[i] = (MovDir.MoveDirection.FORWARD);
                    i++;
                    break;
                case "b":
                    directions[i] = MovDir.MoveDirection.BACKWARD;
                    i++;
                    break;
                case "r":
                    directions[i] = MovDir.MoveDirection.RIGHT;
                    i++;
                    break;
                case "l":
                    directions[i] = MovDir.MoveDirection.LEFT;
                    i++;
                    break;
            }
        }
        return Arrays.copyOfRange(directions,0,i);
    }
}
