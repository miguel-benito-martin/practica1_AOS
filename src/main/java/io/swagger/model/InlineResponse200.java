package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")


public class InlineResponse200   {
  @JsonProperty("trabajos")
  @Valid
  private List<Trabajo> trabajos = null;

  public InlineResponse200 trabajos(List<Trabajo> trabajos) {
    this.trabajos = trabajos;
    return this;
  }

  public InlineResponse200 addTrabajosItem(Trabajo trabajosItem) {
    if (this.trabajos == null) {
      this.trabajos = new ArrayList<Trabajo>();
    }
    this.trabajos.add(trabajosItem);
    return this;
  }

  /**
   * array de trabajos
   * @return trabajos
   **/
  @Schema(description = "array de trabajos")
      @Valid
    public List<Trabajo> getTrabajos() {
    return trabajos;
  }

  public void setTrabajos(List<Trabajo> trabajos) {
    this.trabajos = trabajos;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.trabajos, inlineResponse200.trabajos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(trabajos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    trabajos: ").append(toIndentedString(trabajos)).append("\n");
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
