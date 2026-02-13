package dam.aminfelipe.project.di

import dam.aminfelipe.project.ui.auth.AuthViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory {
        AuthViewModel(
            loginUseCase = get(),
            signupUseCase = get()
        )
    }
}
