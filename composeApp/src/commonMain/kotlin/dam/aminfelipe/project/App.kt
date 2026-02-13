package dam.aminfelipe.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
                Text("Inicio de sesión válido.")
            }
        }
    }
}
