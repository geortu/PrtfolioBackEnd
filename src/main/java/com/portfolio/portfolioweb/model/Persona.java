/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.model;


import com.portfolio.portfolioweb.security.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import lombok.Getter;

import lombok.Setter;




@Getter @Setter
@Entity(name = "persona")
@Table
public class Persona implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
     @Column(name = "fecha_nacimiento")
    private String fecha_nacimiento;
    
    @NotNull
    private String nacionalidad;
    
    //private String foto_portada;
    
   // private String foto_perfil;
    @Column(name = "foto_portada", length = 1000)
    private byte [] foto_portada;
    @Column(name = "foto_perfil", length = 1000)
    private byte [] foto_perfil;
    
    private String sobre_mi;
    
    private String ocupacion;
    @NotNull
    private String email;
    private String telefono;
    
    
    @OneToOne (cascade = CascadeType.ALL)  
    @JoinColumn(name="id_domicilio")
    private Domicilio domicilio;
    
    @OneToMany(mappedBy = "persona",orphanRemoval = true)   
    private Set<ExperienciaLaboral> ExperienciasLaborales= new HashSet<>();
    
    @OneToMany(mappedBy = "persona",orphanRemoval = true)   
    private Set<Educacion> Educaciones= new HashSet<>();
    
    @OneToMany(mappedBy = "persona",orphanRemoval = true)   
    private Set<Skill> Skilles= new HashSet<>();
    
     @OneToMany(mappedBy = "persona",orphanRemoval = true)   
     private Set<Skill> proyectos= new HashSet<>();
    
  
    
    
    
    
    
   

    public Persona( String nombre, String apellido, String fecha_nacimiento, String nacionalidad, String email, Domicilio domicilio) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
        this.email = email;        
        this.domicilio = domicilio;
    }

    public Persona() {
    }
    
}
