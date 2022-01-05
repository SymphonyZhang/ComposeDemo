buildscript{
    repositories{
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Libs.Gradle.plugin)
        classpath(Libs.Kotlin.plugin)
        classpath(Libs.Hilt.gradlePlugin)
    }
}
tasks.register("clean",Delete::class){
    setDelete(rootProject.buildDir)
}
