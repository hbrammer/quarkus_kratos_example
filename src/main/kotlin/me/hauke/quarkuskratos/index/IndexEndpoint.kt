package me.hauke.quarkuskratos.index

import io.quarkus.qute.Template
import io.quarkus.qute.TemplateInstance
import io.quarkus.qute.api.ResourcePath
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("") // ①
class IndexEndpoint @Inject constructor(
        @ResourcePath("index/index.html") val index: Template // ②
) {

    @GET
    @Produces(MediaType.TEXT_HTML)
    fun index(): TemplateInstance =
            index.data(
                    "title", "My first template", // ③
                    "text", "Hello 👋🏻"
            )
}
