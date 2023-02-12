/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.libros.Repository;

import com.biblioteca.libros.models.Libro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DGG
 */

@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer>{
    
    public Libro findByCodlibroAndDisponible(Integer codlibre, Integer disponible);
    
}
