package com.apro.getart.metmuseum

import android.util.Log
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*

class DefaultMetMuseum private constructor(
    baseUrl: String,
    logLevel: LogLevel,
) : MetMuseum {

    override val api: MetMuseumApi

    init {
        val client = HttpClient {
            expectSuccess = true
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("HttpClient", message)
                    }
                }
                level = logLevel
            }
            install(ContentNegotiation) {
                json(json)
            }
            install(HttpRequestRetry) {
                retryOnServerErrors(maxRetries = 3)
                retryOnExceptionIf { _, _ -> false }
                delayMillis { retry -> retry * 2000L }
            }

        }
        api = DefaultMetMuseumApi(
            client = client,
            json = json,
            baseUrl = baseUrl
        )
    }

    class Builder {
        private var baseUrl: String? = null
        private var logLevel: LogLevel = LogLevel.NONE

        fun baseUrl(baseUrl: String): Builder {
            this.baseUrl = baseUrl
            return this
        }

        fun logLevel(logLevel: LogLevel): Builder {
            this.logLevel = logLevel
            return this
        }

        fun build(): MetMuseum {
            return DefaultMetMuseum(
                requireNotNull(baseUrl),
                logLevel,
            )
        }
    }
}