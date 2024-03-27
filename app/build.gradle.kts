plugins {
    alias(libs.plugins.daepiro.android.application)
    alias(libs.plugins.daepiro.android.hilt)
}

android {
    namespace = "com.numberone.daepiro"

    defaultConfig {
        applicationId = "com.numberone.daepiro"
        versionCode = 1
        versionName = "1.0.0"

        manifestPlaceholders["kakaoNativeAppKey"] = "kakao${getLocalProperties("KAKAO_NATIVE_APP_KEY")}"
        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", getLocalProperties("KAKAO_NATIVE_APP_KEY"))
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.feature.navigator)

    implementation(libs.kakao.sdk.user)

    implementation(libs.slack.api)

}

fun getLocalProperties(propertyKey: String): String {
    return com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir).getProperty(propertyKey)
}