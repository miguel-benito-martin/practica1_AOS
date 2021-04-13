<img src="https://lh3.googleusercontent.com/proxy/Z0Jvqb8p-SIubrGr1N1tPm2MbPXbFA-pLoVnniCD5jPOKM9vedf5DPUCwpTUkpHWQ3WhseRLCFy0IP7EEx8nPGurbuclS2abgFR4A34" alt="ETSISI logo" height="90" >

# Arquitectura Orientada a Servicios 2021 

## Subsistema 3: gestión de trabajos de un taller 🧰

###
### _**Decisiones de diseño**_
- Se han añadido tres funciones get para poder realizar búsquedas de trabajos por cliente, por vehículo y por estado de los trabajos (por ejemplo búsqueda de los trabajos planificados).

-  Se han añadido como claves foráneas de un trabajo los atributos idCliente e idVehiculo porque aportan información necesaria. Por otro lado, el estado de un trabajo se ha representado como una enumeración (creado,  planificado, iniciado o terminado).

- Se ha considerado que los métodos post, ya que su función es la de crear nuevos trabajos, necesitan los valores de idvehiculo e idcliente. Al no haber necesidad de modificar estos valores, el método put no los tiene incluídos en su especificación.

- Consideramos que la especificación cumple con los 4 niveles de madurez de Richardson.

- Se adjuntan pruebas del http-request de todos los métodos realizados.

### **_Instrucciones para desplegar el servicio_**
....

