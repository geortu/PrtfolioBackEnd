/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.repository;

import com.portfolio.portfolioweb.model.Proyecto;
import com.portfolio.portfolioweb.model.Proyecto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
    @Query(value = "SELECT * FROM proyecto  WHERE persona_id =?1",nativeQuery = true)
    List<Proyecto> findById_persona( int id);
    
    @Query(value ="SELECT * FROM proyecto INNER JOIN persona ON proyecto.id_persona=persona.id where email=?1",
            nativeQuery = true)
     List<Proyecto> findByPersonaUser( String email);
    
}
