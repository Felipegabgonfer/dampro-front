package dam.aminfelipe.project.infraestructure.auth.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupDto(
    val dni: String,
    val user: String,
    @SerialName("contraseña")
    val password: String,
    val nombre: String
)
