
package com.portfolio.portfolioweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;

import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "experiencia_laboral")
@Table
public class ExperienciaLaboral implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombre_empresa;
   private String puesto;
   private String fecha_inicio;
   private String fecha_fin;
   private String descripcion;
   private byte[] logo;
   
   @ManyToOne()
   @JsonIgnore   
   private Persona persona;

    public ExperienciaLaboral(String nombre_empresa, String puesto, String fecha_fin, String descripcion, byte[] logo, Persona persona) {
        this.nombre_empresa = nombre_empresa;
        this.puesto = puesto;
        this.fecha_fin = fecha_fin;
        this.descripcion = descripcion;
        this.logo = logo;
        this.persona = persona;
    }

    public ExperienciaLaboral() {
    }
   
   
   
     
}
