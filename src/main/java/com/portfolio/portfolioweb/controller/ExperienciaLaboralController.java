/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.controller;




import com.portfolio.portfolioweb.dto.ExperienciaLaboralDto;
import com.portfolio.portfolioweb.model.ExperienciaLaboral;
import com.portfolio.portfolioweb.service.IExperienciaLaboralService;
import com.portfolio.portfolioweb.service.IPersonaService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService ExperienciaService;
    @Autowired
    private IPersonaService interPersona;
    
    
    
    @GetMapping("/experiencia/traer")
    public List<ExperienciaLaboral> getExperiencia(){
    
    return ExperienciaService.getExperiencia();
}
    
    @GetMapping("/experiencia/{id}")
    public List<ExperienciaLaboral> getExperienciasByIdPersona(@PathVariable int id){
    
    return ExperienciaService.findById_persona(id);
}
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@ModelAttribute ExperienciaLaboralDto expDto){  
          ExperienciaLaboral exp=new ExperienciaLaboral();
        try {
        exp.setNombre_empresa(expDto.getNombre_empresa());
        exp.setDescripcion(expDto.getDescripcion());
        exp.setFecha_inicio(expDto.getFecha_inicio());
        exp.setFecha_fin(expDto.getFecha_inicio());
        exp.setPuesto(expDto.getPuesto());
        exp.setPersona(interPersona.findPersona(expDto.getId_perosona()));
        if(!expDto.getLogo().isEmpty()){  
             exp.setLogo(interPersona.compressImage(expDto.getLogo().getBytes()));    }          
            
               
            } catch (IOException ex) {
                Logger.getLogger(ExperienciaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        ExperienciaService.saveExperiencia(exp);
        return "La Experiencia Laboral fue creada correctamente";
    }
    @PutMapping("/experiencia/editar")
    public ExperienciaLaboral updateExperineciaLaboral(@PathVariable int id,@ModelAttribute ExperienciaLaboralDto expDto ) {     
        
        ExperienciaLaboral exp=ExperienciaService.findExperiencia(id);
        try {
        exp.setNombre_empresa(expDto.getNombre_empresa());
        exp.setDescripcion(expDto.getDescripcion());
        exp.setFecha_inicio(expDto.getFecha_inicio());
        exp.setFecha_fin(expDto.getFecha_inicio());
        exp.setPuesto(expDto.getPuesto());
        if(!expDto.getLogo().isEmpty()){  
             exp.setLogo(interPersona.compressImage(expDto.getLogo().getBytes()));     
        }          
            
               
            } catch (IOException ex) {
                Logger.getLogger(ExperienciaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        ExperienciaService.saveExperiencia(exp);
        return exp;
       
    }
    
}
