/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv;

import com.renory.config.Config;
import com.renory.view.util.FilesUtil;
import java.io.File;

/**
 *
 * @author smit
 */
class FolderUtil {

    static private void checkNotExist(File folderOnDisk) {
        if (folderOnDisk.exists()){
            new RuntimeException("The folder already exist! " + folderOnDisk.getAbsolutePath());
        }
    }

    static void make(File folderOnDisk) {
        checkNotExist(folderOnDisk);
        folderOnDisk.mkdir();
    }

    static void rename(String alias, File folderOnDisk) {
        File newFolder = new File(Config.AMV_FOLDER + alias);
        checkNotExist(newFolder);
        FilesUtil.move(folderOnDisk, newFolder);
    }

    static File initFolderByAlias(String alias) {
        return new File(Config.AMV_FOLDER + alias);
    }

    static void delete(File folderOnDisk) {
        if (folderOnDisk.exists() && folderOnDisk.isDirectory()){
            FilesUtil.deleteFolderWithFiles(folderOnDisk);
        }
    }
    
}
