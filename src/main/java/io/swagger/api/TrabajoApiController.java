package io.swagger.api;

import io.swagger.model.Link;
import io.swagger.model.Trabajo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.TrabajoBody;
import io.swagger.model.TrabajoLinks;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
        if (accept != null) {
            ArrayList<Trabajo> trabajos = (ArrayList<Trabajo>) bdTrabajos.findAll();
            if (trabajos.isEmpty())
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
        }

        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByCliente(@Parameter(in = ParameterIn.PATH, description = "Id del cliente", required = true, schema = @Schema()) @PathVariable("idCliente") Integer idCliente) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            ArrayList<Trabajo> trabajos = new ArrayList<>();
            for (Trabajo trabajo : bdTrabajos.findByIdCliente(idCliente)) {
                trabajos.add(trabajo);
            }
            if (trabajos.isEmpty())
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
        }
        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByEstado(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Elegir tipo de trabajo para su búsqueda", required = true, schema = @Schema(allowableValues = {"Creado", "Planificado", "Iniciado", "Terminado"}
            , defaultValue = "Creado")) @Valid @RequestParam(value = "estadoTrabajo", required = true, defaultValue = "Creado") String estadoTrabajo) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            ArrayList<Trabajo> trabajos = new ArrayList<>();
            Trabajo.EstadoTrabajoEnum estadoTrabajoEnum = Trabajo.EstadoTrabajoEnum.fromValue(estadoTrabajo);
            for (Trabajo trabajo : bdTrabajos.findByEstadoTrabajo(estadoTrabajoEnum)) {
                trabajos.add(trabajo);
            }
            if (trabajos.isEmpty()) {
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
            }
        }

        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<Trabajo>> grupo1AOSGetByVehiculo(@Parameter(in = ParameterIn.PATH, description = "Id del vehiculo", required = true, schema = @Schema()) @PathVariable("idVehiculo") Integer idVehiculo) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            ArrayList<Trabajo> trabajos = new ArrayList<>();
            for (Trabajo trabajo : bdTrabajos.findByIdVehiculo(idVehiculo)) {
                trabajos.add(trabajo);
            }
            if (trabajos.isEmpty())
                return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<ArrayList<Trabajo>>(trabajos, HttpStatus.OK);
        }
        return new ResponseEntity<ArrayList<Trabajo>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Trabajo> grupo1AOSGetId(@Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema()) @PathVariable("trabajoId") Integer trabajoId) {
        String accept = request.getHeader("Accept");
        if (accept != null) {
            Optional<Trabajo> trabajo = bdTrabajos.findById(trabajoId);
            if (trabajo.isPresent())
                return new ResponseEntity<Trabajo>(trabajo.get(), HttpStatus.OK);
            else
                return new ResponseEntity<Trabajo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Trabajo>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<ArrayList<String>> grupo1AOSOptions() {
        String accept = request.getHeader("Accept");
        Class clase = TrabajoApiController.class;
        Method[] aux = clase.getDeclaredMethods();
        ArrayList<String> options = new ArrayList<>();
        for (Method m : aux) {
            options.add(m.getName());
        }
        return new ResponseEntity<ArrayList<String>>(options, HttpStatus.OK);
    }

    public ResponseEntity<Trabajo> grupo1AOSPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody TrabajoBody body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            if (!comprobarIdPOST(body)) {
                Trabajo nuevoTrabajo = new Trabajo();
                nuevoTrabajo.setTrabajoId(body.getTrabajoId());
                nuevoTrabajo.setNombre(body.getNombre());
                nuevoTrabajo.setEstadoTrabajo(body.getEstadoTrabajo());
                nuevoTrabajo.setDescripcion(body.getDescripcion());
                nuevoTrabajo.setFechaInicio(body.getFechaInicio());
                nuevoTrabajo.setFechaFin(body.getFechaFin());
                nuevoTrabajo.setIdCliente(body.getIdCliente());
                nuevoTrabajo.setIdVehiculo(body.getIdVehiculo());
                nuevoTrabajo.setLinks(new TrabajoLinks(new Link("http://localhost:8080/api/v1/trabajo", "Lista de todos los trabajos registrados"),
                        new Link("http://localhost:8080/api/v1/swagger-ui/#/Trabajo/grupo1AOSPutUsingPUT", "Modificar este trabajo")));
                bdTrabajos.save(nuevoTrabajo);
                return new ResponseEntity<Trabajo>(nuevoTrabajo, HttpStatus.CREATED);
            } else return new ResponseEntity<Trabajo>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<Trabajo>(HttpStatus.BAD_REQUEST);
    }

    private boolean comprobarIdPOST(TrabajoBody t) {
        return bdTrabajos.existsById(t.getTrabajoId());
    }

    public ResponseEntity<Trabajo> grupo1AOSPut(@Parameter(in = ParameterIn.HEADER, description = "ETag del recurso que se desea modificar", required = true, schema = @Schema())
                                                @RequestHeader(value = "If-Match", required = true) String ifMatch, @Parameter(in = ParameterIn.PATH, description = "ID del trabajo", required = true, schema = @Schema())
                                                @PathVariable("trabajoId") Integer trabajoId, @Parameter(in = ParameterIn.DEFAULT, description = "`Trabajo` data", required = true, schema = @Schema()) @Valid @RequestBody TrabajoBody body) {
        String accept = request.getHeader("Accept");
        Optional<Trabajo> trabajo = bdTrabajos.findById(trabajoId);
        if (trabajo.isPresent() && accept.contains("application/json")) {
            Trabajo t = trabajo.get();
            t.setNombre(body.getNombre());
            t.setEstadoTrabajo(body.getEstadoTrabajo());
            t.setDescripcion(body.getDescripcion());
            t.setFechaInicio(body.getFechaInicio());
            t.setFechaFin(body.getFechaFin());
            t.setIdCliente(body.getIdCliente());
            t.setIdVehiculo(body.getIdVehiculo());
            t.setLinks(new TrabajoLinks(new Link("http://localhost:8080/api/v1/trabajo", "Lista de todos los trabajos registrados"),
                    new Link("http://localhost:8080/api/v1/swagger-ui/#/Trabajo/grupo1AOSPutUsingPUT", "Modificar este trabajo")));
            bdTrabajos.save(t);
            return new ResponseEntity<Trabajo>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Trabajo>(HttpStatus.NOT_FOUND);
        }
    }

}
