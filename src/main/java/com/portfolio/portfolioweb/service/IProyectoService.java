/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Proyecto;
import java.util.List;

/**
 *
 * @author artur
 */
public interface IProyectoService {
    public List<Proyecto> findById_persona(int id);   
    public List<Proyecto> getProyecto();
    public void saveProyecto(Proyecto pro);
    public void deleteProyecto(int id);
    public Proyecto findProyecto(int id);
    
}
