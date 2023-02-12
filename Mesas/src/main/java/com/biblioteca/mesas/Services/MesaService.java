/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.mesas.Services;

import com.biblioteca.mesas.Models.Mesa;
import com.biblioteca.mesas.Repository.MesaRepository;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author DGG
 */

@Service
public class MesaService implements IMesaService{
    
    @Autowired
    private MesaRepository mesaRepo;

    @Override
    public ResponseEntity<List<Mesa>> listarMesas() {
        List<Mesa> lsMesas = new LinkedList<>();
        mesaRepo.findAll().forEach(lsMesas::add);
        return new ResponseEntity<>(lsMesas, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Mesa> reservarMesa(Integer numeroMesa, Integer nivel) {
        Mesa mesa = mesaRepo.findByNivelAndNumeroAndDisponible(nivel, numeroMesa, 1);
        if(mesa==null)
            return new ResponseEntity<>(Mesa.builder().build(), HttpStatus.NOT_ACCEPTABLE);
            
        mesa.setDisponible(0);
        
        mesaRepo.save(mesa);
        
        return new ResponseEntity<>(mesa, HttpStatus.OK);
        
    }

    @Override
    public ResponseEntity<Mesa> revertirReserva(Mesa mesa) {
        if(mesa.getCodmesa()==null)
            return new ResponseEntity<>(mesa, HttpStatus.BAD_REQUEST); 
        
        mesa.setDisponible(1);
        mesaRepo.save(mesa);
        return new ResponseEntity<>(mesa, HttpStatus.OK); 
    }
    
}
