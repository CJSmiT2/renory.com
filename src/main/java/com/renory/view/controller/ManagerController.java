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
@RequestMapping(value = {"manager/"})
public class ManagerController {
    
    @RequestMapping(value = {"create_new_amv_page"})
    public Object createNew(){
        throw new UnsupportedOperationException();
    }
    
    
    
    @RequestMapping(value = {"update_base_info/{alias}"})
    public Object updateBaseInfo(@PathVariable("alias") String alias){
    /*
        Update: title, alias, description, timeCreated, urls
    */
        throw new UnsupportedOperationException();
    }
    
    @RequestMapping(value = {"update_poster/{alias}"})
    public Object updatePoster(@PathVariable("alias") String alias){
    /*
        Update: posterFile
    */
        throw new UnsupportedOperationException();
    }

    
}
