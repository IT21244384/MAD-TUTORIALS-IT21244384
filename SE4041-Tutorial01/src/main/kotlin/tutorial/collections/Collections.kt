package tutorial.collections

// 6. Collections
fun main() {
    // Lists
    val numbers = listOf(1, 2, 3, 4, 5)
    println("List: $numbers")

    // Sets
    val uniqueNumbers = setOf(1, 2, 3, 2, 4, 5)
    println("Set: $uniqueNumbers")

    // Maps
    val capitals = mapOf("USA" to "Washington D.C.", "UK" to "London", "India" to "New Delhi")
    println("Capitals: $capitals")
}
