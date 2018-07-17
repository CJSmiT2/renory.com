/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service.impl;

import com.renory.model.dao.impl.AnimeDaoImpl;
import com.renory.model.dao.interfaces.AnimeDao;
import com.renory.model.entity.anime.Anime;
import com.renory.service.AnimeService;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class AnimeServiceImpl implements AnimeService{
    
    private final AnimeDao dao = new AnimeDaoImpl();

    @Override
    public int addAnime(String engTitle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Anime getAnime(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Anime editAnime(int id, String newTitle, String newDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPoster(int id, File poster) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Anime> getAnime(ArrayList<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteAnime(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
