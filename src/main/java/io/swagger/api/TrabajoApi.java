/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.26).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.HTTPProblems;
import io.swagger.model.InlineResponse200;
import io.swagger.model.Trabajo;
import io.swagger.model.TrabajoBody;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")
@Validated
public interface TrabajoApi {

    @Operation(summary = "Elimina un trabajo", description = "Elimina un trabajo identificada por `trabajoId`.", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Trabajo eliminado &lt;Cuerpo de la respuesta vacío&gt;"),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: recurso no disponible", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo/{trabajoId}",
            produces = {"application/problem+json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Void> grupo1AOSDelete(@Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId);


    @Operation(summary = "Obtiene todos los trabajos de mantenimiento que se realizan sobre un vehículo", description = "", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Array de trabajos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: recurso no disponible", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "414", description = "REQUEST-URI TOO LONG: la URI es demasiado larga", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo",
            produces = {"application/json", "application/problem+json"},
            method = RequestMethod.GET)
    ResponseEntity<ArrayList<Trabajo>> grupo1AOSGet();


    @Operation(summary = "Buscar trabajos por cliente", description = "Buscar trabajos por el cliente que lo ha encargado", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Array de trabajos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: recurso no disponible", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo/cliente/{idCliente}",
            produces = {"application/json", "application/problem+json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> grupo1AOSGetByCliente(@Pattern(regexp = "^\\d+$") @Parameter(in = ParameterIn.PATH, description = "Id del cliente", required = true, schema = @Schema()) @PathVariable("idCliente") Integer idCliente);


    @Operation(summary = "Buscar trabajos por estado", description = "Buscar trabajos por su estado actual", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Array de trabajos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo/findByEstadoTrabajo",
            produces = {"application/json", "application/problem+json"},
            method = RequestMethod.GET)
    ResponseEntity<InlineResponse200> grupo1AOSGetByEstado(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Elegir tipo de trabajo para su búsqueda", required = true, schema = @Schema(allowableValues = {"Creado", "Planificado", "Iniciado", "Terminado"}
            , defaultValue = "Creado")) @Valid @RequestParam(value = "estadoTrabajo", required = true, defaultValue = "Creado") String estadoTrabajo);


    @Operation(summary = "Buscar trabajos por identificador vehiculo", description = "Buscar trabajos por el vehículo del cliente que lo ha encargado", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Array de trabajos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse200.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: recurso no disponible", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo/vehiculo/{idVehiculo}",
            produces = {"application/json", "application/problem+json"},
            method = RequestMethod.GET)
    ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByVehiculo(@Parameter(in = ParameterIn.PATH, description = "Id del vehiculo", required = true, schema = @Schema()) @PathVariable("idVehiculo") Integer idVehiculo);


    @Operation(summary = "Buscar un trabajo por su ID", description = "Devuelve el trabajo especificado por `trabajoId`", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Trabajo", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Trabajo.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: recurso no disponible", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo/{trabajoId}",
            produces = {"application/json", "application/problem+json"},
            method = RequestMethod.GET)
    ResponseEntity<Trabajo> grupo1AOSGetId(@Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId);


    @Operation(summary = "Proporciona la lista de los métodos HTTP soportados", description = "Devuelve una cabecera `Allow` con la lista de métodos HTTP soportados (separados por comas).", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "cabecera `Allow` &lt;El cuerpo de la respuesta está vacío&gt;"),

            @ApiResponse(responseCode = "405", description = "METHOD NOT ALLOWED: metodo no permitido", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo",
            produces = {"application/problem+json"},
            method = RequestMethod.OPTIONS)
    ResponseEntity<Void> grupo1AOSOptions();


    @Operation(summary = "Crea un nuevo trabajo", description = "Genera un nuevo trabajo de mantenimiento para un determinado vehículo", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Trabajo creado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Trabajo.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "413", description = "PAYLOAD TOO LARGE: el dato es demasiado grande", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "422", description = "UNPROCESSABLE ENTITY: falta algún dato", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "414", description = "REQUEST-URI TOO LONG: la URI es demasiado larga", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo",
            produces = {"application/json", "application/problem+json"},
            consumes = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Trabajo> grupo1AOSPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Trabajo body);


    @Operation(summary = "Modifica un trabajo", description = "Actualiza los datos de un trabajo por un trabajoId", tags = {"Trabajo"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo OK: trabajo modificado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Trabajo.class))),

            @ApiResponse(responseCode = "400", description = "BAD REQUEST: request no procesable", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "404", description = "NOT FOUND: recurso no disponible", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "412", description = "PRECONDITION FAILED: no se cumple alguna condición previa", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class))),

            @ApiResponse(responseCode = "413", description = "PAYLOAD TOO LARGE: el dato es demasiado grande", content = @Content(mediaType = "application/problem+json", schema = @Schema(implementation = HTTPProblems.class)))})
    @RequestMapping(value = "/trabajo/{trabajoId}",
            produces = {"application/json", "application/problem+json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Trabajo> grupo1AOSPut(@Parameter(in = ParameterIn.HEADER, description = "ETag del recurso que se desea modificar", required = true, schema = @Schema()) @RequestHeader(value = "If-Match", required = true) String ifMatch, @Pattern(regexp = "^\\d+$") @Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId, @Parameter(in = ParameterIn.DEFAULT, description = "`Trabajo` data", required = true, schema = @Schema()) @Valid @RequestBody Object body);

}

