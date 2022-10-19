/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.service;

import com.portfolio.portfolioweb.model.Persona;
import com.portfolio.portfolioweb.repository.PersonaRepository;
import com.portfolio.portfolioweb.security.jwt.JwtEntryPoint;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private PersonaRepository persoRepository;
    
     private final static Logger logger=LoggerFactory.getLogger(PersonaService.class);
    
    
    @Override
    public List<Persona> getPersonas() {
       return persoRepository.findAll();
    }

    @Override
    public void savePersona(Persona per) {
        persoRepository.save(per);
    }

    @Override
    public void deletePersona(int id) {
       persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(int id) {
       return persoRepository.findById(id).orElse(null);
    }
    @Override
    public Persona getByEmail(String email){    
    return persoRepository.findByEmail(email);
    }
    @Override
    public boolean existsById(int id){
        return persoRepository.existsById(id);
    }
    @Override
    public  boolean existsByEmail(String email){
        return persoRepository.existsByEmail(email);
    }
    public  byte[] compressImage(byte[] data) {

        Deflater deflater = new Deflater();
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[1024];
        while (!deflater.finished()) {
            int size = deflater.deflate(tmp);
            outputStream.write(tmp, 0, size);
        }
        try {
            outputStream.close();
        } catch (Exception e) {
            logger.error("Fallo alla");
        }
        return outputStream.toByteArray();
    }
     public  byte[] decompressImage(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
            outputStream.close();
        } catch (Exception exception) {
            logger.error("Fallo aca");
        }
        return outputStream.toByteArray();
    }
    
}
