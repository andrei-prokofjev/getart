package com.apro.getart.metmuseum

import kotlinx.serialization.json.Json

val json = Json {
  ignoreUnknownKeys = true
  prettyPrint = true
  isLenient = true
}