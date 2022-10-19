/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.security.service;

import com.portfolio.portfolioweb.security.model.Usuario;
import com.portfolio.portfolioweb.security.repository.UsuarioRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
     public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
     return usuarioRepository.findByNombreUsuario(nombreUsuario);
     }
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
     /*public boolean existsByEmail(String email){
         return usuarioRepository.existsByEmail(email);
     
     }*/
     public void save(Usuario usuario){
     usuarioRepository.save(usuario);
     }
}
