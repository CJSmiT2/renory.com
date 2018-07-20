/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class FilesUtil {
    
    public static ArrayList<File> getFiles(File folder){
        isFolderExistChecking(folder);
        
        ArrayList<File> filesList = new ArrayList();
        
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                filesList.add(listOfFiles[i]);
            }
        }
        
        return filesList;
    }
    
    public static ArrayList<File> getFolders(File folder){
        isFolderExistChecking(folder);
        
        ArrayList<File> foldersList = new ArrayList();
        
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isDirectory()) {
                foldersList.add(listOfFiles[i]);
            }
        }
        
        return foldersList;
    }
    
    public static void move(File f1, File f2){
        if (!f1.exists()){
            throw new RuntimeException("Fail to move file. Src file not exist! " + f1.getAbsolutePath());
        }
        
        boolean result = f1.renameTo(f2);
        if (result & f2.exists()) {
            f1.delete();
        }
    }
    
    public static void copy(File source, File dest){
        if (!source.exists()){
            throw new RuntimeException("Fail to copy file. Src file not exist! " + source.getAbsolutePath());
        }
        if (dest.exists()){
            System.out.println("WARNING! The file will be rewritten! " + dest.getAbsolutePath());
        }
            
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilesUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FilesUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                sourceChannel.close();
                destChannel.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
            throw new RuntimeException("Extension not found in file name! " + file.getName());
        }
    }
    
    public static String getFileExtension(String fileName) {
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0){
            return fileName.substring(fileName.lastIndexOf(".")+1);
        } else {
            throw new RuntimeException("Extension not found in file name! " + fileName);
        }
    }

    
    
    public static void deleteFolderWithFiles(File file){
        for (File childFile : file.listFiles()) {
                if (childFile.isDirectory()) {
                    deleteFolderWithFiles(childFile);
                } else {
                    if (!childFile.delete()) {
                        try {
                            throw new IOException();
                        } catch (IOException ex) {
                            Logger.getLogger(FilesUtil.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
        }

        if (!file.delete()) {
            try {
                throw new IOException();
            } catch (IOException ex) {
                Logger.getLogger(FilesUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static long getFilesSize(ArrayList<File> files){
        long size = 0;
        for (File file:files){
            if (file.isFile()){
                size += file.length();
            }
        }
        return size;
    }
    
    public static ArrayList<File> getAllFilesRecurcive(File root) {
        ArrayList<File> files = new ArrayList();

        File[] list = root.listFiles();

        if (list==null) return files;

        for (File file:list) {
            if (file.isDirectory()) {
                ArrayList<File> filesInDir = getAllFilesRecurcive(file);
                files.addAll(filesInDir);
            }
            else {
                files.add(file);
            }
        }
        
        return files;
    }
    
    public static void deleteAllInFolder(File folderForDelete){
        ArrayList<File> folders = FilesUtil.getFolders(folderForDelete);
        for (File folder : folders){
            FilesUtil.deleteFolderWithFiles(folder);
        }
    }
    
    private static void isFolderExistChecking(File folder) {
        if (!folder.exists() || !folder.isDirectory()){
            throw new RuntimeException("BIs folder not exist! " + folder.getAbsolutePath());
        }
    }
}
