package tutorial.oop.inheritance

// OOP 2. Inheritance
fun main() {
    val square1 = Rectangle(4.0, 4.0)
    println(square1.perimeter)
}

open class Shape

class Rectangle(var length: Double, var width: Double) : Shape() {
    var perimeter: Double = (length + width) * 2
}
