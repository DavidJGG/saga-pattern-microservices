/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.reserva.Services;

import com.biblioteca.reserva.Models.ReservaREQ;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author DGG
 */
@Service
public class ReservaService implements IReservaService{

    @Autowired
    private WebClient cliente;

    @Override
    public Map<String, Object> reservar(ReservaREQ req) {

        Map<String, Object> mapa = cliente.post()
                .uri("/api/reservar")
                .body(BodyInserters.fromValue(req))
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        
        return mapa;

    }

}
