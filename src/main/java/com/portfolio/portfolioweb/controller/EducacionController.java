/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.controller;


import com.portfolio.portfolioweb.dto.EducacionDto;
import com.portfolio.portfolioweb.model.Educacion;
import com.portfolio.portfolioweb.service.IEducacionService;
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
public class EducacionController  {
    @Autowired
    private IEducacionService EducacionService;
    @Autowired
    private IPersonaService interPersona;
    
    
    
    @GetMapping("/educacion/traer")
    @ResponseBody
    public List<Educacion> getEducacion(){    
    return EducacionService.getEducacion();
    
}
    @GetMapping("/educacion/unica/{id}")
    @ResponseBody
    public Educacion getEducacionById(@PathVariable int id){
     Educacion edu=EducacionService.findEducacion(id);
        if(edu.getLogo()!=null){
             byte[] datalogo =edu.getLogo();
             edu.setLogo(interPersona.decompressImage(datalogo));
        }
        
    return edu ;
    }
    @GetMapping("/educacion/{id}")
    @ResponseBody
    public List<Educacion> getExperienciasByIdPersona(@PathVariable int id){
     List<Educacion> lista=EducacionService.findById_persona(id);
        for (Educacion edu : lista) {
            if(edu.getLogo()!=null){
             byte[] datalogo =edu.getLogo();
             edu.setLogo(interPersona.decompressImage(datalogo));
            }
        }
    return lista ;
    
}
   
    @PostMapping("/educacion/crear")    
    public Educacion createEducacion(@ModelAttribute EducacionDto eduDto,BindingResult bindingresult){  
          Educacion edu=new Educacion();
        try {
            
        edu.setEstablecimiento(eduDto.getEstablecimiento());
        edu.setTitulo(eduDto.getTitulo());
        edu.setCarrera(eduDto.getCarrera());
        edu.setPuntaje(eduDto.getPuntaje()); 
        edu.setInicio(eduDto.getInicio());
        edu.setFin(eduDto.getFin());  
        edu.setPersona(interPersona.findPersona(eduDto.getId_persona()));
        if(eduDto.getLogo()!= null){
            edu.setLogo(interPersona.compressImage(eduDto.getLogo().getBytes()));
            } 
            
               
        } catch (IOException ex) {
                  
                Logger.getLogger(EducacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        EducacionService.saveEducacion(edu);
        if(edu.getLogo()!=null){
             byte[] datalogo =edu.getLogo();
             edu.setLogo(interPersona.decompressImage(datalogo));
            }
        
        return edu;
        
    }
    @PutMapping("/educacion/editar/{id}")
    public Educacion updateEducacion(@PathVariable int id,@ModelAttribute EducacionDto eduDto,BindingResult bindingresult ) {     
        
        Educacion edu=EducacionService.findEducacion(id);
         try {
        edu.setEstablecimiento(eduDto.getEstablecimiento());
        edu.setTitulo(eduDto.getTitulo());
        edu.setCarrera(eduDto.getCarrera());
        edu.setPuntaje(eduDto.getPuntaje()); 
        edu.setInicio(eduDto.getInicio());
        edu.setFin(eduDto.getFin());  
        
           if(eduDto.getLogo()!= null){
           
                edu.setLogo(interPersona.compressImage(eduDto.getLogo().getBytes()));
            }
        } catch (IOException ex) {
                Logger.getLogger(EducacionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
            
             
            
        
        
        EducacionService.saveEducacion(edu);
        if(edu.getLogo()!=null){
             byte[] datalogo =edu.getLogo();
             edu.setLogo(interPersona.decompressImage(datalogo));
            }
        return edu;
       
    }
    @DeleteMapping("/educacion/borrar/{id}")    
    public void deleteExperiencia(@PathVariable int id){
        EducacionService.deleteEducacion(id);
        
    }
    
    
}
