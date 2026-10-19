package tutorial.operations.mapping

// 7.2 Mapping
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5)
    // Square each element
    val squaredNumbers = numbers.map { it * it }
    println("Squared Numbers: $squaredNumbers")
}
