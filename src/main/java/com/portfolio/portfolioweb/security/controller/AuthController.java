/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.security.controller;

import com.portfolio.portfolioweb.model.Domicilio;
import com.portfolio.portfolioweb.model.Persona;
import com.portfolio.portfolioweb.security.dto.JwtDto;
import com.portfolio.portfolioweb.security.dto.LoginUsuario;
import com.portfolio.portfolioweb.security.dto.NuevoUsuario;
import com.portfolio.portfolioweb.security.enumerador.RolNombre;
import com.portfolio.portfolioweb.security.jwt.JwtProvider;
import com.portfolio.portfolioweb.security.model.Rol;
import com.portfolio.portfolioweb.security.model.Usuario;
import com.portfolio.portfolioweb.security.service.RolService;
import com.portfolio.portfolioweb.security.service.UsuarioService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UsuarioService usuarioservice;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;
    
    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario,BindingResult bindingresult){
        if (bindingresult.hasErrors()) {
            return new ResponseEntity("Campos mal puesto o mail invalido",HttpStatus.BAD_REQUEST);
            
        }
        if (usuarioservice.existsByNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity("El usuario ya existe",HttpStatus.BAD_REQUEST);
            
        }
        /*if (usuarioservice.existsByEmail(nuevoUsuario.getEmail())){
            return new ResponseEntity("El mail ya existe",HttpStatus.BAD_REQUEST);            
        }*/
        
        /*Usuario usuario= new Usuario(nuevoUsuario.getNombre(),nuevoUsuario.getNombreUsuario(),
                nuevoUsuario.getEmail(),  passwordEncoder.encode(nuevoUsuario.getPassword()));*/
        Usuario usuario= new Usuario(nuevoUsuario.getNombreUsuario(),passwordEncoder.encode(nuevoUsuario.getPassword()));
        Set<Rol> roles= new HashSet<>();
        roles.add(rolService.getByRolNombre(RolNombre.ROL_USER).get());
        if(nuevoUsuario.getRoles().contains("admin"))
            roles.add(rolService.getByRolNombre(RolNombre.ROL_ADMIN).get());
        usuario.setRoles(roles);
        usuario.setPersona(new Persona(nuevoUsuario.getNombre(),nuevoUsuario.getApellido(),
        nuevoUsuario.getFechaNacimiento(),nuevoUsuario.getNacionalidad(),nuevoUsuario.getNombreUsuario(),
        new Domicilio(nuevoUsuario.getDireccion(),nuevoUsuario.getNumero(),nuevoUsuario.getProvincia()) ));
        usuarioservice.save(usuario);
        return new ResponseEntity("Usuario Guardado",HttpStatus.CREATED);
        
    }
    @PostMapping("/login")
     public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario,BindingResult bindingresult){
         
        if (bindingresult.hasErrors()) {
           return new ResponseEntity("Campos mal puesto o mail invalido",HttpStatus.BAD_REQUEST);            
        }
        Authentication authentication=
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
       SecurityContextHolder.getContext().setAuthentication(authentication);
       String jwt= jwtProvider.generatetoken(authentication);
       UserDetails userDetails= (UserDetails)authentication.getPrincipal();       
       JwtDto jwtDto=new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities());
       
       return new ResponseEntity<>(jwtDto,HttpStatus.OK);
       
    }
}