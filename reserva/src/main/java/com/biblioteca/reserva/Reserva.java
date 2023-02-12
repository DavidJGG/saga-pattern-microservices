/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.biblioteca.reserva;

import com.biblioteca.reserva.Models.ReservaREQ;
import com.biblioteca.reserva.Services.IReservaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author DGG
 */

@SpringBootApplication
public class Reserva {

    public static void main(String[] args) {
        SpringApplication.run(Reserva.class, args);
    }
    
    @Autowired
    private IReservaService servicio;
    
    @PostConstruct
    private void pruebaDelPatron(){
        /*prueba_reservaCorrecta();
        prueba_reservaLibroFalla();
        prueba_reservaMesaFalla();
        prueba_reservaCorrecta_segundaFallida();*/
    }
    
    
    public void prueba_reservaCorrecta(){
        var reserva = ReservaREQ.builder()
                .codlibro(1)
                .nivelMesa(2)
                .numeroMesa(1)
                .build()
                ;
        
        var res = servicio.reservar(reserva);
        System.out.println("PRUEBA CORRECTA:");
        printJson(res);
        System.out.println("");        
        System.out.println("");

                
    }
    
    public void prueba_reservaLibroFalla(){
        var reserva = ReservaREQ.builder()
                .codlibro(1)
                .nivelMesa(2)
                .numeroMesa(1)
                .build()
                ;
        
        var res = servicio.reservar(reserva);
        System.out.println("RESERVAR LIBRO FALLA:");
        printJson(res);
        System.out.println("");        
        System.out.println("");
        
    }
    
    public void prueba_reservaMesaFalla(){
        var reserva = ReservaREQ.builder()
                .codlibro(3)
                .nivelMesa(2)
                .numeroMesa(1)
                .build()
                ;
        
        var res = servicio.reservar(reserva);
        System.out.println("RESERVAR MESA FALLA:");
        printJson(res);
        System.out.println("");        
        System.out.println("");
    }
    
    
    public void prueba_reservaCorrecta_segundaFallida(){
        var reserva = ReservaREQ.builder()
                .codlibro(4)
                .nivelMesa(2)
                .numeroMesa(3)
                .build()
                ;
        
        
        var res = servicio.reservar(reserva);
        System.out.println("-----> Primera Correcta:");
        printJson(res);
        System.out.println("");        
        System.out.println("");
        
        res = servicio.reservar(reserva);
        System.out.println("-----> Segunda fallida por el libro");
        printJson(res);
        System.out.println("");        
        System.out.println("");
        
        
        
        reserva = ReservaREQ.builder()
                .codlibro(5)
                .nivelMesa(2)
                .numeroMesa(3)
                .build()
                ;
        
        res = servicio.reservar(reserva);
        System.out.println("-----> Tercera fallida por la mesa");
        printJson(res);
        System.out.println("");        
        System.out.println("");
        
    }
    
    
    private void printJson(Map<String, Object> val){
        try {
            System.out.println(new ObjectMapper().writeValueAsString(val));
            System.out.println("");
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
