package dam.aminfelipe.project.application.auth

import dam.aminfelipe.project.infraestructure.auth.dto.SignupDto
import dam.aminfelipe.project.model.auth.IAuthRepository

class SignupUseCase(
    private val repository: IAuthRepository
) {
    suspend operator fun invoke(dni: String, nombre: String, user: String, password: String
    ) {
        repository.signup(
            SignupDto(
                dni = dni,
                nombre = nombre,
                user = user,
                password = password
            )
        )
    }
}
