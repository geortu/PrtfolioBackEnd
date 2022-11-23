
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
    private String telefono;
}
