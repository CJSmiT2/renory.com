/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import com.renory.model.dao.interfaces.AmvDao;
import com.renory.model.entity.amv.Amv;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class AmvDaoImpl implements AmvDao{
    
    private final TableAmv db = new TableAmv();

    @Override
    public ArrayList<String> getAllAliaces() {
        return db.getAllAliaces();
    }

    @Override
    public int write(Amv amv) {
        return db.write(ConverterAmv.toDto(amv));
    }

    @Override
    public Amv get(int id) {
        return ConverterAmv.toEntity(db.get(id));
    }

    @Override
    public Amv get(String alias) {
        return ConverterAmv.toEntity(db.get(alias));
    }

    @Override
    public void update(Amv amv) {
        db.update(ConverterAmv.toDto(amv));
    }

    @Override
    public void delete(Amv amv) {
        db.delete(amv.getId());
    }

    @Override
    public ArrayList<Amv> getAll() {
        return ConverterAmv.toEntityArray(db.getAll());
    }

    @Override
    public void clearDb() {
        db.clearDb();
    }


    
}
