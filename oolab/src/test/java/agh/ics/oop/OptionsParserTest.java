package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsParserTest {
    String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f"};
    List<MoveDirection> directions = OptionsParser.parse(args);

    @Test
    void parserTest() {
        assertEquals(MoveDirection.FORWARD, directions.get(0));
        assertEquals(MoveDirection.BACKWARD, directions.get(1));
        assertEquals(MoveDirection.RIGHT, directions.get(2));
        assertEquals(MoveDirection.LEFT, directions.get(3));
        assertEquals(MoveDirection.FORWARD, directions.get(4));
    }
}
