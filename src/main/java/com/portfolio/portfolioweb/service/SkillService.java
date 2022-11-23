/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Skill;
import com.portfolio.portfolioweb.repository.SkillRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<Skill> findById_persona(int id) {
      return skillRepository.findById_persona(id);
    }

    @Override
    public List<Skill> getSkill() {
        return skillRepository.findAll();
    }

    @Override
    public void saveSkill(Skill ski) {
        skillRepository.save(ski);
    }

    @Override
    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(int id) {
       return skillRepository.findById(id).orElse(null);
    }
    
}
