package dam.aminfelipe.project.ui.auth

import androidx.compose.runtime.*
import dam.aminfelipe.project.application.auth.LoginUseCase
import dam.aminfelipe.project.application.auth.SignupUseCase
import io.ktor.client.plugins.*

class AuthViewModel(
    private val loginUseCase: LoginUseCase,
    private val signupUseCase: SignupUseCase
) {

    var isLoading by mutableStateOf(false)
        private set

    var token by mutableStateOf<String?>(null)
        private set

    var signupSuccess by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    suspend fun login(user: String, password: String) {
        isLoading = true
        error = null

        try {
            val result = loginUseCase(user, password)
            token = result.accessToken
        } catch (e: ResponseException) {
            val status = e.response.status.value
            error = when (status) {
                401, 404 -> "Contraseña incorrecta"
                else -> "Error del servidor: $status"
            }
        } catch (e: Exception) {
            error = e.message ?: "Error desconocido"
        } finally {
            isLoading = false
        }
    }

    suspend fun signup(dni: String, nombre: String, user: String, password: String) {
        isLoading = true
        error = null
        signupSuccess = false

        signupUseCase(dni, nombre, user, password)
        signupSuccess = true

        isLoading = false
    }
}
