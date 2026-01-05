package np.ict.mad.jsonapp

import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("createuser")
    suspend fun createUser(
        @Body credentials: Credentials
    ): LoginResponse

    @POST("login")
    suspend fun login(
        @Body credentials: Credentials
    ): LoginResponse
}
