plugins {
    kotlin("jvm") version "2.0.21"
    application
}

repositories {
    mavenCentral()
}

// Run any single section with:  gradlew run -PmainClass=tutorial.variables.VariablesKt
// With no argument it runs every section in order (tutorial.RunAllKt).
application {
    mainClass.set(
        (project.findProperty("mainClass") as String?) ?: "tutorial.RunAllKt"
    )
}
