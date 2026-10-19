package tutorial.functions

// 2. Functions
val pi = 3.14
var r = 0

fun main(args: Array<String>) {
    r = 7
    println("Circumference = " + 2 * pi * r)
    println("Area is " + calculateArea(10.0))
}

fun calculateArea(r: Double): Double {
    return pi * r * r
}
