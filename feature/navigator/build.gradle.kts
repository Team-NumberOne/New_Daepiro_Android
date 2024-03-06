plugins {
    alias(libs.plugins.daepiro.android.feature.compose)
}

android {
    namespace = "com.numberone.daepiro.feature.navigator"
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.login)
    implementation(projects.feature.funding)


}