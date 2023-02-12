/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.reserva.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author DGG
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReservaREQ {
    
    private Integer codlibro;
    private Integer nivelMesa;
    private Integer numeroMesa;
    
}
