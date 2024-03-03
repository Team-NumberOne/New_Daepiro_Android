plugins {
    alias(libs.plugins.daepiro.android.feature.compose)
}

android {
    namespace = "com.numberone.daepiro.feature.main"
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.login)
    implementation(projects.feature.funding)


}