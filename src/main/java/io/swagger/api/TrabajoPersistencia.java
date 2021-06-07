package io.swagger.api;

import io.swagger.model.Trabajo;
import io.swagger.model.TrabajoBody;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrabajoPersistencia extends MongoRepository<Trabajo, Integer> {

}
