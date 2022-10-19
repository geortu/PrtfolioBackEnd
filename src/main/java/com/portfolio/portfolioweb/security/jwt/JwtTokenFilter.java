/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.portfolioweb.security.jwt;

import com.portfolio.portfolioweb.security.service.UserDetailServiceImpl;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.core.context.SecurityContextHolder;


public class JwtTokenFilter extends OncePerRequestFilter{
    @Autowired 
    JwtProvider jwtProvider;
    @Autowired 
    UserDetailServiceImpl userDetailsimpl;
    private final static Logger logger=LoggerFactory.getLogger(JwtTokenFilter.class);
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token= getToken(request);
            if(token!=null && jwtProvider.validatetoken(token)){
             String nombreUsuario= jwtProvider.getNombreUsuarioFromToken(token);
                UserDetails userDatails=userDetailsimpl.loadUserByUsername(nombreUsuario);
                UsernamePasswordAuthenticationToken auth= 
                        new UsernamePasswordAuthenticationToken(userDatails, null, userDatails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            
        } catch (Exception e) {
            logger.error("fallo el metodo doFilter");
        }
        filterChain.doFilter(request, response);
    }
    private String getToken(HttpServletRequest request){
    String header= request.getHeader("Authorization");
        if (header !=null && header.startsWith("Bearer")) {
            return header.replace("Bearer", "");
        }
        return null;
    }
    
}
