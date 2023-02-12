/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.orquestador.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author DGG
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReservaMesaREQ {
    
    private Integer numero;
    private Integer nivel;
    
}
