/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Controllers;

import com.biblioteca.orquestador.Models.ReservaREQ;
import com.biblioteca.orquestador.Services.IOrquestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DGG
 */

@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    private IOrquestadorService orquestador;
    
    @PostMapping("/reservar")
    public ResponseEntity<Object> getLibros(@RequestBody ReservaREQ req){
        
        return orquestador.orquestar(req);
                
    }
    
}
