package tutorial.variables

// 1. Variables

// You can declare variables at the top level.
val pi = 3.14
var r = 0

fun main(args: Array<String>) {
    // Read-only local variables
    val a: Int = 1  // immediate assignment
    val b = 2       // `Int` type is inferred
    val c: Int      // Type required when no initializer is provided
    c = 3           // deferred assignment

    // Variables that can be re-assigned
    var x = 5       // `Int` type is inferred
    x += 1

    println("a = $a, b = $b, c = $c, x = $x")

    r = 7
    println("Circumference = " + 2 * pi * r)
}
