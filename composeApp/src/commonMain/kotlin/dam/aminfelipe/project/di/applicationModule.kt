package dam.aminfelipe.project.di

import dam.aminfelipe.project.application.auth.LoginUseCase
import dam.aminfelipe.project.application.auth.SignupUseCase
import org.koin.dsl.module

val applicationModule = module {
    factory { LoginUseCase(get()) }
    factory { SignupUseCase(get()) }
}
