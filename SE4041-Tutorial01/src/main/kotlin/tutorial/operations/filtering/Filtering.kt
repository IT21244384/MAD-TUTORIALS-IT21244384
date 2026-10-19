package tutorial.operations.filtering

// 7.1 Filtering
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    // Filter elements greater than 3
    val filteredNumbers = numbers.filter { it > 3 }
    println("Filtered Numbers: $filteredNumbers")
}
