/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.interfaces;

import com.renory.model.entity.anime.Anime;

/**
 *
 * @author smit
 */
public interface AnimeDao {
    
    Anime get(int id);
    
    void write(Anime anime);
    
    void update(Anime anime);
    
    void delete(Anime anime);
    
}
