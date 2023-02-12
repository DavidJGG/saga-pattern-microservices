/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.mesas.Repository;

import com.biblioteca.mesas.Models.Mesa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DGG
 */
@Repository
public interface MesaRepository extends CrudRepository<Mesa, Integer>{
    
    public Mesa findByNivelAndNumeroAndDisponible(Integer nivel, Integer numero, Integer disponible);
    
}
