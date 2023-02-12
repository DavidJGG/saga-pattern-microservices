/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.mesas.Services;

import com.biblioteca.mesas.Models.Mesa;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author DGG
 */

public interface IMesaService {
    
    public ResponseEntity<List<Mesa>> listarMesas();
    
    public ResponseEntity<Mesa> reservarMesa(Integer numeroMesa, Integer nivel);
    
    public ResponseEntity<Mesa> revertirReserva(Mesa mesa);
    
}
