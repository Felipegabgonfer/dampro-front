package dam.aminfelipe.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import dam.aminfelipe.project.di.applicationModule
import dam.aminfelipe.project.di.domainModule
import dam.aminfelipe.project.di.infraestructureModule
import dam.aminfelipe.project.di.presentationModule
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(
            applicationModule,
            domainModule,
            infraestructureModule,
            presentationModule
        )
    }

    Window(
        onCloseRequest = ::exitApplication,
        title = "dampro-front",
    ) {
        App()
    }
}
