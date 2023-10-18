package agh.ics.oop;

import agh.ics.oop.model.MovDir;

public class OptPar {
    public static MovDir.MoveDirection[] OptionsParser(String[] args) {
        int argLength = args.length;
        MovDir.MoveDirection directions[] = new MovDir.MoveDirection[argLength];
        int i=0;
        for(String arg : args) {
            switch(arg) {
                case "f":
                    directions[i]=(MovDir.MoveDirection.FORWARD);
                    break;
                case "b":
                    directions[i]= MovDir.MoveDirection.BACKWARD;
                    break;
                case "r":
                    directions[i]= MovDir.MoveDirection.RIGHT;
                    break;
                case "l":
                    directions[i]= MovDir.MoveDirection.LEFT;
                    break;
                default: continue;
            }
            i++;
        }
        return directions;
    }
}
