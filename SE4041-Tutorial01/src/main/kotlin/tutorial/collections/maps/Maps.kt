package tutorial.collections.maps

// 6.3 Maps
fun main() {
    // Immutable map
    val capitals = mapOf("USA" to "Washington D.C.", "UK" to "London", "India" to "New Delhi")
    println("Immutable Map: $capitals")

    // Mutable map
    val mutableCapitals = mutableMapOf("USA" to "Washington D.C.", "UK" to "London", "India" to "New Delhi")
    mutableCapitals["Germany"] = "Berlin"
    println("Mutable Map: $mutableCapitals")
}
