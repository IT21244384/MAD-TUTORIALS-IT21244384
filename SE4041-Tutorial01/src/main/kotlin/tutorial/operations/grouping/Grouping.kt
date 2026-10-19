package tutorial.operations.grouping

// 7.4 Grouping
fun main() {
    val names = listOf("Alice", "Bob", "Charlie", "Anna")
    // Group names by their first letter
    val groupedNames = names.groupBy { it.first() }
    println("Grouped Names: $groupedNames")
}
