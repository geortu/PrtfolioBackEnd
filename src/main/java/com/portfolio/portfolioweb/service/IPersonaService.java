/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Persona;
import java.util.List;
import java.util.Optional;


public interface IPersonaService {
    public List<Persona> getPersonas();
    public void savePersona(Persona per);
    public void deletePersona(int id);
    public Persona  findPersona(int id);
    boolean existsById(int id);
    Persona getByEmail(String email);
    boolean existsByEmail(String email);
    byte[] compressImage(byte[] data);
    byte[] decompressImage(byte[] data);
  
    
    
    
}
