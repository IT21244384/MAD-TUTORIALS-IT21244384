package tutorial

import tutorial.collections.lists.main as listsMain
import tutorial.collections.main as collectionsMain
import tutorial.collections.maps.main as mapsMain
import tutorial.collections.sets.main as setsMain
import tutorial.conditionals.main as conditionalsMain
import tutorial.functions.main as functionsMain
import tutorial.intro.main as introMain
import tutorial.iterations.main as iterationsMain
import tutorial.oop.classes.main as classesMain
import tutorial.oop.inheritance.main as inheritanceMain
import tutorial.operations.filtering.main as filteringMain
import tutorial.operations.grouping.main as groupingMain
import tutorial.operations.mapping.main as mappingMain
import tutorial.operations.sorting.main as sortingMain
import tutorial.variables.main as variablesMain
import tutorial.whenexpr.main as whenMain

private fun section(title: String, body: () -> Unit) {
    println("\n=== $title ===")
    body()
}

/** Runs every section of Tutorial 01 in order. */
fun main() {
    val noArgs = emptyArray<String>()
    section("Introduction") { introMain(noArgs) }
    section("1. Variables") { variablesMain(noArgs) }
    section("2. Functions") { functionsMain(noArgs) }
    section("3. Conditional Expressions") { conditionalsMain() }
    section("4. Iterations") { iterationsMain() }
    section("5. When expression") { whenMain() }
    section("6. Collections") { collectionsMain() }
    section("6.1 Lists") { listsMain() }
    section("6.2 Sets") { setsMain() }
    section("6.3 Maps") { mapsMain() }
    section("7.1 Filtering") { filteringMain() }
    section("7.2 Mapping") { mappingMain() }
    section("7.3 Sorting") { sortingMain() }
    section("7.4 Grouping") { groupingMain() }
    section("OOP 1. Classes and instances") { classesMain() }
    section("OOP 2. Inheritance") { inheritanceMain() }
}
