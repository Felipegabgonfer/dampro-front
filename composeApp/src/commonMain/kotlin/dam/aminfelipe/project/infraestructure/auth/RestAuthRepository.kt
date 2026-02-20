package dam.aminfelipe.project.infraestructure.auth

import dam.aminfelipe.project.infraestructure.auth.dto.LoginResponseDto
import dam.aminfelipe.project.infraestructure.auth.dto.SignupDto
import dam.aminfelipe.project.model.auth.IAuthRepository
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.forms.submitForm
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType
import dam.aminfelipe.project.infraestructure.auth.dto.UserIdentityDto
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.call.body


class RestAuthRepository(
    private val client: HttpClient,
    private val baseUrl: String
) : IAuthRepository {

    override suspend fun login(username: String, password: String): LoginResponseDto {
        val loginUrl = "${baseUrl.trimEnd('/')}/users/login/"

        val response = client.submitForm(
            url = loginUrl,
            formParameters = Parameters.build {
                append("grant_type", "password")
                append("username", username)
                append("password", password)
            }
        )

    return Json.decodeFromString<LoginResponseDto>(response.bodyAsText())
    }

    override suspend fun signup(signupDto: SignupDto) {
        val signupUrl = "${baseUrl.trimEnd('/')}/users/signup/"

        client.post(signupUrl) {
            contentType(ContentType.Application.Json)
            setBody(signupDto)
        }
    }

    override suspend fun me(token: String): UserIdentityDto {
        val url = "${baseUrl.trimEnd('/')}/users/me/"
        val response = client.get(url) {
            header("Authorization", "Bearer $token")
        }

    return Json.decodeFromString<UserIdentityDto>(response.bodyAsText())
    }
}
