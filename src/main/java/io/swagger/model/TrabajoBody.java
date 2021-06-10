package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TrabajoBody
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")


public class TrabajoBody {
    @JsonProperty("nombre")
    private String nombre = null;

    @JsonProperty("descripcion")
    private String descripcion = null;

    @JsonProperty("idVehiculo")
    private Integer idVehiculo = null;

    @JsonProperty("idCliente")
    private Integer idCliente = null;

    public TrabajoBody nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * Nombre del tipo de trabajo
     *
     * @return nombre
     **/
    @Schema(required = true, description = "Nombre del tipo de trabajo")
    @NotNull

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TrabajoBody descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    /**
     * Descripción del trabajo
     *
     * @return descripcion
     **/
    @Schema(required = true, description = "Descripción del trabajo")
    @NotNull

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TrabajoBody idVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    /**
     * Identificador del vehículo
     *
     * @return idVehiculo
     **/
    @Schema(required = true, description = "Identificador del vehículo")
    @NotNull

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public TrabajoBody idCliente(Integer idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    /**
     * Identificador del cliente
     *
     * @return idCliente
     **/
    @Schema(required = true, description = "Identificador del cliente")
    @NotNull

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TrabajoBody trabajoBody = (TrabajoBody) o;
        return Objects.equals(this.nombre, trabajoBody.nombre) &&
                Objects.equals(this.descripcion, trabajoBody.descripcion) &&
                Objects.equals(this.idVehiculo, trabajoBody.idVehiculo) &&
                Objects.equals(this.idCliente, trabajoBody.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, descripcion, idVehiculo, idCliente);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TrabajoBody {\n");

        sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
        sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
        sb.append("    idVehiculo: ").append(toIndentedString(idVehiculo)).append("\n");
        sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
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
