plugins {
    alias(libs.plugins.daepiro.java.library)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.hilt.core)

    implementation(libs.kotlinx.datetime)
}