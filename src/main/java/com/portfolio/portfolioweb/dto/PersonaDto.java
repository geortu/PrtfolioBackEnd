/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


 @Getter @Setter
public class PersonaDto {
    private MultipartFile foto_portada;
    
    private MultipartFile foto_perfil;
    
    private String nombre;
        
    private String apellido;
    
    private String nacionalidad;
    
    private String fecha_nacimiento;    
    
    private String sobre_mi;
    
    private String ocupacion; 
    
    private String direccion;
    
    private String numero;     
    
    private String provincia;
}
