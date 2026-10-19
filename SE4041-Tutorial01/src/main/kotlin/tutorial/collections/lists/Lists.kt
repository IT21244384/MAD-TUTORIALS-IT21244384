package tutorial.collections.lists

// 6.1 Lists
fun main() {
    // Immutable list
    val numbers = listOf(1, 2, 3, 4, 5)
    println("Immutable List: $numbers")

    // Mutable list
    val mutableNumbers = mutableListOf(1, 2, 3, 4, 5)
    mutableNumbers.add(6)
    println("Mutable List: $mutableNumbers")
}
