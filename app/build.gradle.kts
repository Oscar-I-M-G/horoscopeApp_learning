plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

    // seguro navigation
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.oimg.horoscapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.oimg.horoscapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            resValue("string","ivanname","HoroscApp")
            buildConfigField("String","BASE_URL","\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            resValue("string","ivanname","[DEBUG] HoroscApp")
            isDebuggable = true
            buildConfigField("String","BASE_URL","\"https://newastro-debug.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }


    buildFeatures{
        viewBinding = true
        buildConfig = true
    }


}

dependencies {
    /**
     * Agregadas
     * */
    //buena practica
    val navVersion= "2.7.1"
    val dagVersion = "2.48"
    val retfitVersion = "2.9.0"

    //  Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retfitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retfitVersion")
    implementation("com.squareup.okhttp3:logging-interceptor:4.3.1")

    //  Nav Component
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //  DaggerHilt
    implementation("com.google.dagger:hilt-android:$dagVersion")
    kapt("com.google.dagger:hilt-compiler:$dagVersion")

    //  Extra
    implementation("androidx.core:core-ktx:1.9.0")




    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}