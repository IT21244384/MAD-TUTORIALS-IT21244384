package tutorial.whenexpr

// 5. When expression in Kotlin
fun main() {
    println(whatIs(1))
    println(whatIs(10))
    println(whatIs(9223372036854775800))
    println(whatIs("Hello"))
    println(whatIs(5.0))
}

fun whatIs(obj: Any): String =
    when (obj) {
        1 -> "one"
        "Hello" -> "Greetings"
        is Long -> "Long"
        !is String -> "not a string"
        else -> "Unknown"
    }
