/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Domicilio;
import com.portfolio.portfolioweb.repository.DomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService{
    @Autowired
    private DomicilioRepository domirepo;
    @Override
    public List<Domicilio> getDomicilio() {
     return domirepo.findAll();
    }

    @Override
    public void saveDomicilio(Domicilio dom) {
        domirepo.save(dom);
    }

    @Override
    public void deleteDomicilio(int id) {
       domirepo.deleteById(id);
    }

    @Override
    public Domicilio findDomicilio(int id) {
        return domirepo.findById(id).orElse(null);
    }
    
}
