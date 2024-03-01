# Acceso a Datos

## Actividad 3 –  JPA y JAXB

Actividad Realizada por:

### GRUPO 3

- Alejandro Aguiar Díaz. 
- Alberto Arroyo Santofimia.
- Andrés Avendaño Monteagudo. 
- Carmen Álvarez -Montenegro Piñeiro.

Pautas de elaboración

## Requerimiento 1. Actividad3_Alberto_V2

La idea de esta aplicación será la de generar un modelo de datos para gestionar una cadena de librerías.

Se pide diseñar el programa mediante JPA que cumpla con, al menos, los siguientes requisitos y entidades.

Autor, tendrá un id, un nombre, unos apellidos y una fecha de nacimiento. Un autor podrá escribir muchos libros
Editorial, tendrá un id, un nombre y una dirección. También tendrá una colección de libros publicados por la editorial.
Libro, tendrá un id, un título, un precio, una editorial y un autor.
Librería, tendrá un id, un nombre, un nombre del dueño, una dirección y una colección de libros. Además, hay que tener en cuenta que un libro puede estar en diferentes librerías.
Todas estas entidades tendrán relaciones bidireccionales.

Una vez diseñado el modelo de datos y creadas las tablas se pide hacer las siguientes operaciones (los valores serán elegidos por el alumno, pero deberán de tener sentido).

Dar de alta 3 autores
Dar de alta 2 editoriales
Dar de alta 8 libros, cada libro será escrito por uno de los autores dados de alta previamente y pertenecerá a uno de los editoriales dados de alta previamente.
2 librerías, cada librería tendrá 4 libros dados de alta previamente
Además, se pide realizar las siguientes consultas y mostrarlas por pantalla, cada una debe de ser independiente:

Mostrar todos los libros dados de alta, con su editorial y su autor
Mostrar todos los autores dados de alta, con sus libros asociados
Mostrar todas las librerías, con solamente sus libros asociados
Mostrar todos los libros dados de alta, y en la librería en la que están.

![Imagen](imgReadme/Imagen1.png)

![Imagen](imgReadme/Imagen1-2.png)

![Imagen](imgReadme/Imagen1-3.png)



## Requerimiento 2. Actividad3_Alberto_R2_JusticeLeagueFinal

Se pide realizar un nuevo modelo de datos que cubra todos los tipos de relaciones visto en clase, esto es, 1 a 1, 1 a N y N a M. El modelo tendrá las entidades necesarias para realizar dichas relaciones y será inventado por los alumnos, es decir, será un trabajo original. Se piden hacer las entidades y las anotaciones en cada entidad para realizar el modelo de datos de JPA.

Se recomienda que cada integrante del equipo realice un modelo nuevo para practicar y entender JPA.

Por ejemplo, se podría hacer un modelo de datos de una empresa de coches, que tuviera una lista de empleados asociados y una dirección asociada.

### Voy a recrear la base de datos que tiene Batman con su plan de contingencia contra la Liga de la Justicia en caso de que se vuelva peligrosa, recopilando toda la información sobre cada héroe.

Superheroe tiene una relación de uno a uno con IdentidadSecreta. 1:1
Equipo tiene una relación de uno a muchos con Superheroe. 1:N
Superheroe tiene una relación de muchos a muchos con Habilidad. N:M
Superheroe tiene una relación de muchos a muchos con Debilidad. N:M
IdentidadSecreta tiene una relación de uno a uno con Superheroe. 1:1
Habilidad tiene una relación de muchos a muchos con Superheroe. N:M
Debilidad tiene una relación de muchos a muchos con Superheroe. N:M

![Imagen](imgReadme/Imagen2-1.png)

![Imagen](imgReadme/Imagen2-2.png)

![Imagen](imgReadme/Imagen2-3.png)

## Requerimiento 3. Actividad3_Alberto_R3

Aplicando JAXB, coger la clase ‘Articulo’ de la actividad 1 y serializar una lista con 3 artículos a XML. Para ello se deberán de usar las anotaciones de JAXB correspondientes.

![Imagen](imgReadme/Imagen3.png)
