/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.libros.Services;

import com.biblioteca.libros.Repository.LibroRepository;
import com.biblioteca.libros.models.Libro;
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
public class LibroService implements ILibroService{
    
    @Autowired
    private LibroRepository libroRepo;

    @Override
    public ResponseEntity<List<Libro>> listarLibros() {
        
        List<Libro> lsLibros = new LinkedList<>();
        libroRepo.findAll().forEach(lsLibros::add);
        return new ResponseEntity<>(lsLibros, HttpStatus.OK);
        
    }

    @Override
    public ResponseEntity<Libro> reservarLibro(Integer codlibro) {
        
        Libro libro = libroRepo.findByCodlibroAndDisponible(codlibro, 1);
        if(libro == null)
            return new ResponseEntity<>(Libro.builder().build(), HttpStatus.NOT_ACCEPTABLE);
                
        libro.setDisponible(0);
        
        libroRepo.save(libro);
        
        return new ResponseEntity<>(libro, HttpStatus.OK);
        
    }

    @Override
    public ResponseEntity<Libro> revertirReserva(Libro libro) {
        
        if(libro.getCodlibro()==null)
            return new ResponseEntity<>(libro, HttpStatus.BAD_REQUEST); 
        
        libro.setDisponible(1);
        
        libroRepo.save(libro);
        
        return new ResponseEntity<>(libro, HttpStatus.OK);
        
    }

    
    
    
    
}
