/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.util;

import com.renory.util.TranslitUtil;
import java.util.ArrayList;


/**
 *
 * @author smit
 */
public class AliasUtil {
    
    private static final int ALIAS_LENGTH_MAX = 240;


    public static String makeUniqeAlias(String title, ArrayList<String> aliases) {
        String newAlias = TranslitUtil.convert(title);
        if (newAlias.length()>=ALIAS_LENGTH_MAX) {
            newAlias = newAlias.substring(0, ALIAS_LENGTH_MAX);
        }
        
        if (theAliasUniqe(newAlias, aliases)){
            return newAlias;
        } else {
            int ending = 1;
            while(true){
                String aliasWithEnding = newAlias + "_" + ending;
//                log.info("Possible alias variant: " + aliasWithEnding);
                if (theAliasUniqe(aliasWithEnding, aliases)){
//                    log.info("The alias uniqe! Set him...");
                    return aliasWithEnding;
                } else {
                    ending++;
                }
            }
        }
    }

    private static boolean theAliasUniqe(String aliasForCheck, ArrayList<String> aliases) {
        for (String aliasInDb:aliases){
            if (aliasInDb.equalsIgnoreCase(aliasForCheck)){
                return false;
            }
        }
        return true;
    }
    
}
