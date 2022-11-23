/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.controller;

import com.portfolio.portfolioweb.dto.PersonaDto;
import com.portfolio.portfolioweb.model.Domicilio;
import com.portfolio.portfolioweb.model.Educacion;
import com.portfolio.portfolioweb.model.ExperienciaLaboral;
import com.portfolio.portfolioweb.model.Persona;
import com.portfolio.portfolioweb.service.IDomicilioService;
import com.portfolio.portfolioweb.service.IPersonaService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin 
public class PersonaController {
     @Autowired
     private IPersonaService interPersona;
     @Autowired
     private IDomicilioService interDomicilio;
     
    
      private final static org.slf4j.Logger logger=LoggerFactory.getLogger(PersonaController.class);
    
   
    @GetMapping("/persona/{email}")
    @ResponseBody    
    public Persona getPersonaByUser(@PathVariable String email){    
     
       // if(!interPersona.existsByEmail(email))
         //   return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        Persona persona = interPersona.getByEmail(email);
        byte[] dataFotoPerfil =persona.getFoto_perfil();
        byte[] dataFotoPortada =persona.getFoto_portada();
        persona.setFoto_perfil(interPersona.decompressImage(dataFotoPerfil));
        persona.setFoto_portada(interPersona.decompressImage(dataFotoPortada));
       // return new ResponseEntity(persona, HttpStatus.OK);  
        return persona;   
           
    
}
    @GetMapping("/persona/detalle/{id}")
    @ResponseBody    
    public Persona getPersonaById(@PathVariable int id){    
     
        //if(!interPersona.existsById(id))
          //  return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        Persona persona = interPersona.findPersona(id);
         
        if(persona.getFoto_perfil()!=null){
              byte[] dataFotoPerfil =persona.getFoto_perfil();
              persona.setFoto_perfil(interPersona.decompressImage(dataFotoPerfil));
        }
        if(persona.getFoto_portada()!=null){
         byte[] dataFotoPortada =persona.getFoto_portada();       
         persona.setFoto_portada(interPersona.decompressImage(dataFotoPortada));
        }
        
       
        
       // return new ResponseEntity(persona, HttpStatus.OK); 
       return persona;
          
     
           
    
}
    @GetMapping("/persona/lista")
    public List<Persona> getPersonas(){
        List<Persona> lista = interPersona.getPersonas();
        for (Persona per : lista) {
            if (per.getFoto_perfil() != null) {
                byte[] datafotoPerfil = per.getFoto_perfil();
                per.setFoto_perfil(interPersona.decompressImage(datafotoPerfil));
            }
            if (per.getFoto_portada() != null) {
                byte[] datafotoPortada = per.getFoto_portada();
                per.setFoto_portada(interPersona.decompressImage(datafotoPortada));
            }

            for (ExperienciaLaboral ex : per.getExperienciasLaborales()) {
                if (ex.getLogo() != null) {
                    byte[] datalogo = ex.getLogo();
                    ex.setLogo(interPersona.decompressImage(datalogo));
                }

            }
            for (Educacion edu : per.getEducaciones()) {
                if (edu.getLogo() != null) {
                    byte[] datalogo = edu.getLogo();
                    edu.setLogo(interPersona.decompressImage(datalogo));
                }

            }

        }
        return lista;
    }
    @PostMapping("/persona/crear")
    public Persona createPersona(@RequestBody Persona per){    
        
        
        interPersona.savePersona(per);
        if (per.getFoto_perfil() != null) {
                byte[] datafotoPerfil = per.getFoto_perfil();
                per.setFoto_perfil(interPersona.decompressImage(datafotoPerfil));
            }
            if (per.getFoto_portada() != null) {
                byte[] datafotoPortada = per.getFoto_portada();
                per.setFoto_portada(interPersona.decompressImage(datafotoPortada));
            }
        return per;
    }
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable int id){
        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
  @PutMapping("/persona/editar/{id}")  
  public Persona updatePersona(@PathVariable int id,@ModelAttribute PersonaDto personaDto,BindingResult bindingresult){
             Persona persona=interPersona.findPersona(id);
         try {
             /* if (bindingresult.hasErrors()) {
             return new ResponseEntity("Campos",HttpStatus.BAD_REQUEST);
             }  */           
             
             persona.setSobre_mi(personaDto.getSobre_mi());
             persona.setOcupacion(personaDto.getOcupacion());
             if(personaDto.getFoto_perfil()!=null){             
               persona.setFoto_perfil(interPersona.compressImage(personaDto.getFoto_perfil().getBytes()));
             }
             if(personaDto.getFoto_portada()!=null){              
               persona.setFoto_portada(interPersona.compressImage(personaDto.getFoto_portada().getBytes()));
             }
             persona.setApellido(personaDto.getApellido());
             persona.setNombre(personaDto.getNombre());
             persona.setFecha_nacimiento(personaDto.getFecha_nacimiento());
             persona.setNacionalidad(personaDto.getNacionalidad());
             persona.setTelefono(personaDto.getTelefono());
             
             
             Domicilio domicilio= interDomicilio.findDomicilio(persona.getDomicilio().getId());
             domicilio.setDireccion(personaDto.getDireccion());
             domicilio.setNumero(personaDto.getNumero());
             domicilio.setProvincia(personaDto.getProvincia());
             
             //interDomicilio.saveDomicilio(domicilio);
             interPersona.savePersona(persona); 
            } catch (IOException ex) {
          logger.error("Aca Fallo");
      }
            if (persona.getFoto_perfil() != null) {
                byte[] datafotoPerfil = persona.getFoto_perfil();
                persona.setFoto_perfil(interPersona.decompressImage(datafotoPerfil));
            }
            if (persona.getFoto_portada() != null) {
                byte[] datafotoPortada = persona.getFoto_portada();
                persona.setFoto_portada(interPersona.decompressImage(datafotoPortada));
            }
             
               return persona;
             
             //return new ResponseEntity("Cambios Guardados",HttpStatus.CREATED);
            
         
        
    }
}
