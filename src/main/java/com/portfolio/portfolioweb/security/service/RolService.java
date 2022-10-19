/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.security.service;

import com.portfolio.portfolioweb.security.enumerador.RolNombre;
import com.portfolio.portfolioweb.security.model.Rol;
import com.portfolio.portfolioweb.security.repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
       return rolRepository.findByRolNombre(rolNombre);    
    }
    public void save(Rol rol){
        rolRepository.save(rol);
    } 
    
}
