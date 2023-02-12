/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.libros.Services;

import com.biblioteca.libros.models.Libro;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author DGG
 */
public interface ILibroService {
    
    public ResponseEntity<List<Libro>> listarLibros();
    
    public ResponseEntity<Libro> reservarLibro(Integer codlibro);
    
    public ResponseEntity<Libro> revertirReserva(Libro libro);
    
}
