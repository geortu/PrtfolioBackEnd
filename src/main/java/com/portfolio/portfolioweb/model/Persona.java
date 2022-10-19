/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.model;


import com.portfolio.portfolioweb.security.model.Usuario;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


import lombok.Getter;

import lombok.Setter;



@Getter @Setter
@Entity
public class Persona {
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
    
    
    @OneToOne (cascade = CascadeType.ALL)  
    @JoinColumn(name="id_domicilio")
    private Domicilio domicilio;
    
    
    
    
    
    //@OneToMany(mappedBy = "persona",cascade = CascadeType.ALL)
    //private List<ExperienciaLaboral> listaexperiencia;

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
