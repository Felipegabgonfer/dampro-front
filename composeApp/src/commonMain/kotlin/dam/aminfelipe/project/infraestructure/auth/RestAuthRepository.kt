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
import io.ktor.http.ContentType
import io.ktor.http.Parameters
import io.ktor.http.contentType

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

        return Json.decodeFromString(response.bodyAsText())
    }

    override suspend fun signup(signupDto: SignupDto) {
        val signupUrl = "${baseUrl.trimEnd('/')}/users/signup/"

        client.post(signupUrl) {
            contentType(ContentType.Application.Json)
            setBody(signupDto)
        }
    }
}
