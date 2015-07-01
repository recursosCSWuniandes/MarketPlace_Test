#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-marketplace)
  - [Entidad Client](#entidad-client)
  - [Entidad Item](#entidad-item)
  - [Entidad Product](#entidad-product)
  - [Entidad ShoppingCart](#entidad-shoppingcart)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /MarketPlace.web/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación MarketPlace
###Entidad Client
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Client, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Client
```javascript
{
    id: '' /*Tipo Long*/,
    phone: '' /*Tipo String*/,
    shoppingCart: '' /*Tipo ShoppingCart*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/clients|Obtener todos los objetos JSON de Client (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Client y el total de registros en la base de datos en el header X-Total-Count
**GET**|/clients/:id|Obtener los atributos de una instancia de Client en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Client
**POST**|/clients|Crear una nueva instancia de la entidad Client (CREATE)||Objeto JSON de Client a crear|Objeto JSON de Client creado
**PUT**|/clients/:id|Actualiza una instancia de la entidad Client (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Client|Objeto JSON de Client actualizado
**DELETE**|/clients/:id|Borra instancia de Client en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Item
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Item, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Item
```javascript
{
    name: '' /*Tipo String*/,
    shoppingCart: '' /*Tipo ShoppingCart*/,
    id: '' /*Tipo Long*/,
    product: '' /*Tipo Product*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/items|Obtener todos los objetos JSON de Item (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Item y el total de registros en la base de datos en el header X-Total-Count
**GET**|/items/:id|Obtener los atributos de una instancia de Item en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Item
**POST**|/items|Crear una nueva instancia de la entidad Item (CREATE)||Objeto JSON de Item a crear|Objeto JSON de Item creado
**PUT**|/items/:id|Actualiza una instancia de la entidad Item (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Item|Objeto JSON de Item actualizado
**DELETE**|/items/:id|Borra instancia de Item en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Product
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Product, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Product
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    price: '' /*Tipo Integer*/,
    description: '' /*Tipo String*/,
    type: '' /*Tipo String*/,
    image: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/products|Obtener todos los objetos JSON de Product (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Product y el total de registros en la base de datos en el header X-Total-Count
**GET**|/products/:id|Obtener los atributos de una instancia de Product en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Product
**POST**|/products|Crear una nueva instancia de la entidad Product (CREATE)||Objeto JSON de Product a crear|Objeto JSON de Product creado
**PUT**|/products/:id|Actualiza una instancia de la entidad Product (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Product|Objeto JSON de Product actualizado
**DELETE**|/products/:id|Borra instancia de Product en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad ShoppingCart
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad ShoppingCart, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto ShoppingCart
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/shoppingCarts|Obtener todos los objetos JSON de ShoppingCart (RETRIEVE)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON ShoppingCart y el total de registros en la base de datos en el header X-Total-Count
**GET**|/shoppingCarts/:id|Obtener los atributos de una instancia de ShoppingCart en formato JSON(RETRIEVE)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de ShoppingCart
**POST**|/shoppingCarts|Crear una nueva instancia de la entidad ShoppingCart (CREATE)||Objeto JSON de ShoppingCart a crear|Objeto JSON de ShoppingCart creado
**PUT**|/shoppingCarts/:id|Actualiza una instancia de la entidad ShoppingCart (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de ShoppingCart|Objeto JSON de ShoppingCart actualizado
**DELETE**|/shoppingCarts/:id|Borra instancia de ShoppingCart en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de ShoppingCart
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de ShoppingCart son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|shoppingCarts/:id/item|Obtener Objetos JSON de item(Item) dependientes de ShoppingCart|**@PathParam id**: `id` de instancia de ShoppingCart||Colección de objetos JSON de item(Item)
**POST**|shoppingCarts/:id/item|Creación de instancias de item(Item) dependientes de ShoppingCart|**@PathParam id**: `id` de instancia de ShoppingCart|Colección de objetos JSON de item(Item) a crear|Colección de objetos JSON de item(Item) creados con sus respectivos ID
**PUT**|shoppingCarts/:id/item|Actualización de instancias de item(Item) dependientes de ShoppingCart|**@PathParam id**: `id` de instancia de ShoppingCart|Colección de objetos JSON de item(Item) a actualizar|Colección de objetos JSON de item(Item) actualizados
**DELETE**|shoppingCarts/:id/item|Eliminación de instancias de item(Item) dependientes de ShoppingCart|**@PathParam id**: `id` de instancia de ShoppingCart|Colección de atributo `id` de item(Item) a eliminar|

[Volver arriba](#tabla-de-contenidos)

