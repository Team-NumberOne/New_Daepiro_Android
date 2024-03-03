import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

@Suppress("UNUSED")
internal class FeatureComposeConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("daepiro.android.library")
                apply("daepiro.android.library.compose")
                apply("daepiro.android.hilt")
            }

            dependencies {
//                "implementation"(project(":core:model"))
//                "implementation"(project(":core:ui"))
                "implementation"(project(":core:designsystem"))
//                "implementation"(project(":core:android"))
                "implementation"(project(":domain"))

//                "implementation"(libs.findLibrary("kotlinx.immutable").get())
//                "implementation"(libs.findLibrary("kotlinx.datetime").get())
                "implementation"(libs.findLibrary("kotlinx.coroutines.android").get())
                "implementation"(libs.findLibrary("kotlinx.coroutines.core").get())

//                "implementation"(platform(libs.findLibrary("firebase.bom").get()))
//                "implementation"(libs.findLibrary("firebase.analytics").get())

//                "androidTestImplementation"(libs.findLibrary("junit").get())
//                "implementation"(libs.findLibrary("timber").get())
            }
        }
    }
}