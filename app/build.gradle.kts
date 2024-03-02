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
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.data)
    implementation(projects.feature.main)

}
