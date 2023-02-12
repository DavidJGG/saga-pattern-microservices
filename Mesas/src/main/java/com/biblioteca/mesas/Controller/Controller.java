/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.mesas.Controller;

import com.biblioteca.mesas.Models.Mesa;
import com.biblioteca.mesas.Models.ReservaMesaREQ;
import com.biblioteca.mesas.Services.IMesaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    private IMesaService mesaService;
    
    @GetMapping("/mesas")
    public ResponseEntity<List<Mesa>> getLibros(){
        return mesaService.listarMesas();
    }
    
    @PostMapping("/mesas/reservar")
    public ResponseEntity<Mesa> reservar(@RequestBody ReservaMesaREQ req){
        return mesaService.reservarMesa(req.getNumero(), req.getNivel());
    }
    
    @PostMapping("/mesas/revertir")
    public ResponseEntity<Mesa> revertir(@RequestBody Mesa req){
        return mesaService.revertirReserva(req);
    }   
    
}
