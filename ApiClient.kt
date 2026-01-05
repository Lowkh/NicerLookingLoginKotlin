package np.ict.mad.jsonapp

import android.util.Log
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody

object ApiClient {

    private val client = OkHttpClient()
    private val json = Json { ignoreUnknownKeys = true }
    private val mediaTypeJson = "application/json; charset=utf-8".toMediaType()

    // --- SIGNUP: POST /createuser ---
    fun createUser(username: String, password: String): LoginResponse {
        val bodyObj = Credentials(username = username, password = password)
        val bodyJson = json.encodeToString(bodyObj)
        val body = bodyJson.toRequestBody(mediaTypeJson)
        Log.d("Login", "username=$username, password=$password")

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/createuser")
            .post(body)
            .build()

        client.newCall(request).execute().use { response ->
            val respBody = response.body?.string() ?: """
                {"success":false,"message":"Empty response"}
            """.trimIndent()
            return json.decodeFromString(respBody)
        }
    }

    // --- LOGIN: POST /login ---
    fun login(username: String, password: String): LoginResponse {
        val bodyObj = Credentials(username = username, password = password)
        val bodyJson = json.encodeToString(bodyObj)
        val body = bodyJson.toRequestBody(mediaTypeJson)
        Log.d("Login", "username=$username, password=$password")

        val request = Request.Builder()
            .url("http://10.0.2.2:8080/login")
            .post(body)
            .build()

        client.newCall(request).execute().use { response ->
            val respBody = response.body?.string() ?: """
                {"success":false,"message":"Empty response"}
            """.trimIndent()
            return json.decodeFromString(respBody)
        }
    }
}
