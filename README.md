<img src="https://lh3.googleusercontent.com/proxy/Z0Jvqb8p-SIubrGr1N1tPm2MbPXbFA-pLoVnniCD5jPOKM9vedf5DPUCwpTUkpHWQ3WhseRLCFy0IP7EEx8nPGurbuclS2abgFR4A34" alt="ETSISI logo" height="90" >

# Arquitectura Orientada a Servicios 2021 

## Subsistema 3: gestión de trabajos de un taller 🧰

###
### _**Decisiones de diseño**_
- Se han añadido tres funciones get para poder realizar búsquedas de trabajos por _cliente_, por _vehículo_ y por _estado_ de los trabajos (por ejemplo, búsqueda de los trabajos cuyo estados es _'planificado'_).

- Se han añadido como claves foráneas de un trabajo los atributos `idCliente` e `idVehiculo`, porque aportan información necesaria. Por otro lado, el estado de un trabajo se ha representado como una enumeración (_creado, planificado, iniciado o terminado_).

- Se ha considerado que el método `POST` necesita los valores de `idVehiculo` e `idCliente`, ya que su función es la de crear nuevos trabajos. Al no haber necesidad de modificar estos valores, el método `PUT` no los tiene incluídos en su especificación.

- Consideramos que la especificación cumple con los 4 niveles de madurez de Richardson.

- Se adjuntan pruebas del http-request de todos los métodos realizados.

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

Una vez situado en al carpeta de la especificación, ejecutar el siguiente comando:

- `docker-compose up` (imprescindible estar en la carpeta del proyecto; ya que en esa ruta se encuentra el `.yaml`
del Docker Compose).

En caso de que no se pueda llevar a cabo, añadir la siguiente sentencia después de `up`:

- `--force-recreate`

#### 6. Acceder al navegador

En la ruta del navegador, acceder a la URL: `localhost:8000`

#### 7. Probar la API 

Realizar las peticiones deseadas desde la UI de Swagger.