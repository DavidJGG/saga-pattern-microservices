/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.reserva.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author DGG
 */
@Configuration
public class config {

    @Bean("orquestador")
    public WebClient clienteLibros(@Value("${url.orquestador}") String endpoint) {
        return WebClient.builder()
                .baseUrl(endpoint)
                .build();
    }
}
