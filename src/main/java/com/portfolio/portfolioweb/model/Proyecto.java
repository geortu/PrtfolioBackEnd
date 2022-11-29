
package com.portfolio.portfolioweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "proyecto")
@Table
public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    private String descripcion;
    @NotNull     
    private String fecha;
    
    
    private String link;
    
   @ManyToOne()
   @JsonIgnore   
   private Persona persona;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String fecha, String link, Persona persona) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;
        this.persona = persona;
    }
   
    
}
