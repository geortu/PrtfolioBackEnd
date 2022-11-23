
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Educacion;
import com.portfolio.portfolioweb.repository.EducacionRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private EducacionRepository eduexp;
    
    @Override
    public List<Educacion> findById_persona(int id) {
        return eduexp.findByPersona_id(id);
    }

    @Override
    public List<Educacion> getEducacion() {
       return eduexp.findAll();
    }

    @Override
    public void saveEducacion(Educacion edu) {
        eduexp.save(edu);
    }

    @Override
    public void deleteEducacion(int id) {
        eduexp.deleteById(id);
    }

    @Override
    public Educacion findEducacion(int id) {
        return eduexp.findById(id).orElse(null);
    }
    
}
