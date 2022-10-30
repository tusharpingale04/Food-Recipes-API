package dev.hashnode.tusharpingale.plugins

import dev.hashnode.tusharpingale.routes.addRecipe
import dev.hashnode.tusharpingale.routes.deleteRecipe
import dev.hashnode.tusharpingale.routes.getAllRecipes
import dev.hashnode.tusharpingale.routes.getRecipe
import io.ktor.server.routing.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        route("/recipes") {
            addRecipe()
            getRecipe()
            getAllRecipes()
            deleteRecipe()
        }
    }
}
