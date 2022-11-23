
package com.portfolio.portfolioweb.controller;


import com.portfolio.portfolioweb.dto.SkillDto;
import com.portfolio.portfolioweb.model.Skill;
import com.portfolio.portfolioweb.service.ISkillService;
import com.portfolio.portfolioweb.service.IPersonaService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    @Autowired
    private ISkillService skillService;
    @Autowired
    private IPersonaService interPersona;
    
    
    @GetMapping("/skill/traer")
    @ResponseBody
    public List<Skill> getSkill(){    
    return skillService.getSkill();
    
}
    @GetMapping("/skill/unica/{id}")
    @ResponseBody
    public Skill getSkillById(@PathVariable int id){             
    return skillService.findSkill(id) ;
    }
    @GetMapping("/skill/{id}")
    @ResponseBody
    public List<Skill> getSkillByIdPersona(@PathVariable int id){    
        
    return skillService.findById_persona(id) ;
    
}
   
    @PostMapping("/skill/crear")    
    public Skill createSkill(@ModelAttribute SkillDto skillDto,BindingResult bindingresult){ 
          
          Skill skill = new Skill();
          skill.setNombre(skillDto.getNombre());
          skill.setPorcentaje(skillDto.getPorcentaje());
          skill.setPersona(interPersona.findPersona(skillDto.getId_persona()));        
        
            
        
        
        skillService.saveSkill(skill);
          return skill;
        
    }
    @PutMapping("/skill/editar/{id}")
    public Skill updateSkill(@PathVariable int id,@ModelAttribute SkillDto skillDto,BindingResult bindingresult ) {     
        
          Skill skill=skillService.findSkill(id);             
         
          skill.setNombre(skillDto.getNombre());
          skill.setPorcentaje(skillDto.getPorcentaje());
            
             
            
        
        
        skillService.saveSkill(skill);
        return skill;
       
    }
    @DeleteMapping("/skill/borrar/{id}")    
    public void deleteSkill(@PathVariable int id){
        skillService.deleteSkill(id);
        
    }
    
}
