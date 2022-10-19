/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtEntryPoint implements AuthenticationEntryPoint{
     private final static Logger logger=LoggerFactory.getLogger(JwtEntryPoint.class);
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
       
        logger.error("Fail en el metodo commence");
       
        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"no autorizado");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

       final Map<String, Object> body = new HashMap<>();
       body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
       body.put("error", "Unauthorized");
       body.put("message", authException.getMessage());
       body.put("path", request.getServletPath());

       final ObjectMapper mapper = new ObjectMapper();
       mapper.writeValue(response.getOutputStream(), body);
       
        
    }
    
}
