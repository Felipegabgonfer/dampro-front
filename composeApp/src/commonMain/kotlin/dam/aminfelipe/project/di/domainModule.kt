package dam.aminfelipe.project.di

import dam.aminfelipe.project.infraestructure.auth.RestAuthRepository
import dam.aminfelipe.project.model.auth.IAuthRepository
import org.koin.dsl.module

val domainModule = module {
    single<IAuthRepository> {
        RestAuthRepository(
            baseUrl = "http://localhost:8000/",
            client = get()
        )
    }
}
