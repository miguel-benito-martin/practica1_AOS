package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * Añadir descripción
 */
@Schema(description = "Añadir descripción")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")

@Document(collection = "demo")
public class Trabajo extends TrabajoBody{


    @JsonProperty("links")
    private TrabajoLinks links = null;


    public Trabajo links(TrabajoLinks links) {
        this.links = links;
        return this;
    }
    /**
     * Get links
     *
     * @return links
     **/
    @Schema(description = "")

    @Valid
    public TrabajoLinks getLinks() {
        return links;
    }

    public void setLinks(TrabajoLinks links) {
        this.links = links;
    }
}
