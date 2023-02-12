/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.reserva.Controllers;

import com.biblioteca.reserva.Models.ReservaREQ;
import com.biblioteca.reserva.Services.IReservaService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
public class controller {
    
    @Autowired
    private IReservaService servicio;
    
    @PostMapping("/reservar")
    public Map<String, Object> getLibros(@RequestBody ReservaREQ req){
        
        return servicio.reservar(req);
                
    }
    
}
