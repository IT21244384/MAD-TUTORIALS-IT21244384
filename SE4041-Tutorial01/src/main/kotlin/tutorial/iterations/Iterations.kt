package tutorial.iterations

// 4. Iterations
fun main() {
    val names = listOf("John", "Jane", "Tom", "Jack", "Anne", "Kane")
    var i = 0

    for (name in names) {
        println("Hello, $name")
    }

    for (index in names.indices) {
        println(index)
    }

    while (i < names.size) {
        println("name at $i is ${names[i]}")
        i++
    }
}
