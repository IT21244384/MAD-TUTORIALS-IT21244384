# SE4041 – Mobile Application Design and Development
## 2025 Tutorial 01 – Kotlin basics (SLIIT, Faculty of Computing)

Every code sample from the tutorial sheet is here as a runnable Kotlin file,
one package per section, each with its own `main`.

| Tutorial section | File | Main class |
|---|---|---|
| Intro to basic syntax | `intro/Intro.kt` | `tutorial.intro.IntroKt` |
| 1. Variables | `variables/Variables.kt` | `tutorial.variables.VariablesKt` |
| 2. Functions | `functions/Functions.kt` | `tutorial.functions.FunctionsKt` |
| 3. Conditional expressions | `conditionals/Conditionals.kt` | `tutorial.conditionals.ConditionalsKt` |
| 4. Iterations | `iterations/Iterations.kt` | `tutorial.iterations.IterationsKt` |
| 5. When expression | `whenexpr/WhenExpression.kt` | `tutorial.whenexpr.WhenExpressionKt` |
| 6. Collections | `collections/Collections.kt` | `tutorial.collections.CollectionsKt` |
| 6.1 Lists | `collections/lists/Lists.kt` | `tutorial.collections.lists.ListsKt` |
| 6.2 Sets | `collections/sets/Sets.kt` | `tutorial.collections.sets.SetsKt` |
| 6.3 Maps | `collections/maps/Maps.kt` | `tutorial.collections.maps.MapsKt` |
| 7.1 Filtering | `operations/filtering/Filtering.kt` | `tutorial.operations.filtering.FilteringKt` |
| 7.2 Mapping | `operations/mapping/Mapping.kt` | `tutorial.operations.mapping.MappingKt` |
| 7.3 Sorting | `operations/sorting/Sorting.kt` | `tutorial.operations.sorting.SortingKt` |
| 7.4 Grouping | `operations/grouping/Grouping.kt` | `tutorial.operations.grouping.GroupingKt` |
| OOP 1. Classes & instances | `oop/classes/Classes.kt` | `tutorial.oop.classes.ClassesKt` |
| OOP 2. Inheritance | `oop/inheritance/Inheritance.kt` | `tutorial.oop.inheritance.InheritanceKt` |

All sources are under `src/main/kotlin/tutorial/`.

## Run it

**IntelliJ IDEA (easiest):** File ▸ Open ▸ select this folder (import as a Gradle project, JDK 17+).
Open any file and click the green ▶ beside `fun main`.

**Command line** (needs JDK 17+ and Gradle installed):

```
gradle run                                              # runs every section in order
gradle run -PmainClass=tutorial.variables.VariablesKt   # runs one section
```

IntelliJ also generates a Gradle wrapper for you if you prefer `gradlew`.
The first build needs internet to download the Kotlin plugin.

## Notes on the code

- Several sections define top-level `val pi` / `var r` / `fun main`. Kotlin does not allow
  duplicates in one package, so each section lives in its own package.
- Code was copied from the PDF faithfully; only PDF line-wrapping artefacts were fixed
  (strings broken across lines, `->` shown as `–>`, curly quotes).
- Reference: https://kotlinlang.org/docs/classes.html
