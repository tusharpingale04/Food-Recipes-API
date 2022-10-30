package dev.hashnode.tusharpingale.routes

import dev.hashnode.tusharpingale.models.Recipe
import dev.hashnode.tusharpingale.recipes
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.addRecipe() {
    post {
        val recipe = call.receive<Recipe>()
        recipes.add(recipe)
        call.respond(HttpStatusCode.Created, "Recipe saved")
    }
}

fun Route.getRecipe() {
    get("{id}") {
        val id = call.parameters["id"]?.toLong()
        val recipe = recipes.find { it.id == id }
        recipe?.let {
            call.respond(HttpStatusCode.Found, it)
        } ?: call.respond(HttpStatusCode.NotFound, "No recipe found with id $id")

    }
}

fun Route.getAllRecipes() {
    get {
        if (recipes.isNotEmpty())
            call.respond(HttpStatusCode.OK, recipes)
        else
            call.respond(HttpStatusCode.NotFound, "No recipes found")
    }
}

fun Route.deleteRecipe() {
    delete("{id}") {
        val id = call.parameters["id"]?.toLong() ?: return@delete call.respond(
            HttpStatusCode.BadRequest,
            "Recipe id required"
        )
        if (recipes.removeIf { it.id == id })
            call.respond(HttpStatusCode.Accepted, "Recipe removed successfully")
        else
            call.respond(HttpStatusCode.NotFound, "No recipe found with id $id")
    }
}

