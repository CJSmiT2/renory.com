/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao;

import com.renory.model.dao.converter.ConverterAmv;
import com.renory.model.entity.amv.Amv;

/**
 *
 * @author smit
 */
public class AmvDao {
    
    private final ConverterAmv converter = new ConverterAmv();
    private final DataBase base = new DataBase();

    public Amv getAmv(String alias) {
        return converter.toEntity(base.getAmv(alias));
    }
    
}
