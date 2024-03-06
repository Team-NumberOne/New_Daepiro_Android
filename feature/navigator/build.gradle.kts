plugins {
    alias(libs.plugins.daepiro.android.feature.compose)
}

android {
    namespace = "com.numberone.daepiro.feature.navigator"
}

dependencies {
    implementation(projects.feature.home)
    implementation(projects.feature.community)
    implementation(projects.feature.family)
    implementation(projects.feature.funding)
    implementation(projects.feature.mypage)


}