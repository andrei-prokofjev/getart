plugins {
  kotlin("multiplatform")
  kotlin("native.cocoapods")
  id("com.android.library")
  kotlin("plugin.serialization") version "1.7.10"
}

version = "1.0"

val ktorVersion = "2.1.1"

kotlin {
  android()


  sourceSets {
    val androidMain by getting {
      dependencies {

        implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
        implementation(libs.ktor.client)
        api(libs.ktor.logging)
        implementation(libs.ktor.auth)
        implementation(libs.ktor.negotiation)
        implementation(libs.ktor.json)
        implementation(libs.kotlinx.datetime)
        //implementation(libs.russhwolf.settings)
      }
    }
  }
}

android {
  namespace = "com.apro.getart.metmuseum"
  compileSdk = buildConfig.versions.compileSdk.get().toInt()
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = buildConfig.versions.minSdk.get().toInt()
    targetSdk = buildConfig.versions.targetSdk.get().toInt()
  }

  buildTypes {
    release {
      isMinifyEnabled = true
    }
  }
}