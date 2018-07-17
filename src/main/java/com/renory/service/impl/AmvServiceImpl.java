/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service.impl;

import com.renory.model.dao.impl.AmvDaoImpl;
import com.renory.model.dao.interfaces.AmvDao;
import com.renory.model.entity.amv.Amv;
import com.renory.model.entity.videoclip.VideoQuality;
import com.renory.service.AmvService;
import com.renory.view.dto.AmvBaseInfoDto;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class AmvServiceImpl implements AmvService{
    
    private final AmvDao dao = new AmvDaoImpl();



    @Override
    public String createAmv(String title, int userId) {
        Amv amv = AmvServiceUtil.createAmv(title, userId, dao);
        return amv.getAlias();
    }
    
    @Override
    public Amv get(int id) {
        return dao.get(id);
    }

    @Override
    public Amv get(String alias) {
        return dao.get(alias);
    }

    @Override
    public void delete(int amvId) {
        Amv amv = dao.get(amvId);
        dao.delete(amv);
        amv.deleteFolderOnDisk();
    }

    @Override
    public void updateBaseInfo(AmvBaseInfoDto baseInfo) {
        AmvServiceUtil.updateBaseInfo(baseInfo, dao);
    }

    @Override
    public void setStudio(int amvId, int studioId) {
        Amv amv = dao.get(amvId);
        amv.setStudioId(studioId);
        dao.update(amv);
    }
    
    @Override
    public void deleteStudio(int amvId) {
        Amv amv = dao.get(amvId);
        amv.setStudioId(0);
        dao.update(amv);
    }

    @Override
    public void addHitOfpage(int amvId) {
        Amv amv = dao.get(amvId);
        amv.addHitOfpage();
        dao.update(amv);
    }

    @Override
    public void addHitOnlineView(int amvId) {
        Amv amv = dao.get(amvId);
        amv.addHitOfOnlineView();
        dao.update(amv);
    }

    @Override
    public void addDownloadCount(int amvId) {
        Amv amv = dao.get(amvId);
        amv.addDownloadCount();
        dao.update(amv);
    }

    @Override
    public void addAuthorToAmv(int amvId, int userId) {
        Amv amv = dao.get(amvId);
        amv.addAuthor(userId);
        dao.update(amv);
    }

    @Override
    public void deleteAuthor(int amvId, int userId) {
        Amv amv = dao.get(amvId);
        amv.deleteAuthor(userId);
        dao.update(amv);
    }

    @Override
    public void addAnimeSrc(int amvId, int animeId) {
        Amv amv = dao.get(amvId);
        amv.addAnimeSrc(animeId);
        dao.update(amv);
    }

    @Override
    public void deleteAnimeSrc(int amvId, int animeId) {
        Amv amv = dao.get(amvId);
        amv.deleteAnimeSrc(animeId);
        dao.update(amv);
    }

    @Override
    public void addMusicSrc(int amvId, int musicId) {
        Amv amv = dao.get(amvId);
        amv.addMusicSrc(musicId);
        dao.update(amv);
    }

    @Override
    public void deleteMusicSrc(int amvId, int musicId) {
        Amv amv = dao.get(amvId);
        amv.deleteMusicSrc(musicId);
        dao.update(amv);
    }

    @Override
    public void addCategory(int amvId, int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(int amvId, int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVideo(int amvId, File videoFile, VideoQuality quality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteVideo(int amvId, int videoId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addScreenShots(int amvId, ArrayList<File> screenShots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteScreenShot(int amvId, int screenShotId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEvaluating(int amvId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUrl(int amvId, String url) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUrl(int amvId, int urlId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeIsPublic(int amvId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeNotPublic(int amvId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean userCanManageAmv(int userId, int amvId) {
        return dao.get(amvId).getManagerUserId() == userId;
    }

    @Override
    public void clearDb() {
        dao.clearDb();
    }

    @Override
    public boolean isAmvExist(int amvId) {
        return dao.isAmvExist(amvId);
    }

    @Override
    public boolean isAnimeSrcExist(int id, int animeSrc) {
        Amv amv = dao.get(id);
        for (Integer number : amv.getAnimeSrc()){
            if (number == animeSrc){
                return true;
            }
        }
        return false;
    }

    

    

    
    
}
