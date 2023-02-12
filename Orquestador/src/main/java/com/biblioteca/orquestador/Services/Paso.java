/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.biblioteca.orquestador.Services;

import com.biblioteca.orquestador.Models.EstadoDelPaso;

/**
 *
 * @author DGG
 */
public interface Paso<T, V> {
    
    public EstadoDelPaso getEstado();
    
    public T procesar();
    
    public V revertir(Object objeto);
    
}
