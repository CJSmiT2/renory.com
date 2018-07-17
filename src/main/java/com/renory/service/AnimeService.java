/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.anime.Anime;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface AnimeService {
    
    int addAnime(String engTitle);
    
    Anime getAnime(int id);
    
    Anime editAnime(int id, String newTitle, String newDate);
    
    void setPoster(int id, File poster);
    
    ArrayList<Anime> getAnime(ArrayList<Integer> ids);
    
    void deleteAnime(int id);
    
}
