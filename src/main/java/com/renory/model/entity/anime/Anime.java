/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.anime;

import java.io.File;
import java.sql.Date;

/**
 *
 * @author smit
 */
public class Anime {
    private int id;
    private String title;
    private File poster;
    private Date year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public File getPoster() {
        return poster;
    }

    public void setPoster(File poster) {
        this.poster = poster;
    }

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }
    
    
}
