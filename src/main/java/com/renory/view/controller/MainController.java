/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author smit
 */
@Controller
public class MainController {
    
    @RequestMapping(value = {"/","/home"})
    public Object home(){
        throw new UnsupportedOperationException();
    }
    
    @RequestMapping(value = {"amv/{alias}"})
    public Object amv(@PathVariable("alias") String alias){
        throw new UnsupportedOperationException();
    }
    
    @RequestMapping(value = {"amv/list_all"})
    public Object amvListAll(){
        throw new UnsupportedOperationException();
    }
    
}
