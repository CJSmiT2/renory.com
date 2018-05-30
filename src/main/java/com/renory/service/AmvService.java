/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.amv.AccessType;
import com.renory.model.entity.amv.Amv;
import com.renory.model.entity.videoclip.VideoQuality;
import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface AmvService {
    
    Amv get(String alias);
    
    String createAmv(String title);
    
    void editDescription(String alias, String description);
    
    void setStudio(String alias, int studioId);
    
    void setTimeCreated(String alias, Date timeCreated);
    
    void addHit(String alias);
    
    void addHitOnlineView(String alias);
    
    void addDownloadCount(String alias);
    
    void canComment(String alias, boolean can);
    
    void addAuthor(String alias, int userId);
    
    void addAnimeSrc(String alias, int srcId);
    
    void addMusicSrc(String alias, String musicTitle);
    
    void addCategory(String alias, int categoryId);
    
    void addVideo(String alias, File videoFile, VideoQuality quality);
    
    void addScreenShots(String alias, ArrayList<File> screenShots);
    
    void addEvaluating(String alias, int userId);
    
    void allowedAccess(ArrayList<AccessType> access);
    
    void addUrl(String alias, String url);
    
    void setIsComplete(String alias, boolean complete);
    
}
