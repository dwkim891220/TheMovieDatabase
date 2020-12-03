object Apps {
    const val applicationId = "pr.dwkim.themoviedatabase"
    const val compileSdk = 30
    const val targetSdk = 30
    const val minSdk = 26
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Versions {
    const val gradle = "4.1.1"
    const val kotlin = "1.4.20"
    const val googleService = "4.3.3"
    const val googlePlayPublisher = "2.8.0"
    const val firebaseCrashlyticsGradle = "2.0.0-beta04"

    const val hilt = "2.28-alpha"
    const val hiltViewModel = "1.0.0-alpha01"

    const val anko = "0.10.7"
    const val constraintLayout = "2.0.0-beta6"
    const val arch = "2.2.0"
    const val appcompat = "1.1.0"
    const val androidxCore = "1.3.2"
    const val androidxFragment = "1.2.5"
    const val androidxActivity = "1.1.0"
    const val recyclerView = "1.2.0-alpha02"
    const val swipeRefreshLayout = "1.0.0"
    const val material = "1.2.0-alpha05"
    const val webkit = "1.2.0"
    const val playServiceAds = "19.0.1"

    const val koin = "2.0.1"
    const val rxJava = "3.0.7"
    const val rxAndroid = "3.0.0"

    const val glide = "4.11.0"

    const val retrofit2 = "2.9.0"
    const val okhttp = "4.4.1"
    const val gson = "2.8.6"

    const val firebaseCore = "17.3.0"
    const val firebaseMessaging = "20.1.5"
    const val firebaseDynamicLink = "19.1.0"
    const val firebaseCrashlytics = "17.0.0-beta04"

    const val lottie = "3.4.0"
    const val exoplayer = "2.10.4"

    const val flexbox = "2.0.1"
    const val photoView = "2.3.0"
    const val adfit = "3.0.7"
    const val adsIdentifier = "1.0.0-alpha04"
    const val adsGuava = "28.2-jre"
    const val spotlight = "2.0.1"
}

object Libs {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val gradleHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val googlePlayPublisher = "com.github.triplet.gradle:play-publisher:${Versions.googlePlayPublisher}"
    const val firebaseCrashlyticsGradle = "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlyticsGradle}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel}"
    const val hiltViewModelCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltViewModel}"

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val ankoCommon = "org.jetbrains.anko:anko-commons:${Versions.anko}"
    const val ankoDesign = "org.jetbrains.anko:anko-design:${Versions.anko}"

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidXCoreKtx = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidXActivityKtx = "androidx.activity:activity-ktx:${Versions.androidxActivity}"
    const val androidXFragmentKtx = "androidx.fragment:fragment-ktx:${Versions.androidxFragment}"
    const val androidXLifeCycleLiveData = "androidx.lifecycle:lifecycle-livedata:${Versions.arch}"
    const val androidXLifeCycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.arch}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"
    const val webkit = "androidx.webkit:webkit:${Versions.webkit}"

    const val material = "com.google.android.material:material:${Versions.material}"
    const val playServiceAds = "com.google.android.gms:play-services-ads:${Versions.playServiceAds}"

    const val googleService = "com.google.gms:google-services:${Versions.googleService}"
    const val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    const val firebaseMessaging = "com.google.firebase:firebase-messaging:${Versions.firebaseMessaging}"
    const val firebaseDynamicLink = "com.google.firebase:firebase-dynamic-links:${Versions.firebaseDynamicLink}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics:${Versions.firebaseCrashlytics}"

    const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
    const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"

    const val koin = "org.koin:koin-android-viewmodel:${Versions.koin}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    const val retrofit2Gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
    const val retrofit2RxJava = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit2}"
    const val retrofit2Logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    const val exoPlayerCore = "com.google.android.exoplayer:exoplayer-core:${Versions.exoplayer}"
    const val exoPlayerUi = "com.google.android.exoplayer:exoplayer-ui:${Versions.exoplayer}"
    const val exoPlayerHls = "com.google.android.exoplayer:exoplayer-hls:${Versions.exoplayer}"

    const val flexbox = "com.google.android:flexbox:${Versions.flexbox}"
    const val photoView = "com.github.chrisbanes:PhotoView:${Versions.photoView}"
    const val adfit = "com.kakao.adfit:ads-base:${Versions.adfit}"
    const val adsIdentifier = "androidx.ads:ads-identifier:${Versions.adsIdentifier}"
    const val adsGuava = "com.google.guava:guava:${Versions.adsGuava}"
    const val spotlight = "com.github.takusemba:spotlight:${Versions.spotlight}"
}