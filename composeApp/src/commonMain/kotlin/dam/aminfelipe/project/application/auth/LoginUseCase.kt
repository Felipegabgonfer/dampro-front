package dam.aminfelipe.project.application.auth

import dam.aminfelipe.project.infraestructure.auth.dto.LoginResponseDto
import dam.aminfelipe.project.model.auth.IAuthRepository

class LoginUseCase(
    private val authRepository: IAuthRepository
) {
    suspend operator fun invoke(username: String, password: String): LoginResponseDto {
        return authRepository.login(username, password)
    }
}
