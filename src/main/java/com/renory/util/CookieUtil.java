/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author smit
 */
public class CookieUtil {
    
    public String read(String name, HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String value = null;
        
        try{
            for(Cookie cookie : cookies){
                if(name.equals(cookie.getName())){
                    value = cookie.getValue();
                }
            }
        }catch (NullPointerException e){
        }
        
        return value;
    }
    
    public void write(String name, String value, HttpServletResponse response){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(name);
        response.addCookie(cookie);
    }
    
    public void write(String name, String value, String path, HttpServletResponse response){
        Cookie cookie = new Cookie(name, value);
        cookie.setPath(path);
        response.addCookie(cookie);
    }
    
}
