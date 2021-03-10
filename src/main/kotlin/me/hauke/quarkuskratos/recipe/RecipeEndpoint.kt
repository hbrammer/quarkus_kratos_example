package me.hauke.quarkuskratos.recipe

import io.quarkus.qute.Template
import io.quarkus.qute.TemplateInstance
import io.quarkus.qute.api.ResourcePath
import me.hauke.quarkuskratos.auth.Secured
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/recipe")
class RecipeEndpoint @Inject constructor(
        @ResourcePath("recipe/recipe.html") val recipe: Template
) {

    @Secured
    @GET
    @Produces(MediaType.TEXT_HTML)
    fun get(): TemplateInstance =
            recipe.instance()
}