/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Services;

import com.biblioteca.orquestador.Models.EstadoDelPaso;
import com.biblioteca.orquestador.Models.Libro;
import com.biblioteca.orquestador.Models.ReservaLibroREQ;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author DGG
 */
public class ReservarLibro implements Paso<Libro, Boolean> {

    private ReservaLibroREQ reservaReq;
    private WebClient cliente;
    private EstadoDelPaso estado = EstadoDelPaso.PENDIENTE;

    public ReservarLibro(ReservaLibroREQ reservaReq, WebClient cliente) {
        this.reservaReq = reservaReq;
        this.cliente = cliente;
    }

    @Override
    public EstadoDelPaso getEstado() {
        return this.estado;
    }

    @Override
    public Libro procesar() {

        try {

            Libro libro = cliente.post()
                    .uri("/api/libros/reservar")
                    .body(BodyInserters.fromValue(reservaReq))
                    .retrieve()
                    .onStatus(
                            HttpStatus.NOT_ACCEPTABLE::equals,
                            res -> res.bodyToMono(String.class).map(x -> new Exception("Libro no disponible"))
                    )
                    .bodyToMono(Libro.class)
                    .block();

            if (libro.getCodlibro() == null) {
                this.estado = EstadoDelPaso.ERROR;
            } else {
                this.estado = EstadoDelPaso.COMPLETO;
            }

            return libro;

        } catch (Exception e) {
            this.estado = EstadoDelPaso.ERROR;
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public Boolean revertir(Object val) {
        if (val == null) {
            return true;
        }

        return cliente.post()
                .uri("/api/libros/revertir")
                .body(BodyInserters.fromValue(val))
                .retrieve()
                .bodyToMono(Void.class)
                .map(x -> true)
                .onErrorReturn(false)
                .block();
    }

}
