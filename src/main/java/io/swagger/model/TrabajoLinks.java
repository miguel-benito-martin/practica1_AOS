package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Enlaces de relación
 */
@Schema(description = "Enlaces de relación")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")


public class TrabajoLinks   {
  @JsonProperty("trabajos")
  private Link trabajos = null;

  @JsonProperty("self")
  private Link self = null;

  public TrabajoLinks trabajos(Link trabajos) {
    this.trabajos = trabajos;
    return this;
  }

  public TrabajoLinks(Link trabajos, Link self) {
    this.trabajos = trabajos;
    this.self = self;
  }

  /**
   * Get trabajos
   * @return trabajos
   **/
  @Schema(description = "")
  
    @Valid
    public Link getTrabajos() {
    return trabajos;
  }

  public void setTrabajos(Link trabajos) {
    this.trabajos = trabajos;
  }

  public TrabajoLinks self(Link self) {
    this.self = self;
    return this;
  }

  /**
   * Get self
   * @return self
   **/
  @Schema(description = "")
  
    @Valid
    public Link getSelf() {
    return self;
  }

  public void setSelf(Link self) {
    this.self = self;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TrabajoLinks trabajoLinks = (TrabajoLinks) o;
    return Objects.equals(this.trabajos, trabajoLinks.trabajos) &&
        Objects.equals(this.self, trabajoLinks.self);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trabajos, self);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TrabajoLinks {\n");
    
    sb.append("    trabajos: ").append(toIndentedString(trabajos)).append("\n");
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
