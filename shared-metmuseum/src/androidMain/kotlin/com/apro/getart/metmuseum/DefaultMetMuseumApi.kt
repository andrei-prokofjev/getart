package com.apro.getart.metmuseum

import com.apro.getart.metmuseum.model.DepartmentsResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

internal class DefaultMetMuseumApi constructor(
  private val client: HttpClient,
  private val json: Json,
  private val baseUrl: String,
) : MetMuseumApi {

  override suspend fun departments(): DepartmentsResponse {
    return client.get("${baseUrl}/public/collection/v1/departments").body()
  }
}