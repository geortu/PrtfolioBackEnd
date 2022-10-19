
package com.portfolio.portfolioweb.repository;


import com.portfolio.portfolioweb.model.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducacionRepository  extends JpaRepository<Educacion, Integer> {
    
}
