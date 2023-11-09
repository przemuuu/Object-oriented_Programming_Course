package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse(String[] args) {
        List<MoveDirection> directions = new ArrayList<MoveDirection>();
        for(String arg : args) {
            switch(arg) {
                case "f":
                    directions.add(MoveDirection.FORWARD);
                    break;
                case "b":
                    directions.add(MoveDirection.BACKWARD);
                    break;
                case "r":
                    directions.add(MoveDirection.RIGHT);
                    break;
                case "l":
                    directions.add(MoveDirection.LEFT);
                    break;
            }
        }
        return directions;
    }
}
