/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.repository;

import com.portfolio.portfolioweb.model.ExperienciaLaboral;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer>{
    
    @Query(value = "SELECT * FROM experiencia_laboral  WHERE id_persona =?1",nativeQuery = true)
    List<ExperienciaLaboral> findById_persona( int id);
    
    @Query(value ="SELECT * FROM experiencia_laboral INNER JOIN persona ON experiencia_laboral.id_persona=persona.id where email=?1",
            nativeQuery = true)
     List<ExperienciaLaboral> findByPersonaUser( String email);
}
