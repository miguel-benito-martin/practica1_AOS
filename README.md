
# Arquitectura Orientada a Servicios 2021

## Subsistema 3: gesti贸n de trabajos de un taller 馃О

  
Este repositorio contiene la informaci贸n acerca de la especificaci贸n de una API sobre  
los trabajos de una taller y las instrucciones necesarias para su despliegue.  
La especificaci贸n pertenece a la pr谩ctica 1; mientras que el despliegue forma parte  
de la pr谩ctica 2.  

Contenido del repositorio:
- **Especificaci贸n de la API.**
- **Despliegue del servicio y consideraciones de dise帽o.**

## Especificaci贸n de la API pr谩ctica 1

### _**Especificaci贸n de la API:**_
- Se han a帽adido tres m茅todos `GET` (adem谩s del `getTrabajoId`) para poder realizar b煤squedas de trabajos por _cliente_, por _veh铆culo_ y por _estado_ de los trabajos (por ejemplo, b煤squeda de los trabajos cuyo estados es _'planificado'_).

- Se han a帽adido como claves for谩neas de un trabajo los atributos `idCliente` e `idVehiculo`, porque aportan informaci贸n necesaria. Por otro lado, el estado de un trabajo se ha representado como un enumerado (_creado, planificado, iniciado o terminado_).

- Se ha considerado que el m茅todo `POST` necesita los valores de `idVehiculo` e `idCliente` (adem谩s del nombre y su descripci贸n), ya que su funci贸n es la de crear nuevos trabajos. Al no haber necesidad de modificar estos valores, el m茅todo `PUT` no los tiene inclu铆dos en su especificaci贸n.

- Tras la implementaci贸n de los m茅todos `PUT` y `DELETE` (completan las operaciones CRUD), la especificaci贸n alcanza el Nivel 2 de madurez de Richardson. Para alcanzar _**the glory of REST**_, se implementa HATEOAS. Se introducen los _links_ para completar la informaci贸n de un trabajo. En este caso, hacen referencia a la lista de trabajos y a la opci贸n de modificar el estado del trabajo en cuesti贸n.



## Consideraciones de dise帽o y despliegue


### **_Creaci贸n de la imagen para el servicio_**
En este caso se ha decidido compilar la imagen con una base de `Ubuntu 18.04`, a la que se le instala `OpenJdK`(la API est谩 implementada en Spring mediante la generaci贸n de c贸digo de Swagger Codegen). Adem谩s, para la implementaci贸n se hace uso de persistencia con `MongoDB`. Por tanto, se instala tambi茅n una versi贸n de mongo mediante el Dockefile.

馃惓 https://hub.docker.com/r/migue9b/trabajos 馃惓

Para la utilizaci贸n de la imagen simplemente es necesario descargarla y crear un contenedor con ella:

`docker run --name <nombre> -p 8080:8080 migue9b/trabajos:latest`  
`http://localhost:8080/api/v1` tras arrancar el contenedor.  

### **_Docker compose_**
Tras el an谩lisis del resto de servicios se concluyen las siguientes decisiones de dise帽o de cara al despliegue con `docker-compose`.  

- **Servicio 1** (clientes): API para los clientes. En su especificaci贸n se aprecia una implementaci贸n del servicio. Sin embargo, la conexi贸n con la BD no es correcta. Sin embargo, se decide crear un contenedor para el servicio con la imagen del subsistema, y otro contenedor para la BD en Mongodb. `http://localhost:8080/clientes`
- **Servicio 2** (veh铆culos): API para los vehiculos. Se aprecia una conexi贸n correcta con la BD y una implementaci贸n funcional. Por tanto, se especifican contenedores para el servicio y para MySQL. `http://localhost:8081/api/v1/ui`
- **Servicio 3** (trabajos): usamos nuestra propia imagen(que no necesita persistencia adicional con contenedor porque ya la lleva incorporada la imagen). `http://localhost:8082/api/v1/`
- **Servicio 4** (notificaciones): API para las notificaciones. Esta API est谩 implementada. Sin embargo, la conexi贸n con la BD no es correcta. A煤n as铆 se decide crear un contenedor para el servicio y otro para su persistencia con MySQL. `http://localhost:8083/AOS4`
- **Servicio 5** (facturas): API para las facturas. Se aprecia una pseudoimplementaci贸n, en donde las peticiones est谩n "falseadas" con respuestas precreadas. Por tanto, se crea un 煤nico contendor. `http://localhost:8084/api/v1/factura`
- **Servicio 6** (recambios): API para los recambios. Esta API tambi茅n tiene una implementaci贸n incompleta, sin persistencia por detr谩s. Se crea un solo contenedor. `http://localhost:8085/api/v1/recambios` 

Para el despliegue:  
`docker-compose up` sobre la capeta donde se encuentra el archivo.

### **_Kubernetes_**

Esta implementaci贸n es parecida a la de docker compose.  
Para Kubernetes se realiza un despliegue por cada servicio. Es decir, 6 despliegues con objetos de tipo `deployment`. Adem谩s, se a帽aden las plantillas para la especificaci贸n de los `service` que permiten la conexi贸n a los `pods` desde el exterior. Los puertos que se exponen siguen el mismo esquema que docker-compose.

Para desplegar correctamente los servicios es necesario seguir los siguientes pasos:
1. Para desplegar el cl煤ster en kubernetes hay que ejecutar el comando  `kubectl apply -f kubernetes-deployment.yaml` 
2. Posteriormente para deplegar alg煤n servicio, hay que ejecutar el comando `minikube service nombreServicio --url`. Esto generar谩 la url del servicio a desplegar.
3. Abrir el navegador e introducir `localhost:puertoObtenido/ruta`.
  
### **_Despliegue en la nube de Azure_** 

Mediante Kubernetes hemos desplegado los servicios en un entorno _cloud_. Las capturas se adjuntan en la carpetas _images_.