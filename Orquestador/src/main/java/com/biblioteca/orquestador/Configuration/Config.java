/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author DGG
 */

@Configuration
public class Config {
    

    
    @Bean("libros")
    public WebClient clienteLibros(@Value("${url.libros}") String endpoint){
        return WebClient.builder()
                .baseUrl(endpoint)
                .build();
    }

    @Bean("mesas")
    public WebClient clienteMesas(@Value("${url.mesas}") String endpoint){
        return WebClient.builder()
                .baseUrl(endpoint)
                .build();
    }
    
    
}
