package model;

data class Vector2d(val x: Int, val y: Int) {
    infix fun follows(other: Vector2d) = (x >= other.x && y >= other.y)
    infix fun precedes(other: Vector2d) = (x <= other.x && y <= other.y)

    fun upperRight(other: Vector2d) = (Vector2d(maxOf(x,other.x),maxOf(y,other.y)))
    fun lowerLeft(other: Vector2d) = (Vector2d(minOf(x,other.x),minOf(y,other.y)))

    operator fun plus(other: Vector2d) = (Vector2d(x+other.x,y+other.y))
    operator fun minus(other: Vector2d) = (Vector2d(x-other.x,y-other.y))

    fun opposite() = (Vector2d(y,x))

    override fun toString() = ("($x,$y)")
}
