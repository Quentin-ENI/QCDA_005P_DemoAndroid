pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Module01Demonstration"
include(":app")
include(":Module02Demonstration")
include(":module04demo01")
include(":module04demo02")
include(":module05demo01")
include(":module05demo02")
include(":module05demo03")
include(":module05demo04")
include(":module06demo01")
include(":module06demo02")
include(":module06demo03")
include(":module07demo01")
