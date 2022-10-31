
package com.portfolio.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class ExperienciaLaboralDto {
   private String nombre_empresa;
   private String puesto;
   private String fecha_inicio;
   private String fecha_fin;
   private String descripcion;
   private MultipartFile logo;
   private int id_persona;
    
}
