/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.controller;

import com.portfolio.portfolioweb.model.Domicilio;
import com.portfolio.portfolioweb.service.IDomicilioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DomicilioController {
     @Autowired
    private IDomicilioService interDomicilio;
    
    @GetMapping("/domicilio/traer")
    public List<Domicilio> getDomicilios(){
    
    return interDomicilio.getDomicilio();
}
    @PostMapping("/domicilio/crear")
    public String createDomicilio(@RequestBody Domicilio dom){
        interDomicilio.saveDomicilio(dom);
        return "El domicilio fue creado correctamente";
    }
    @DeleteMapping("/domicilio/borrar/{id}")
    public String deleteDomicilio(@PathVariable int id){
        interDomicilio.deleteDomicilio(id);
        return "El domicilio fue borrado correctamente";
    }
    @PutMapping("/domicilio/editar/{id}")
    public Domicilio editDomicilio(@PathVariable int id,
                               @RequestParam("direcciom")String nuevoDomicilio,
                               @RequestParam("numero")String nuevoNumero)
                               {
        
        Domicilio dom=interDomicilio.findDomicilio(id);
        dom.setDireccion(nuevoDomicilio);
        dom.setNumero(nuevoNumero);
       
        interDomicilio.saveDomicilio(dom);
        return dom;
    }
    
}
