/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.category.CategoryAmv;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface CategoryService {
    
    CategoryAmv get(int id);
    
    ArrayList<CategoryAmv> getAll();
    
    ArrayList<CategoryAmv> get(ArrayList<Integer> ids);
}
