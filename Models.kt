package np.ict.mad.jsonapp

import kotlinx.serialization.Serializable

@Serializable
data class Credentials(
    val username: String,
    val password: String
)

@Serializable
data class LoginResponse(
    val success: Boolean,
    val message: String,
    val username: String? = null
)
