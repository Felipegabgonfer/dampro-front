package dam.aminfelipe.project

import androidx.compose.material3.MaterialTheme
import dam.aminfelipe.project.ui.RootScreen
import dam.aminfelipe.project.ui.DirectorScreen
import dam.aminfelipe.project.ui.TeacherScreen
import dam.aminfelipe.project.ui.StudentScreen
import dam.aminfelipe.project.infraestructure.auth.dto.UserIdentityDto
import androidx.compose.runtime.*
import dam.aminfelipe.project.ui.auth.AuthViewModel
import dam.aminfelipe.project.ui.auth.LoginScreen
import dam.aminfelipe.project.ui.auth.SignupScreen
import org.koin.compose.getKoin

@Composable
fun App() {
    MaterialTheme {
        val viewModel: AuthViewModel = getKoin().get()

        var screen by remember { mutableStateOf("login") }

    val identity: UserIdentityDto? = viewModel.identity

        fun roleScreenFor(identity: UserIdentityDto?): String {
            val roles = identity?.roles ?: emptyList()
            return when {
                roles.contains("root") -> "root"
                roles.contains("directivo") -> "directivo"
                roles.contains("profesor") -> "profesor"
                else -> "estudiante"
            }
        }

        when (screen) {
            "login" -> LoginScreen(
                viewModel = viewModel,
                onGoToSignup = { screen = "signup" },
                onLoginSuccess = { screen = "home" }
            )

            "signup" -> SignupScreen(
                viewModel = viewModel,
                onBackToLogin = { screen = "login" }
            )

            "home" -> {
                when (roleScreenFor(identity)) {
                    "root" -> RootScreen()
                    "directivo" -> DirectorScreen()
                    "profesor" -> TeacherScreen()
                    else -> StudentScreen()
                }
            }
        }
    }
}
