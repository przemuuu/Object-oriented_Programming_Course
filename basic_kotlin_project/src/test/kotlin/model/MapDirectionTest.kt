package model

import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class MapDirectionTest {
    @Test
    fun `toString should return correct string representation`() {
        assertEquals("N", MapDirection.NORTH.toString())
        assertEquals("S", MapDirection.SOUTH.toString())
        assertEquals("W", MapDirection.WEST.toString())
        assertEquals("E", MapDirection.EAST.toString())
    }

    @Test
    fun `next should return the next direction in clockwise order`() {
        assertEquals(MapDirection.EAST, MapDirection.NORTH.next())
        assertEquals(MapDirection.WEST, MapDirection.SOUTH.next())
        assertEquals(MapDirection.NORTH, MapDirection.WEST.next())
        assertEquals(MapDirection.SOUTH, MapDirection.EAST.next())
    }

    @Test
    fun `previous should return the previous direction in clockwise order`() {
        assertEquals(MapDirection.WEST, MapDirection.NORTH.previous())
        assertEquals(MapDirection.SOUTH, MapDirection.WEST.previous())
        assertEquals(MapDirection.EAST, MapDirection.SOUTH.previous())
        assertEquals(MapDirection.NORTH, MapDirection.EAST.previous())
    }

    @Test
    fun `toUnitVector should return the correct unit vector`() {
        assertEquals(Vector2d(0, 1), MapDirection.NORTH.toUnitVector())
        assertEquals(Vector2d(-1, 0), MapDirection.WEST.toUnitVector())
        assertEquals(Vector2d(0, -1), MapDirection.SOUTH.toUnitVector())
        assertEquals(Vector2d(1, 0), MapDirection.EAST.toUnitVector())
    }
}