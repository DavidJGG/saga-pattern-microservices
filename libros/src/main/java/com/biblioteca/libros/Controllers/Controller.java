/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.libros.Controllers;

import com.biblioteca.libros.Services.ILibroService;
import com.biblioteca.libros.models.Libro;
import com.biblioteca.libros.models.ReservaLibroREQ;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DGG
 */

@RestController
@RequestMapping("/api")
public class Controller {
    
    @Autowired
    private ILibroService libroService;
    
    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getLibros(){
        return libroService.listarLibros();
    }
    
    @PostMapping("/libros/reservar")
    public ResponseEntity<Libro> reservar(@RequestBody ReservaLibroREQ req){
        return libroService.reservarLibro(req.getCodlibro());
    }
    
    @PostMapping("/libros/revertir")
    public ResponseEntity<Libro> revertir(@RequestBody Libro req){
        return libroService.revertirReserva(req);
    }    
}
