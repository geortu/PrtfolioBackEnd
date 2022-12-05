/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "educacion")
@Table
public class Educacion implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String establecimiento;
  private String titulo;
  private String carrera;
  private double puntaje;
  private String inicio;
  private String fin;
   @Column(name = "logo", length = 100000)
   private byte[] logo;
  
   
  
   @ManyToOne()
   @JsonIgnore   
   private Persona persona;

    public Educacion(String establecimiento, String titulo, String carrera, double puntaje, String inicio, String fin, byte[] logo, Persona persona) {
        this.establecimiento = establecimiento;
        this.titulo = titulo;
        this.carrera = carrera;
        this.puntaje = puntaje;
        this.inicio = inicio;
        this.fin = fin;
        this.logo = logo;
        this.persona = persona;
    }

    public Educacion() {
    }
  
			
    
}
