/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Services;

import com.biblioteca.orquestador.Models.ReservaREQ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.function.EntityResponse;

/**
 *
 * @author DGG
 */

public interface IOrquestadorService {
    
    public ResponseEntity<Object> orquestar(ReservaREQ req);
    
}
