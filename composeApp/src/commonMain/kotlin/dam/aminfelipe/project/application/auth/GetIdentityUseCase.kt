package dam.aminfelipe.project.application.auth

import dam.aminfelipe.project.infraestructure.auth.dto.UserIdentityDto
import dam.aminfelipe.project.model.auth.IAuthRepository

class GetIdentityUseCase(
    private val authRepository: IAuthRepository
) {
    suspend operator fun invoke(token: String): UserIdentityDto {
        return authRepository.me(token)
    }
}
