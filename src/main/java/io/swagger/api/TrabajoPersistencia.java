package io.swagger.api;

import io.swagger.model.Trabajo;
import io.swagger.model.TrabajoBody;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;


public interface TrabajoPersistencia extends MongoRepository<Trabajo, Integer> {
    ArrayList<Trabajo> findByIdVehiculo(Integer idVehiculo);

    ArrayList<Trabajo> findByIdCliente(Integer idCliente);

    ArrayList<Trabajo> findByEstadoTrabajo(Trabajo.EstadoTrabajoEnum estadosTrabajo);
}
