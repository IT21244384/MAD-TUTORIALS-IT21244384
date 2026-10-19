package tutorial.collections.sets

// 6.2 Sets
fun main() {
    // Immutable set
    val uniqueNumbers = setOf(1, 2, 3, 2, 4, 5)
    println("Immutable Set: $uniqueNumbers")

    // Mutable set
    val mutableUniqueNumbers = mutableSetOf(1, 2, 3, 2, 4, 5)
    mutableUniqueNumbers.add(6)
    println("Mutable Set: $mutableUniqueNumbers")
}
