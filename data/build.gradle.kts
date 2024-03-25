import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.daepiro.android.library)
    alias(libs.plugins.daepiro.android.hilt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
//    alias(libs.plugins.protobuf)
}

fun getBaseUrl(propertyBaseUrl : String): String {
    return gradleLocalProperties(rootDir).getProperty(propertyBaseUrl)
}

android {
    namespace = "com.numberone.daepiro.data"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "BASE_URL", getBaseUrl("BASE_URL"))
    }

    buildFeatures {
        buildConfig = true
    }

    androidComponents {
        onVariants(selector().all()) { variant ->
            afterEvaluate {
                val variantName = variant.name.capitalize()
                val ksp = "ksp${variantName}Kotlin"
                val buildConfig = "generate${variantName}BuildConfig"

                val kspTask = project.tasks.findByName(ksp) as? org.jetbrains.kotlin.gradle.tasks.AbstractKotlinCompileTool<*>
                val buildConfigTask = project.tasks.findByName(buildConfig) as? com.android.build.gradle.tasks.GenerateBuildConfig

                kspTask?.run {
                    buildConfigTask?.let { setSource(it.sourceOutputDir) }
                }
            }
        }
    }
}

dependencies {
    implementation(projects.domain)

    implementation(libs.retrofit.core)
    implementation(libs.okhttp.logging)

    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.datastore.core)
    implementation(libs.androidx.datastore.preferences)

//    implementation(projects.core.android)

//    ksp(libs.room.compiler)

//    implementation(libs.protobuf.kotlin.lite)

//    ksp(libs.encrypted.datastore.preference.ksp)
//    implementation(libs.encrypted.datastore.preference.ksp.annotations)
//    implementation(libs.encrypted.datastore.preference.security)

//    implementation(libs.bundles.coroutine)
//    implementation(libs.kotlinx.datetime)

//    implementation(libs.junit)
//    implementation(libs.timber)
}