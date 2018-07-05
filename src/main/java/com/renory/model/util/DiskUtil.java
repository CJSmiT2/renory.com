/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.util;

import com.renory.config.Config;
import java.io.File;

/**
 *
 * @author smit
 */
public class DiskUtil {
    
    public static void makeAmvFolder(String alias){
        File folder = new File(Config.AMV_FOLDER + alias);
        if (!folder.exists()){
            folder.mkdir();
        } else {
            throw new RuntimeException("The folder already exist! " + folder.getAbsolutePath());
        }
    }
}
