package dam.aminfelipe.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform