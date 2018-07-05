/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service.impl.amv;

import com.renory.model.dao.impl.AmvDaoImpl;
import com.renory.model.dao.interfaces.AmvDao;
import com.renory.model.entity.amv.AccessType;
import com.renory.model.entity.amv.Amv;
import com.renory.model.entity.videoclip.VideoQuality;
import com.renory.model.util.DiskUtil;
import com.renory.model.util.alias.AliasUtil;
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
    public Amv get(String alias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(int amvId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String createAmv(String title, int userId) {
        Amv amv = new Amv();
        amv.setUploaderUserId(userId);
        amv.setTitle(title);
        amv.setAlias(AliasUtil.makeUniqeAlias(title, dao.getAllAliaces()));
        amv.setCompleteFalse();
        dao.write(amv);
        DiskUtil.makeAmvFolder(amv.getAlias());
        return amv.getAlias();
    }

    @Override
    public void updateBaseInfo(AmvBaseInfoDto baseInfo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStudio(int amvId, int studioId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHit(int amvId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addHitOnlineView(int amvId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDownloadCount(int amvId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void canComment(int amvId, boolean can) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAuthor(int amvId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addAnimeSrc(int amvId, int animeId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addMusicSrc(int amvId, int musicId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCategory(int amvId, int categoryId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addVideo(int amvId, File videoFile, VideoQuality quality) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addScreenShots(int amvId, ArrayList<File> screenShots) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addEvaluating(int amvId, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void allowedAccess(ArrayList<AccessType> access) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUrl(int amvId, String url) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setIsComplete(String alias, boolean complete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
