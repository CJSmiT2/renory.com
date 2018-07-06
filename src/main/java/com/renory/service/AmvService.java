/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.view.dto.AmvBaseInfoDto;
import com.renory.model.entity.amvrules.AccessType;
import com.renory.model.entity.amv.Amv;
import com.renory.model.entity.videoclip.VideoQuality;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public interface AmvService {
    
    Amv get(String alias);
    
    String createAmv(String title, int userId);
    
    void delete(int amvId);
    
    void updateBaseInfo(AmvBaseInfoDto baseInfo);
    
    void setStudio(int amvId, int studioId);
    
    void addHit(int amvId);
    
    void addHitOnlineView(int amvId);
    
    void addDownloadCount(int amvId);
    
    void canComment(int amvId, boolean can);
    
    void addAuthor(int amvId, int userId);
    
    void addAnimeSrc(int amvId, int animeId);
    
    void addMusicSrc(int amvId, int musicId);
    
    void addCategory(int amvId, int categoryId);
    
    void addVideo(int amvId, File videoFile, VideoQuality quality);
    
    void addScreenShots(int amvId, ArrayList<File> screenShots);
    
    void addEvaluating(int amvId, int userId);
    
    void allowedAccess(ArrayList<AccessType> access);
    
    void addUrl(int amvId, String url);
    
    void setIsComplete(String alias, boolean complete);
    
}
