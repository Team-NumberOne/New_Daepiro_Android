import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.build.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "daepiro.application"
            implementationClass = "plugins.AndroidApplicationComposeConventionPlugin"
        }
        register("androidKotlin"){
            id = "daepiro.kotlin.android"
            implementationClass = "plugins.AndroidKotlinConventionPlugin"
        }
        register("androidHilt") {
            id = "daepiro.hilt"
            implementationClass = "plugins.AndroidHiltConventionPlugin"
        }
        register("androidLibrary"){
            id = "daepiro.library"
            implementationClass = "plugins.AndroidLibraryComposeConventionPlugin"
        }
    }
}