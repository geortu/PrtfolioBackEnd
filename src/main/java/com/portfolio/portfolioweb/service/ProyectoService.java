/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Proyecto;
import com.portfolio.portfolioweb.repository.ProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoService implements IProyectoService{
     @Autowired
     private ProyectoRepository proyectoRepository;
    @Override
    public List<Proyecto> findById_persona(int id) {
     return proyectoRepository.findById_persona(id);
    }

    @Override
    public List<Proyecto> getProyecto() {
        return proyectoRepository.findAll();
       
    }

    @Override
    public void saveProyecto(Proyecto pro) {
       proyectoRepository.save(pro);
    }

    @Override
    public void deleteProyecto(int id) {
       proyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(int id) {
        return proyectoRepository.findById(id).orElse(null);
    }
    
}
