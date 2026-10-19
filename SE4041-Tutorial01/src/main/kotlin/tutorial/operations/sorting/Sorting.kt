package tutorial.operations.sorting

// 7.3 Sorting
fun main() {
    val numbers = listOf(5, 2, 8, 1, 4)
    // Sort in ascending order
    val sortedNumbers = numbers.sorted()
    println("Sorted Numbers: $sortedNumbers")
    // Sort in descending order
    val descendingNumbers = numbers.sortedDescending()
    println("Descending Numbers: $descendingNumbers")
}
