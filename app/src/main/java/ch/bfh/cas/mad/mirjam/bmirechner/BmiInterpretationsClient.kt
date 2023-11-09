package ch.bfh.cas.mad.mirjam.bmirechner

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking

object BmiInterpretationsClient {

    fun getAllBmiInterpretationsBlocking(): List<String> = runBlocking {
        getAllBmiInterpretations()
    }

    suspend fun getAllBmiInterpretations(): List<String> =
        createClient().use { client ->
            client
                .get("https://mocki.io/v1/70e0bd6a-4163-4692-9fd3-31cac0cba85b")
                .body()
        }


    private fun createClient(): HttpClient =
        HttpClient(CIO) {
            install(ContentNegotiation) {
                json()
            }
        }
}