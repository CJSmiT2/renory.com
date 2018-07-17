/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv;

import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author smit
 */
public class Amv{
    private int id;
    private String alias;
    private File folderOnDisk;
    private int uploaderUserId;
    private int managerUserId;
    private String title;
    private String description;
    private int studioId;
    private Date dateCreated;
    private Timestamp timeUploaded;
    private int hitsOfPage;
    private int hitsOfOnlineView;
    private int downloadsCount;
    private ArrayList<Integer> authors = new ArrayList();
    private ArrayList<Integer> animeSrc = new ArrayList();
    private ArrayList<Integer> musicSrc = new ArrayList();
    private ArrayList<Integer> categories = new ArrayList();
    private ArrayList<Integer> videos = new ArrayList();
    private UrlFromUser urls = new UrlFromUser();
    private boolean isPublic; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public File getFolderOnDisk() {
        return folderOnDisk;
    }

    public void setFolderOnDisk(File folderOnDisk) {
        this.folderOnDisk = folderOnDisk;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getUploaderUserId() {
        return uploaderUserId;
    }

    public void setUploaderUserId(int uploaderUserId) {
        this.uploaderUserId = uploaderUserId;
    }

    public int getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(int managerUserId) {
        this.managerUserId = managerUserId;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStudioId() {
        return studioId;
    }

    public void setStudioId(int studioId) {
        this.studioId = studioId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }



    public Timestamp getTimeUploaded() {
        return timeUploaded;
    }

    public void setTimeUploaded(Timestamp timeUploaded) {
        this.timeUploaded = timeUploaded;
    }



    public int getHitsOfPage() {
        return hitsOfPage;
    }

    public void setHitsOfPage(int hitsOfPage) {
        this.hitsOfPage = hitsOfPage;
    }

    public int getHitsOfOnlineView() {
        return hitsOfOnlineView;
    }

    public void setHitsOfOnlineView(int hitsOfOnlineView) {
        this.hitsOfOnlineView = hitsOfOnlineView;
    }

    public int getDownloadsCount() {
        return downloadsCount;
    }

    public void setDownloadsCount(int downloadsCount) {
        this.downloadsCount = downloadsCount;
    }

    public ArrayList<Integer> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Integer> authors) {
        this.authors = authors;
    }

    public ArrayList<Integer> getAnimeSrc() {
        return animeSrc;
    }

    public void setAnimeSrc(ArrayList<Integer> animeSrc) {
        this.animeSrc = animeSrc;
    }

    public ArrayList<Integer> getMusicSrc() {
        return musicSrc;
    }

    public void setMusicSrc(ArrayList<Integer> musicSrc) {
        this.musicSrc = musicSrc;
    }

    public ArrayList<Integer> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Integer> categories) {
        this.categories = categories;
    }

    public ArrayList<Integer> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Integer> videos) {
        this.videos = videos;
    }

    public UrlFromUser getUrls() {
        return urls;
    }

    public void setUrls(UrlFromUser urls) {
        this.urls = urls;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void makeFolder() {
        FolderUtil.make(folderOnDisk);
    }

    public void renameFolderOnDisk() {
        FolderUtil.rename(alias, folderOnDisk);
    }

    public void addHitOfpage() {
        hitsOfPage++;
    }

    public void addHitOfOnlineView() {
        hitsOfOnlineView++;
    }

    public void addDownloadCount() {
        downloadsCount++;
    }

    public void addAuthor(int userId) {
        authors.add(userId);
    }

    public void deleteAuthor(int userId) {
        removeFromArray(userId, authors);
    }

    public void addAnimeSrc(int animeId) {
        animeSrc.add(animeId);
    }

    public void deleteAnimeSrc(int animeId) {
        removeFromArray(animeId, animeSrc);
    }
    
    private void removeFromArray(int valueForRemove, ArrayList<Integer> array){
        Iterator<Integer> i = array.iterator();
        while (i.hasNext()) {
           Integer value = i.next();
           if (value == valueForRemove){
               i.remove();
               break;
           }
        }
    }

    public void addMusicSrc(int musicId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteMusicSrc(int musicId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void initFolderByAlias() {
        this.folderOnDisk = FolderUtil.initFolderByAlias(alias);
    }

    public void deleteFolderOnDisk() {
        FolderUtil.delete(folderOnDisk);
    }

    
    
}
