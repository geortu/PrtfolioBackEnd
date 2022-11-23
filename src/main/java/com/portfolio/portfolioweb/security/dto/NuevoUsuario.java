/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.security.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class NuevoUsuario {
    @NotBlank
    private String nombre;   
    @NotBlank
    @Email
    private String nombreUsuario;
    private String apellido;   
    @NotBlank
    private String fechaNacimiento;
    
   
    private String nacionalidad;
    
    private String direccion;   
    private String numero; 
    private String provincia;
    @NotBlank
    private String password;
    
    private Set<String> roles= new HashSet<>();
    
}
