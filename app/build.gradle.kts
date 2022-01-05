plugins {
    id(Plugins.application)
    kotlin(Plugins.android)
    id(Plugins.kapt)
    id(Plugins.checkDependency) version Plugins.check_update
}

android {
    compileSdk = BuildConfig.Sdk.compile
    buildToolsVersion = BuildConfig.buildTools

    lint {
        isCheckDependencies = true
    }

    defaultConfig {
        applicationId = BuildConfig.App.id
        minSdk = BuildConfig.Sdk.min
        targetSdk = BuildConfig.Sdk.target
        versionCode = BuildConfig.App.versionCode
        versionName = BuildConfig.App.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    /*signingConfigs {
        create(BuildConfig.Type.Release.toString()){
            keyAlias = BuildConfig.App.Signature.keyAlias
            storeFile = file(BuildConfig.App.Signature.path)
            storePassword = BuildConfig.App.Signature.password
            keyPassword = BuildConfig.App.Signature.password
        }
        getByName(BuildConfig.Type.Debug.toString()){
            keyAlias = BuildConfig.App.Signature.keyAlias
            storeFile = file(BuildConfig.App.Signature.path)
            storePassword = BuildConfig.App.Signature.password
            keyPassword = BuildConfig.App.Signature.password
        }
    }*/

    buildTypes {
        getByName(BuildConfig.Type.Release.toString()) {
            isMinifyEnabled = false
            //signingConfig = signingConfigs.getByName(BuildConfig.Type.Release.toString())
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName(BuildConfig.Type.Debug.toString()) {
            //signingConfig = signingConfigs.getByName(BuildConfig.Type.Debug.toString())
        }
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_11)
        targetCompatibility(JavaVersion.VERSION_11)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    sourceSets.getByName("main"){
        java.srcDirs("src/main/kotlin")
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    applicationVariants.all{
        outputs.map { it as com.android.build.gradle.internal.api.BaseVariantOutputImpl }.forEach {
            it.outputFileName = "${BuildConfig.App.name}-${BuildConfig.App.versionName}-${buildType.name}_${releaseTime()}.apk"
        }
    }
}

dependencies {
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.Compose.ui)
    implementation(Libs.AndroidX.Compose.material)
    implementation(Libs.AndroidX.Compose.tooling)
    implementation(Libs.AndroidX.Compose.toolingPreview)
    implementation(Libs.Lifecycle.runtime)
    implementation(Libs.AndroidX.Activity.activityCompose)
    androidTestImplementation(Libs.Test.Android.Ext.junit)
    androidTestImplementation(Libs.Test.Android.espressoCore)
    androidTestImplementation(Libs.AndroidX.Compose.uiTest)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.compiler)
    testImplementation(Libs.Test.junit)
}