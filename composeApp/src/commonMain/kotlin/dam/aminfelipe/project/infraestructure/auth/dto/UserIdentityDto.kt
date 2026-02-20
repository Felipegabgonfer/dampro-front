package dam.aminfelipe.project.infraestructure.auth.dto

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class UserIdentityDto(
    val dni: String,
    val user: String,
    val nombre: String,
    val roles: List<String>
)
