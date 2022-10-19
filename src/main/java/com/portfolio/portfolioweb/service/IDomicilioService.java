/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.portfolioweb.service;


import java.util.List;

import com.portfolio.portfolioweb.model.Domicilio;


public interface IDomicilioService {
    public List<Domicilio> getDomicilio();
    public void saveDomicilio(Domicilio dom);
    public void deleteDomicilio(int id);
    public Domicilio findDomicilio(int id);
}
