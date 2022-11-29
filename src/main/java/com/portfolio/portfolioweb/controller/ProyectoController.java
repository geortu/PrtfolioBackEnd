
package com.portfolio.portfolioweb.controller;

import com.portfolio.portfolioweb.dto.ProyectoDto;
import com.portfolio.portfolioweb.model.Proyecto;
import com.portfolio.portfolioweb.service.IPersonaService;
import com.portfolio.portfolioweb.service.IProyectoService;
import java.util.List;
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
public class ProyectoController {
    @Autowired
    private IProyectoService proyectoService;
    @Autowired
    private IPersonaService interPersona;
    
    
    @GetMapping("/proyecto/traer")
    @ResponseBody
    public List<Proyecto> getProyecto(){    
    return proyectoService.getProyecto();
    
}
    @GetMapping("/proyecto/unica/{id}")
    @ResponseBody
    public Proyecto getProyectoById(@PathVariable int id){             
    return proyectoService.findProyecto(id) ;
    }
    @GetMapping("/proyecto/{id}")
    @ResponseBody
    public List<Proyecto> getProyectoByIdPersona(@PathVariable int id){    
        
    return proyectoService.findById_persona(id) ;
    
}
   
    @PostMapping("/proyecto/crear")    
    public Proyecto createProyecto(@ModelAttribute ProyectoDto proyectoDto,BindingResult bindingresult){ 
          
          Proyecto pro = new Proyecto();
          pro.setNombre(proyectoDto.getNombre());
          pro.setDescripcion(proyectoDto.getDescripcion());
          pro.setFecha(proyectoDto.getFecha());
          pro.setLink(proyectoDto.getLink());
          pro.setPersona(interPersona.findPersona(proyectoDto.getId_persona()));        
        
            
        
        
        proyectoService.saveProyecto(pro);
          return pro;
        
    }
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto updateProyecto(@PathVariable int id,@ModelAttribute ProyectoDto proyectoDto,BindingResult bindingresult ) {     
        
          Proyecto pro=proyectoService.findProyecto(id);             
         
           pro.setNombre(proyectoDto.getNombre());
           pro.setDescripcion(proyectoDto.getDescripcion());
           pro.setFecha(proyectoDto.getFecha());
           pro.setLink(proyectoDto.getLink());
            
             
            
        
        
         proyectoService.saveProyecto(pro);
         return pro;
       
    }
    @DeleteMapping("/proyecto/borrar/{id}")    
    public void deleteProyecto(@PathVariable int id){
        proyectoService.deleteProyecto(id);
        
    }
    
    
}
