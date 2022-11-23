
package com.portfolio.portfolioweb.repository;


import com.portfolio.portfolioweb.model.Educacion;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository  extends JpaRepository<Educacion, Integer> {
     @Query(value = "SELECT * FROM educacion  WHERE persona_id =?1",nativeQuery = true)
    List<Educacion> findByPersona_id( int id);
    
}
