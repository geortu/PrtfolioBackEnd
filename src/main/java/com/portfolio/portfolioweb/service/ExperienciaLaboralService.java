/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.ExperienciaLaboral;
import com.portfolio.portfolioweb.repository.ExperienciaLaboralRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{
    @Autowired
    private ExperienciaLaboralRepository expRepo;
    @Override
    public List<ExperienciaLaboral> getExperiencia() {
       return expRepo.findAll();
    }

    @Override
    public void saveExperiencia(ExperienciaLaboral exp) {
        expRepo.save(exp);
    }

    @Override
    public void deleteExperiencia(int id) {
       expRepo.deleteById(id);
    }

    @Override
    public ExperienciaLaboral findExperiencia(int id) {
       return expRepo.findById(id).orElse(null);
    }
    @Override
     public List<ExperienciaLaboral> findById_persona(int id){
         return expRepo.findById_persona(id);
     }
      @Override
     public List<ExperienciaLaboral> findByPersonaUser(String email){
         return expRepo.findByPersonaUser(email);
     }
    
}
