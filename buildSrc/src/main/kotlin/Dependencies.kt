import java.text.SimpleDateFormat
import java.util.*

object Plugins{
    const val application = "com.android.application"
    const val android = "android"
    const val kapt = "kotlin-kapt"
    const val hilt = "dagger.hilt.android.plugin"

    const val check_update = "1.5.0"
    const val checkDependency = "name.remal.check-dependency-updates"
}

object BuildConfig {
    const val buildTools = "32.0.0"

    enum class Type {
        Debug,Release;

        override fun toString(): String = when(this){
            Debug -> "debug"
            Release -> "release"
        }
    }

    object Sdk {
        const val compile = 32
        const val min = 21
        const val target = 32
    }

    object App {
        const val name = "ComposeDemo"
        const val versionCode = 1
        const val versionName = "1.0.0"
        const val id = "com.example.composedemo"

        /*object Signature{
            const val keyAlias = ""
            const val password = ""
            const val path = "../key/key.jks"
        }*/
    }
}

object Libs {
    object Gradle {
        private const val version = "7.0.4"
        const val plugin = "com.android.tools.build:gradle:$version"
    }

    object Kotlin {
        private const val version = "1.5.31"
        const val plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        const val coroutines = "org.jetbrains.kotlin:kotlinx-coroutines-android:1.5.2"
    }

    object AndroidX{
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.2"
        const val nav = "androidx.navigation:navigation-compose:2.3.5"
        const val material = "com.google.android.material:material:1.4.0"

        object Compose{
            const val version = "1.0.5"
            const val ui = "androidx.compose.ui:ui:$version"
            const val material = "androidx.compose.material:material:$version"
            const val tooling = "androidx.compose.ui:ui-tooling:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0"
        }

        object Activity{
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
            const val activityKtx = "androidx.activity:activity-ktx:1.4.0"
        }

        object Fragment{
            const val fragmentKtx = "androidx.fragment:fragment-ktx:1.4.0"
        }
    }

    object Lifecycle{
        private const val version = "2.4.0"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"

        //optional - helpers for implementing LifecycleOwner in a Service
        const val service = "android.lifecycle:lifecycle-service:$version"
    }

    object Hilt{
        private const val version = "2.40.5"
        const val hilt = "com.google.dagger:hilt-android:$version"
        const val compiler ="com.google.dagger:hilt-android-compiler:$version"
        const val gradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:$version"
    }

    object Test{
        const val junit = "junit:junit:4.13.2"
        object Android{
            const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
            object Ext{
                const val junit = "androidx.test.ext:junit:1.1.3"
            }
        }
    }
}

fun releaseTime():String = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(System.currentTimeMillis())