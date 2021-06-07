package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.model.TrabajoLinks;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Añadir descripción
 */
@Schema(description = "Añadir descripción")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")

@Document(collection = "demo")
public class Trabajo {
    @JsonProperty("trabajoId")
    @Id
    private Integer trabajoId = null;

    @JsonProperty("idVehiculo")
    private Integer idVehiculo = null;

    @JsonProperty("idCliente")
    private Integer idCliente = null;

    @JsonProperty("nombre")
    private String nombre = null;

    @JsonProperty("descripcion")
    private String descripcion = null;

    /**
     * Posibles estados del trabajo [Creado, Planificado, Iniciado, Terminado]
     */
    public enum EstadoTrabajoEnum {
        CREADO("Creado"),

        PLANIFICADO("Planificado"),

        INICIADO("Iniciado"),

        TERMINADO("Terminado");

        private String value;

        EstadoTrabajoEnum(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static EstadoTrabajoEnum fromValue(String text) {
            for (EstadoTrabajoEnum b : EstadoTrabajoEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }
    }

    @JsonProperty("estadoTrabajo")
    private EstadoTrabajoEnum estadoTrabajo = null;

    @JsonProperty("fechaInicio")
    private OffsetDateTime fechaInicio = null;

    @JsonProperty("fechaFin")
    private OffsetDateTime fechaFin = null;

    @JsonProperty("links")
    private TrabajoLinks links = null;

    public Trabajo trabajoId(Integer trabajoId) {
        this.trabajoId = trabajoId;
        return this;
    }

    public Trabajo(Integer trabajoId, Integer idVehiculo, Integer idCliente, String nombre, String descripcion, EstadoTrabajoEnum estadoTrabajo) {
        this.trabajoId = trabajoId;
        this.idVehiculo = idVehiculo;
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estadoTrabajo = estadoTrabajo;
    }

    /**
     * Identicador del trabajo
     *
     * @return trabajoId
     **/
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Identicador del trabajo")

    public Integer getTrabajoId() {
        return trabajoId;
    }

    public void setTrabajoId(Integer trabajoId) {
        this.trabajoId = trabajoId;
    }

    public Trabajo idVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
        return this;
    }

    /**
     * ID del vehículo sobre el que se reliza el trabajo
     *
     * @return idVehiculo
     **/
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "ID del vehículo sobre el que se reliza el trabajo")

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Trabajo idCliente(Integer idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    /**
     * ID del cliente propietario del vehículo
     *
     * @return idCliente
     **/
    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "ID del cliente propietario del vehículo")

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Trabajo nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    /**
     * Nombre del tipo de trabajo
     *
     * @return nombre
     **/
    @Schema(description = "Nombre del tipo de trabajo")

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Trabajo descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    /**
     * Descripción del trabajo
     *
     * @return descripcion
     **/
    @Schema(description = "Descripción del trabajo")

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Trabajo estadoTrabajo(EstadoTrabajoEnum estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
        return this;
    }

    /**
     * Posibles estados del trabajo [Creado, Planificado, Iniciado, Terminado]
     *
     * @return estadoTrabajo
     **/
    @Schema(description = "Posibles estados del trabajo [Creado, Planificado, Iniciado, Terminado]")

    public EstadoTrabajoEnum getEstadoTrabajo() {
        return estadoTrabajo;
    }

    public void setEstadoTrabajo(EstadoTrabajoEnum estadoTrabajo) {
        this.estadoTrabajo = estadoTrabajo;
    }

    public Trabajo fechaInicio(OffsetDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }

    /**
     * Fecha en la que se inicializa el trabajo
     *
     * @return fechaInicio
     **/
    @Schema(description = "Fecha en la que se inicializa el trabajo")

    @Valid
    public OffsetDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(OffsetDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Trabajo fechaFin(OffsetDateTime fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    /**
     * Fecha en la que se finaliza el trabajo
     *
     * @return fechaFin
     **/
    @Schema(description = "Fecha en la que se finaliza el trabajo")

    @Valid
    public OffsetDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(OffsetDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

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


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Trabajo trabajo = (Trabajo) o;
        return Objects.equals(this.trabajoId, trabajo.trabajoId) &&
                Objects.equals(this.idVehiculo, trabajo.idVehiculo) &&
                Objects.equals(this.idCliente, trabajo.idCliente) &&
                Objects.equals(this.nombre, trabajo.nombre) &&
                Objects.equals(this.descripcion, trabajo.descripcion) &&
                Objects.equals(this.estadoTrabajo, trabajo.estadoTrabajo) &&
                Objects.equals(this.fechaInicio, trabajo.fechaInicio) &&
                Objects.equals(this.fechaFin, trabajo.fechaFin) &&
                Objects.equals(this.links, trabajo.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trabajoId, idVehiculo, idCliente, nombre, descripcion, estadoTrabajo, fechaInicio, fechaFin, links);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Trabajo {\n");

        sb.append("    trabajoId: ").append(toIndentedString(trabajoId)).append("\n");
        sb.append("    idVehiculo: ").append(toIndentedString(idVehiculo)).append("\n");
        sb.append("    idCliente: ").append(toIndentedString(idCliente)).append("\n");
        sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
        sb.append("    descripcion: ").append(toIndentedString(descripcion)).append("\n");
        sb.append("    estadoTrabajo: ").append(toIndentedString(estadoTrabajo)).append("\n");
        sb.append("    fechaInicio: ").append(toIndentedString(fechaInicio)).append("\n");
        sb.append("    fechaFin: ").append(toIndentedString(fechaFin)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
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
