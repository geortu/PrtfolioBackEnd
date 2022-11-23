
package com.portfolio.portfolioweb.repository;

import com.portfolio.portfolioweb.model.Skill;
import com.portfolio.portfolioweb.model.Skill;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer>{
    @Query(value = "SELECT * FROM experiencia_laboral  WHERE persona_id =?1",nativeQuery = true)
    List<Skill> findById_persona( int id);
}
