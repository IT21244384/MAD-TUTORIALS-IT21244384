package tutorial.oop.classes

// OOP 1. Creating classes and instances
fun main() {
    val student = Person("John Smith")
}

class Person(name: String) {
    val name = "Name is $name".also(::println)

    init {
        println("First initializer block that prints the $name")
    }

    val nameSize = "name size is ${name.length}".also(::println)

    init {
        println("Second initializer block that prints the ${name.length}")
    }
}
