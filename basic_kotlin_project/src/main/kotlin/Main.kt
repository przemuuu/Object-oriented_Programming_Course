import model.Animal
import model.BouncyMap
import model.MoveDirection
import model.Vector2d

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    val map = BouncyMap(5,5)
    val animal1 = Animal(position = Vector2d(3, 3))
    val animal2 = Animal(position = Vector2d(3, 3))
    map.place(animal1)
    map.place(animal2)
    println(map.objectAt(Vector2d(3, 3)))
    map.move(animal1,MoveDirection.FORWARD)
    println(map.objectAt(Vector2d(3, 3)))
    println(map.objectAt(Vector2d(3, 4)))
    val map2 = ArrayList<Animal>(map.getElements)
    println(map2[0].getPosition())
    println(map2[1].getPosition())
//    println("Program arguments: ${args.joinToString()}")
}