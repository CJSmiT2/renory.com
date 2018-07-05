/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.music.MusicAmv;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface MusicService {
    
    int add(String artist, String title);
    
    MusicAmv get(int id);
    
    ArrayList<MusicAmv> getAll();
}
