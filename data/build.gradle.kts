plugins {
    alias(libs.plugins.daepiro.android.library)
    alias(libs.plugins.daepiro.android.hilt)
//    alias(libs.plugins.kotlin.serialization)
//    alias(libs.plugins.ksp)
//    alias(libs.plugins.protobuf)
}

android {
    namespace = "com.numberone.daepiro.data"
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

//protobuf {
//    protoc {
//        artifact = libs.protobuf.protoc.get().toString()
//    }
//    generateProtoTasks {
//        all().forEach { task ->
//            task.builtins {
//                register("java") {
//                    option("lite")
//                }
//            }
//        }
//    }
//}

dependencies {
//    implementation(projects.core.model)
    implementation(projects.domain)
//    implementation(projects.core.android)

//    ksp(libs.room.compiler)
//    implementation(libs.room.runtime)
//    implementation(libs.room.ktx)

//    implementation(libs.androidx.datastore.core)
//    implementation(libs.androidx.datastore.preferences)
//    implementation(libs.protobuf.kotlin.lite)

//    ksp(libs.encrypted.datastore.preference.ksp)
//    implementation(libs.encrypted.datastore.preference.ksp.annotations)
//    implementation(libs.encrypted.datastore.preference.security)

//    implementation(libs.bundles.coroutine)
//    implementation(libs.kotlinx.serialization.json)
//    implementation(libs.kotlinx.datetime)

//    implementation(libs.retrofit.core)
//    implementation(libs.retrofit.kotlin.serialization)
//    implementation(libs.okhttp.logging)

//    implementation(libs.junit)
//    implementation(libs.timber)
}