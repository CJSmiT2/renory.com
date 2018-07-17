/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.view.dto.AmvBaseInfoDto;
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
    
    Amv get(int id);
    
    boolean isAmvExist(int id);
    
    String createAmv(String title, int userId);
    
    void delete(int amvId);
    
    void updateBaseInfo(AmvBaseInfoDto baseInfo);
    
    void setStudio(int amvId, int studioId);
    
    void deleteStudio(int amvId);
    
    void addHitOfpage(int amvId);
    
    void addHitOnlineView(int amvId);
    
    void addDownloadCount(int amvId);
    
    void addAuthorToAmv(int amvId, int userId);
    
    void deleteAuthor(int amvId, int userId);
    
    void addAnimeSrc(int amvId, int animeId);
    
    void deleteAnimeSrc(int amvId, int animeId);
    
    boolean isAnimeSrcExist(int id, int animeSrc);
    
    void addMusicSrc(int amvId, int musicId);
    
    void deleteMusicSrc(int amvId, int musicId);
    
    void addCategory(int amvId, int categoryId);
    
    void deleteCategory(int amvId, int categoryId);
    
    void addVideo(int amvId, File videoFile, VideoQuality quality);
    
    void deleteVideo(int amvId, int videoId);
    
    void addScreenShots(int amvId, ArrayList<File> screenShots);
    
    void deleteScreenShot(int amvId, int screenShotId);
    
    void addEvaluating(int amvId, int userId);
    
    void addUrl(int amvId, String url);
    
    void deleteUrl(int amvId, int urlId);
    
    void makeIsPublic(int amvId);
    
    void makeNotPublic(int amvId);

    public boolean userCanManageAmv(int userId, int amvId);

    public void clearDb();
    

}
