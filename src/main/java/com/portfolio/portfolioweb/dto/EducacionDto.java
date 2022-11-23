
package com.portfolio.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class EducacionDto {
  
  private String establecimiento;
  private String titulo;
  private String carrera;
  private double puntaje;
  private String inicio;
  private String fin;
  private MultipartFile logo;
  private int id_persona;
    
}
