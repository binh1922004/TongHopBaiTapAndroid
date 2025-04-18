plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.hcmute"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.hcmute"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation(libs.volley)
    // Thư viện load image
    implementation(libs.glide)
    annotationProcessor(libs.compiler)

// Thư viện load dữ liệu API
    implementation(libs.volley)

// Thư viện circle images (bo góc tròn cho ImageView)
    implementation(libs.circleimageview)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}