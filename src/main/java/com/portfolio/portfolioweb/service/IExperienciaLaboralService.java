/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.ExperienciaLaboral;
import java.util.List;


public interface IExperienciaLaboralService {
    public List<ExperienciaLaboral> findById_persona(int id);
    public List<ExperienciaLaboral> getExperiencia();
    public void saveExperiencia(ExperienciaLaboral exp);
    public void deleteExperiencia(int id);
    public ExperienciaLaboral findExperiencia(int id);
    
}
