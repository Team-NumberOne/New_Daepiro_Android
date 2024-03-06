enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Daepiro"

include(":app")
include(":core:designsystem")
include(":domain")
include(":data")
include(":feature:navigator")
include(":feature:home")
include(":feature:community")
include(":feature:family")
include(":feature:funding")
include(":feature:mypage")
include(":feature:login")
