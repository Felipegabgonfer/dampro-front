package dam.aminfelipe.project.di

import dam.aminfelipe.project.ui.auth.AuthViewModel
import org.koin.dsl.module

val presentationModule = module {
    single {
        AuthViewModel(
            loginUseCase = get(),
            signupUseCase = get(),
            getIdentityUseCase = get()
        )
    }
}
