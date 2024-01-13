package model;

enum class MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    override fun toString() = when(this) {
        NORTH -> ("N")
        SOUTH -> ("S")
        WEST -> ("W")
        EAST -> ("E")
    }
    fun next() = when(this) {
        NORTH -> EAST
        SOUTH -> WEST
        WEST -> NORTH
        EAST -> SOUTH
    }
    fun previous() = when(this) {
        NORTH -> WEST
        WEST -> SOUTH
        SOUTH -> EAST
        EAST -> NORTH
    }
    fun toUnitVector() = when(this) {
        NORTH -> Vector2d(0,1)
        WEST -> Vector2d(-1,0)
        SOUTH -> Vector2d(0,-1)
        EAST -> Vector2d(1,0)
    }
}
