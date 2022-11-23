
package com.portfolio.portfolioweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "skill")
@Table
public class Skill implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private double porcentaje;
    @ManyToOne()
   @JsonIgnore   
   private Persona persona;

    public Skill() {
    }

    public Skill(String nombre, double porcentaje, Persona persona) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.persona = persona;
    }
    

    
    
    
}
