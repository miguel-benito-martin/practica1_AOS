<img src="https://lh3.googleusercontent.com/proxy/Z0Jvqb8p-SIubrGr1N1tPm2MbPXbFA-pLoVnniCD5jPOKM9vedf5DPUCwpTUkpHWQ3WhseRLCFy0IP7EEx8nPGurbuclS2abgFR4A34" alt="ETSISI logo" height="90" >

# Arquitectura Orientada a Servicios 2021 

## Subsistema 3: gestión de trabajos de un taller 🧰

###
### _**Consideraciones de diseño**_
- Se han añadido tres métodos `GET` (además del `getTrabajoId`) para poder realizar búsquedas de trabajos por _cliente_, por _vehículo_ y por _estado_ de los trabajos (por ejemplo, búsqueda de los trabajos cuyo estados es _'planificado'_).

- Se han añadido como claves foráneas de un trabajo los atributos `idCliente` e `idVehiculo`, porque aportan información necesaria. Por otro lado, el estado de un trabajo se ha representado como un enumerado (_creado, planificado, iniciado o terminado_).

- Se ha considerado que el método `POST` necesita los valores de `idVehiculo` e `idCliente` (además del nombre y su descripción), ya que su función es la de crear nuevos trabajos. Al no haber necesidad de modificar estos valores, el método `PUT` no los tiene incluídos en su especificación.

- Tras la implementación de los métodos `PUT` y `DELETE` (completan las operaciones CRUD), la especificación alcanza el Nivel 2 de madurez de Richardson. Para alcanzar _**the glory of REST**_, se implementa HATEOAS. Se introducen los _links_ para completar la información de un trabajo. En este caso, hacen referencia a la lista de trabajos y a la opción de modificar el estado del trabajo en cuestión.

- Se adjuntan pruebas de todos los métodos y _responses_ posibles en el archivo http-request.http.

### **_Instrucciones para desplegar el servicio 🐳_**

###
Para llevar a cabo el despliegue del servicio son necesarios tres componentes fundamentales:
- Backend. Con un servidor Mock que hace las veces de server de prueba para realizar las peticiones. 
- Frontend. Con una utilidad que levanta un servidor HTTP y habilita una interfaz gráfica.
- Proxy. Con un servidor Proxy que resuelva los problemas de rutas entre Backend y Frontend.

_Docker_ nos permite agrupar los tres componentes sin necesidad de usar una máquina virtual o servidor remoto.
Para cada parte respectivamente se hará uso de:
- SpotLight/Prism
- Swagger-UI
- Caddy

Los pasos para el despliegue, mediante el uso de `docker-compose`, son los siguientes:

#### 1. Descomprimir el fichero .zip

Descomprimir el archivo en una carpeta de fácil acceso.

#### 2. Abrir la consola

Para Windows: 

- `Windows + r`
- Escribe `cmd` y pulsa `Intro`

Para máquinas basadas en Linux:

- `CTRL + T`

Para MacOS:

- `OPTION + espacio`
- Escribe `terminal` y pulsa `Intro`

#### 3. Situarse en la carpeta de la especificación

- `cd /ruta/a/la/carpeta`

#### 4. Ejecutar Docker

Abrir el _Daemon_ de Docker en la máquina(imprescindible haber instalado Docker Desktop previamente)

#### 5. Ejecutar Docker Compose

Una vez situado en la carpeta de la especificación, ejecutar el siguiente comando:

- `docker-compose up` (imprescindible estar en la carpeta del proyecto; ya que en esa ruta se encuentra el `.yaml`
del Docker Compose).

En caso de que no se pueda llevar a cabo, añadir la siguiente sentencia después de `up`:

- `--force-recreate`

#### 6. Acceder al navegador

En la ruta del navegador, acceder a la URL: `localhost:8000`

#### 7. Probar la API 

Realizar las peticiones deseadas desde la UI de Swagger.
