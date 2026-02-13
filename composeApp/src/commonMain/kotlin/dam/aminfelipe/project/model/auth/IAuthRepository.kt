package dam.aminfelipe.project.model.auth

import dam.aminfelipe.project.infraestructure.auth.dto.LoginResponseDto
import dam.aminfelipe.project.infraestructure.auth.dto.SignupDto

interface IAuthRepository {
    suspend fun login(username: String, password: String): LoginResponseDto
    suspend fun signup(signupDto: SignupDto)
}
