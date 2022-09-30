package br.com.phs.shared

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform