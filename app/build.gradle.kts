import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin") // added plugin for secrets management
}

android {
    namespace = "com.example.touristguide"
    compileSdk = 34


    defaultConfig {
        applicationId = "com.example.touristguide"
        minSdk = 24  // updated to match the minSdk from the second code
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"


        val secretsProperties = Properties()
        val secretsFile = rootProject.file("secrets.properties")
        if (secretsFile.exists()) {
            secretsFile.inputStream().use { secretsProperties.load(it) }
        }

        // Set Google Maps API key as a build config field
        buildConfigField("String", "GOOGLE_MAPS_API_KEY", "\"${secretsProperties.getProperty("GOOGLE_MAPS_API_KEY")}\"")

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true // added viewBinding as in the second code
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation("com.google.android.gms:play-services-maps:18.1.0") // direct map services dependency

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
