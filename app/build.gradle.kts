plugins {
  id("com.android.application")
  kotlin("android")
  kotlin("kapt")
}

android {
  namespace = "com.apronet.getart"
  compileSdk = buildConfig.versions.compileSdk.get()
    .toInt()

  defaultConfig {
    minSdk = buildConfig.versions.minSdk.get()
      .toInt()
    targetSdk = buildConfig.versions.targetSdk.get()
      .toInt()
  }

//    buildTypes {
//        release {
//            minifyEnabled = false
//            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
//        }
//    }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
//    kotlinOptions {
//        jvmTarget = "1.8"
//    }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.1.1"
  }
//    packagingOptions {
//        resources {
//            excludes += '/META-INF/{AL2.0,LGPL2.1}'
//        }
//    }
}

dependencies {
  implementation(libs.androidx.ktx)
  implementation(libs.androidx.lifecycle)
  implementation(libs.androidx.activity)
  implementation(libs.androidx.ui)
  implementation(libs.androidx.preview)
  implementation(libs.androidx.material3)

}