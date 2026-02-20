package dam.aminfelipe.project.model.auth

import dam.aminfelipe.project.infraestructure.auth.dto.LoginResponseDto
import dam.aminfelipe.project.infraestructure.auth.dto.SignupDto
import dam.aminfelipe.project.infraestructure.auth.dto.UserIdentityDto

interface IAuthRepository {
    suspend fun login(username: String, password: String): LoginResponseDto
    suspend fun signup(signupDto: SignupDto)
    suspend fun me(token: String): UserIdentityDto
}
