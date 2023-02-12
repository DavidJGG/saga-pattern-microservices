# saga-pattern-microservices

## Como probarlo
* Levantar todos los servicios, Libros, Mesas, Orquestado y cuando estos tres ya esten levantados ejecutar el de reserva.

* Reserva es el servicio que manda a ejecutar el orquestador como se ve en el diagrama de abajo

* Reserva se puede ejecutar a través de postman usando la coleccion adjunta
* Reserva tambien se le puede descomentar codigo en la clase principal que contiene al metodo main, 
este codigo ya contiene pruebas preestablecidas y se ejecutan al iniciar la aplicacion

* El contenido de las tablas estan generados por los siguientes scripts
Tomar en cuena que el campo "disponible" toma valores de: [0 -> no disponible] y [1 -> disponible] esto para todas las tablas

insert into libro(titulo, disponible) values ('Libro 1', 1);
insert into libro(titulo, disponible) values ('Libro 2', 1);
insert into libro(titulo, disponible) values ('Libro 3', 1);
insert into libro(titulo, disponible) values ('Libro 4', 1);
insert into libro(titulo, disponible) values ('Libro 5', 1);
insert into libro(titulo, disponible) values ('Libro 6', 1);

insert into mesa(nivel, numero, disponible) values (1, 1, 1);
insert into mesa(nivel, numero, disponible) values (1, 2, 0);
insert into mesa(nivel, numero, disponible) values (1, 3, 1);
insert into mesa(nivel, numero, disponible) values (1, 4, 0);
insert into mesa(nivel, numero, disponible) values (2, 1, 1);
insert into mesa(nivel, numero, disponible) values (2, 2, 0);
insert into mesa(nivel, numero, disponible) values (2, 3, 1);
insert into mesa(nivel, numero, disponible) values (2, 4, 0);

