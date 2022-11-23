/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Skill;
import java.util.List;


public interface ISkillService {
    public List<Skill> findById_persona(int id);   
    public List<Skill> getSkill();
    public void saveSkill(Skill ski);
    public void deleteSkill(int id);
    public Skill findSkill(int id);
    
}
