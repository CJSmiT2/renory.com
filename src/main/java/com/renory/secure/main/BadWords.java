/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;

import com.renory.model.util.TextOnFileUtil;
import java.io.File;
import java.util.ArrayList;


/**
 *
 * @author smit
 */
class BadWords {
    
    private final ArrayList<String> badWordsList;

    BadWords(File file) {
        badWordsList = TextOnFileUtil.readByLine(file);
    }

    boolean theWordNotBad(String word) {
        for (String str:badWordsList){
            if (str.equalsIgnoreCase(word)){
                return false;
            }
        }
        return true;
    }
    
}
