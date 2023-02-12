/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Services;

import com.biblioteca.orquestador.Models.EstadoDelPaso;
import com.biblioteca.orquestador.Models.Libro;
import com.biblioteca.orquestador.Models.Mesa;
import com.biblioteca.orquestador.Models.ReservaMesaREQ;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author DGG
 */
public class ReservarMesa implements Paso<Mesa, Boolean> {

    private ReservaMesaREQ reservaReq;
    private WebClient cliente;
    private EstadoDelPaso estado = EstadoDelPaso.PENDIENTE;

    public ReservarMesa(ReservaMesaREQ reservaReq, WebClient cliente) {
        this.reservaReq = reservaReq;
        this.cliente = cliente;
    }

    @Override
    public EstadoDelPaso getEstado() {
        return this.estado;
    }

    @Override
    public Mesa procesar() {

        try {

            Mesa mesa = cliente.post()
                    .uri("/api/mesas/reservar")
                    .body(BodyInserters.fromValue(reservaReq))
                    .retrieve()
                    .onStatus(
                            HttpStatus.NOT_ACCEPTABLE::equals,
                            res -> res.bodyToMono(String.class).map(x -> new Exception("Mesa no disponible"))
                    )
                    .bodyToMono(Mesa.class)
                    .block();

            if (mesa.getCodmesa() == null) {
                this.estado = EstadoDelPaso.ERROR;
            } else {
                this.estado = EstadoDelPaso.COMPLETO;
            }

            return mesa;

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
                .uri("/api/mesas/revertir")
                .body(BodyInserters.fromValue(val))
                .retrieve()
                .bodyToMono(Void.class)
                .map(x -> true)
                .onErrorReturn(false)
                .block();
    }

}
