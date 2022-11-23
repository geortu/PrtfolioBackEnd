
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Educacion;
import java.util.List;


public interface IEducacionService {
    public List<Educacion> findById_persona(int id);   
    public List<Educacion> getEducacion();
    public void saveEducacion(Educacion edu);
    public void deleteEducacion(int id);
    public Educacion findEducacion(int id);
}
