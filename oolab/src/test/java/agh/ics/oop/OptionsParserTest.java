package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.PositionAlreadyOccupiedException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionsParserTest {
    @Test
    void parserTest() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f"};
        List<MoveDirection> directions = OptionsParser.parse(args);
        assertEquals(MoveDirection.FORWARD, directions.get(0));
        assertEquals(MoveDirection.BACKWARD, directions.get(1));
        assertEquals(MoveDirection.RIGHT, directions.get(2));
        assertEquals(MoveDirection.LEFT, directions.get(3));
        assertEquals(MoveDirection.FORWARD, directions.get(4));
    }
    @Test
    void exceptionTest() {
        String[] args2 = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "X"};
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args2));
        String[] args3 = {"f", "b", "r", "l", "f", "D", "r", "r", "f", "f"};
        assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(args3));
    }
}
