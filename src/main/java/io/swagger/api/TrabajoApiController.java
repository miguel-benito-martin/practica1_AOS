package io.swagger.api;

import io.swagger.model.HTTPProblems;
import io.swagger.model.InlineResponse200;
import io.swagger.model.Trabajo;
import io.swagger.model.TrabajoBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-06-05T16:35:07.675362500+02:00[Europe/Paris]")
@RestController
public class TrabajoApiController implements TrabajoApi {

    private static final Logger log = LoggerFactory.getLogger(TrabajoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private TrabajoPersistencia bdTrabajos;

    @org.springframework.beans.factory.annotation.Autowired
    public TrabajoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> grupo1AOSDelete(@Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId) {
        String accept = request.getHeader("Accept");
        if (!bdTrabajos.findById(trabajoId).isPresent())
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        else {
            bdTrabajos.deleteById(trabajoId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            ArrayList<Trabajo> trabajos = (ArrayList<Trabajo>) bdTrabajos.findAll();
            if(trabajos.isEmpty())
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
        }

        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByCliente(@Parameter(in = ParameterIn.PATH, description = "Id del cliente", required = true, schema = @Schema()) @PathVariable("idCliente") Integer idCliente) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")){
            ArrayList<Trabajo> trabajos = new ArrayList<>();
            for (Trabajo trabajo : bdTrabajos.findByIdCliente(idCliente)) {
                trabajos.add(trabajo);
            }
            if(trabajos.isEmpty())
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
        }
        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByEstado(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Elegir tipo de trabajo para su búsqueda", required = true, schema = @Schema(allowableValues = {"Creado", "Planificado", "Iniciado", "Terminado"}
            , defaultValue = "Creado")) @Valid @RequestParam(value = "estadoTrabajo", required = true, defaultValue = "Creado") String estadoTrabajo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            ArrayList<Trabajo> trabajos = new ArrayList<>();
            Trabajo.EstadoTrabajoEnum estadoTrabajoEnum = Trabajo.EstadoTrabajoEnum.fromValue(estadoTrabajo);
            for (Trabajo trabajo : bdTrabajos.findByEstadoTrabajo(estadoTrabajoEnum)) {
                trabajos.add(trabajo);
            }
            if (trabajos.isEmpty()){
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
            }
        }

        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByVehiculo(@Parameter(in = ParameterIn.PATH, description = "Id del vehiculo", required = true, schema = @Schema()) @PathVariable("idVehiculo") Integer idVehiculo) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")){
            ArrayList<Trabajo> trabajos = new ArrayList<>();
            for (Trabajo trabajo : bdTrabajos.findByIdVehiculo(idVehiculo)) {
                trabajos.add(trabajo);
            }
            if(trabajos.isEmpty())
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
        }
        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Trabajo> grupo1AOSGetId(@Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Optional<Trabajo> trabajo = bdTrabajos.findById(trabajoId);
            if (trabajo.isPresent())
                return new ResponseEntity<Trabajo>(trabajo.get(), HttpStatus.OK);
            else
                return new ResponseEntity<Trabajo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Trabajo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> grupo1AOSOptions() {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Trabajo> grupo1AOSPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody Trabajo body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")){
            bdTrabajos.save(body);
            return new ResponseEntity<Trabajo>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Trabajo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Trabajo> grupo1AOSPut(@Parameter(in = ParameterIn.HEADER, description = "ETag del recurso que se desea modificar", required = true, schema = @Schema()) @RequestHeader(value = "If-Match", required = true) String ifMatch, @Pattern(regexp = "^\\d+$") @Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId, @Parameter(in = ParameterIn.DEFAULT, description = "`Trabajo` data", required = true, schema = @Schema()) @Valid @RequestBody Object body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Trabajo>(objectMapper.readValue("{\r\n  \"trabajoId\" : 1234,\r\n  \"idVehiculo\" : 98765,\r\n  \"idCliente\" : 14,\r\n  \"nombre\" : \"Cambio de agua\",\r\n  \"descripcion\" : \"Cambio de agua cada 500km\",\r\n  \"estadoTrabajo\" : \"Iniciado\",\r\n  \"fechaInicio\" : \"2021-01-30T08:30:00Z\",\r\n  \"links\" : {\r\n    \"trabajos\" : {\r\n      \"href\" : \"/api/v1/trabajo\",\r\n      \"rel\" : \"coleccionTrabajos\"\r\n    },\r\n    \"self\" : {\r\n      \"href\" : \"/api/v1/trabajo/1234\",\r\n      \"rel\" : \"creado iniciado planificado terminado\"\r\n    }\r\n  }\r\n}", Trabajo.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Trabajo>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Trabajo>(HttpStatus.NOT_IMPLEMENTED);
    }

}
