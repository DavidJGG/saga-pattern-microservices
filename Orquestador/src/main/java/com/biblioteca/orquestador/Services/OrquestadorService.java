/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Services;

import com.biblioteca.orquestador.Models.EstadoDelPaso;
import com.biblioteca.orquestador.Models.Libro;
import com.biblioteca.orquestador.Models.Mesa;
import com.biblioteca.orquestador.Models.ReservaLibroREQ;
import com.biblioteca.orquestador.Models.ReservaMesaREQ;
import com.biblioteca.orquestador.Models.ReservaREQ;
import com.biblioteca.orquestador.Models.ReservaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.function.EntityResponse;

/**
 *
 * @author DGG
 */

@Service
public class OrquestadorService implements IOrquestadorService{
    
    @Autowired
    @Qualifier("libros")
    private WebClient clienteLibros;
    
    @Autowired
    @Qualifier("mesas")
    private WebClient clienteMesas;
    
    @Override
    public ResponseEntity<Object> orquestar(ReservaREQ req){
        
        Paso libros = getPasoResrvaLibro(req);
        Paso mesas = getPasoResrvaMesa(req);
        
        Libro libro = (Libro)libros.procesar();
        if(libros.getEstado().equals(EstadoDelPaso.ERROR))
        {
            var result = ReservaResponse.builder()
                .error(true)
                .msg("No se pudo reservar el libro")
                .build();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        
        Mesa mesa = (Mesa)mesas.procesar();
        if(mesas.getEstado().equals(EstadoDelPaso.ERROR)){
            libros.revertir(libro);
            var result = ReservaResponse.builder()
                .error(true)
                .msg("No se pudo reservar la mesa")
                .build();
            
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
            
        var result = ReservaResponse.builder()
                .libro(libro)
                .mesa(mesa)
                .error(false)
                .msg("Operación exitosa")
                .build()
                ;
        
        return new ResponseEntity<>(result, HttpStatus.OK);
        
    }
    
    public Paso getPasoResrvaLibro(ReservaREQ req){
        
        var rl = ReservaLibroREQ.builder()
                .codlibro(req.getCodlibro())
                .build();
        
        return new ReservarLibro(rl, clienteLibros);
        
    }
    
    public Paso getPasoResrvaMesa(ReservaREQ req){
        var rm = ReservaMesaREQ.builder()
                .nivel(req.getNivelMesa())
                .numero(req.getNumeroMesa())
                .build();
        
        return new ReservarMesa(rm, clienteMesas);
        
    }
    
}
