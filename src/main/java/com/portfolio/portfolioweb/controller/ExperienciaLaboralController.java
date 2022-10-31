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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExperienciaLaboralController {
    
    @Autowired
    private IExperienciaLaboralService ExperienciaService;
    @Autowired
    private IPersonaService interPersona;
    
    
    
    @GetMapping("/experiencia/traer")
    @ResponseBody
    public List<ExperienciaLaboral> getExperiencia(){
    
    return ExperienciaService.getExperiencia();
}
    @GetMapping("/experiencia/unica/{id}")
    @ResponseBody
    public ExperienciaLaboral getExperienciasById(@PathVariable int id){
     ExperienciaLaboral ex=ExperienciaService.findExperiencia(id);
        
             byte[] datalogo =ex.getLogo();
             ex.setLogo(interPersona.decompressImage(datalogo));
        
    return ex ;
    }
    @GetMapping("/experiencia/{id}")
    @ResponseBody
    public List<ExperienciaLaboral> getExperienciasByIdPersona(@PathVariable int id){
     List<ExperienciaLaboral> lista=ExperienciaService.findById_persona(id);
        for (ExperienciaLaboral ex : lista) {
             byte[] datalogo =ex.getLogo();
             ex.setLogo(interPersona.decompressImage(datalogo));
        }
    return lista ;
    
}
    @GetMapping("/experiencia/detalle/{email}")
    @ResponseBody
    public List<ExperienciaLaboral> getExperienciasByPerosnaUser(@PathVariable String email ){
     List<ExperienciaLaboral> lista=ExperienciaService.findByPersonaUser(email);
        for (ExperienciaLaboral ex : lista) {
             byte[] datalogo =ex.getLogo();
             ex.setLogo(interPersona.decompressImage(datalogo));
        }
    return lista ;
}
    @PostMapping("/experiencia/crear")    
    public void createExperiencia(@ModelAttribute ExperienciaLaboralDto expDto){  
          ExperienciaLaboral exp=new ExperienciaLaboral();
        try {
        exp.setNombre_empresa(expDto.getNombre_empresa());
        exp.setDescripcion(expDto.getDescripcion());
        exp.setFecha_inicio(expDto.getFecha_inicio());
        exp.setFecha_fin(expDto.getFecha_fin());
        exp.setPuesto(expDto.getPuesto());
        //exp.setPersona(interPersona.findPersona(expDto.getId_persona()));
        if(expDto.getLogo()!=null){  
             exp.setLogo(interPersona.compressImage(expDto.getLogo().getBytes()));    }          
            
               
            } catch (IOException ex) {
                Logger.getLogger(ExperienciaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        ExperienciaService.saveExperiencia(exp);
       // return "Experiencia insertada";
        
    }
    @PutMapping("/experiencia/editar/{id}")
    public ExperienciaLaboral updateExperineciaLaboral(@PathVariable int id,@ModelAttribute ExperienciaLaboralDto expDto ) {     
        
        ExperienciaLaboral exp=ExperienciaService.findExperiencia(id);
        try {
        exp.setNombre_empresa(expDto.getNombre_empresa());
        exp.setDescripcion(expDto.getDescripcion());
        exp.setFecha_inicio(expDto.getFecha_inicio());
        exp.setFecha_fin(expDto.getFecha_fin());
        exp.setPuesto(expDto.getPuesto());
        if(expDto.getLogo()!=null){  
             exp.setLogo(interPersona.compressImage(expDto.getLogo().getBytes()));     
        }          
            
               
            } catch (IOException ex) {
                Logger.getLogger(ExperienciaLaboralController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        ExperienciaService.saveExperiencia(exp);
        return exp;
       
    }
    @DeleteMapping("/experiencia/borrar/{id}")    
    public void deleteExperiencia(@PathVariable int id){
        ExperienciaService.deleteExperiencia(id);
        
    }
    
}
