package dev.hashnode.tusharpingale

import dev.hashnode.tusharpingale.models.Recipe
import io.ktor.server.application.*
import dev.hashnode.tusharpingale.plugins.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

val recipes = mutableListOf(
    Recipe(id = 1, name = "Butter Naan", description = "butter with naan", coverUrl = "https://abc.com")
)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}