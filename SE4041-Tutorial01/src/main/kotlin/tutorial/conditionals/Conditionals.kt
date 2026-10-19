package tutorial.conditionals

// 3. Conditional Expressions
var r = 0

fun main() {
    r = 7
    if (r > 5) {
        println("r is greater than 5")
    } else {
        println("r is less than 5")
    }
    // if as a single-line statement
    if (r < 5) print("a") else print("b")
    println()
}
