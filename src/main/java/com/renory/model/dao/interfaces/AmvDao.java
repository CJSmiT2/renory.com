/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.interfaces;

import com.renory.model.entity.amv.Amv;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface AmvDao {

    public ArrayList<String> getAllAliaces();

    public int write(Amv amv);
    
    public Amv get(int id);
    
    public Amv get(String alias);
    
    public void update(Amv amv);
    
    public void delete(Amv amv);
    
    public ArrayList<Amv> getAll();

    public void clearDb();
    
}
