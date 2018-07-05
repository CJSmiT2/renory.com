/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author smit
 */
public class UrlFromUser {
    private int idCounter = 0;
    private ArrayList<Url> urls = new ArrayList();
    
    public void addUrl(String urlString){
        idCounter++;
        Url url = new Url();
        url.setId(idCounter);
        url.setUrl(urlString);
        urls.add(url);
    }
    
    public void deleteUrl(int id){
        Iterator<Url> i = urls.iterator();
        while (i.hasNext()) {
           Url url = i.next();
           if (url.getId()==id){
               i.remove();
               break;
           }
        }
    }

    public int getIdCounter() {
        return idCounter;
    }

    public void setIdCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public ArrayList<Url> getUrls() {
        return urls;
    }

    public void setUrls(ArrayList<Url> urls) {
        this.urls = urls;
    }
    
    
}
