# saga-pattern-microservices

## Como probarlo
* Levantar todos los servicios, Libros, Mesas, Orquestado y cuando estos tres ya estén levantados ejecutar el de reserva.

* Reserva es el servicio que manda a ejecutar el orquestador como se ve en el diagrama de abajo

* Reserva se puede ejecutar a través de postman usando la colección adjunta
* Reserva tambien se le puede descomentar código en la clase principal que contiene al método main, 
este código ya contiene pruebas preestablecidas y se ejecutan al iniciar la aplicación

![image](https://user-images.githubusercontent.com/60149403/218288888-bcb2a482-60e6-4fd5-9216-319ec4e78e0b.png)

* El contenido de las tablas están generados por los siguientes scripts 
Tomar en cuenta que el campo "disponible" toma valores de: [0 -> no disponible] y [1 -> disponible] esto para todas las tablas

```sql
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
```

![image](https://user-images.githubusercontent.com/60149403/218288876-f6e23965-2077-4f12-b73b-dcd0d78d4dfb.png)

