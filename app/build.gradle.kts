plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Apps.compileSdk)
    defaultConfig {
        applicationId = Apps.applicationId
        minSdkVersion(Apps.minSdk)
        targetSdkVersion(Apps.targetSdk)
        versionCode = Apps.versionCode
        versionName = Apps.versionName
    }

    buildTypes {
        this.forEach { buildType ->
            buildType.buildConfigField("String", "ApiKey", "7c89f0483dfba44fb752ae6d50393fd0")
        }

        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.kotlin)
    implementation(Libs.ankoCommon)
    implementation(Libs.ankoDesign)
    implementation(Libs.appCompat)
    implementation(Libs.constraintLayout)
    implementation(Libs.recyclerView)
    implementation(Libs.swipeRefreshLayout)
    implementation(Libs.material)

    implementation(Libs.hilt)
    kapt(Libs.hiltCompiler)
    implementation(Libs.hiltViewModel)
    kapt(Libs.hiltViewModelCompiler)

    implementation(Libs.androidXCoreKtx)
    implementation(Libs.androidXLifeCycleLiveData)
    implementation(Libs.androidXLifeCycleExtension)

    implementation(Libs.rxJava)
    implementation(Libs.rxAndroid)

    implementation(Libs.glide)
    kapt(Libs.glideCompiler)

    implementation(Libs.retrofit2)
    implementation(Libs.retrofit2Gson)
    implementation(Libs.retrofit2RxJava)
    implementation(Libs.retrofit2Logging)
    implementation(Libs.gson)

    implementation(Libs.exoPlayerCore)
    implementation(Libs.exoPlayerUi)
    implementation(Libs.exoPlayerHls)
}