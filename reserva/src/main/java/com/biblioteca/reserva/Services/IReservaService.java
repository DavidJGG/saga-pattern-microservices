/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.reserva.Services;

import com.biblioteca.reserva.Models.ReservaREQ;
import java.util.Map;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author DGG
 */
public interface IReservaService {
    
    public Map<String, Object> reservar(ReservaREQ req);
    
}
