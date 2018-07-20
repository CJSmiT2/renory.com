/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.dto;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author smit
 */
public class AmvDto {
    private int id;
    private String alias;
    private String folderNameOnDisk;
    private int uploaderUserId;
    private String title;
    private String description;
    private int studioId;
    private Date dateCreated;
    private Timestamp timeUploaded;
    private int hitsOfPage;
    private int hitsOfOnlineView;
    private int downloadsCount;
    private String authors;
    private String animeSrc;
    private String musicSrc;
    private String categories;
    private String videos;
    private String urls;
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

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFolderNameOnDisk() {
        return folderNameOnDisk;
    }

    public void setFolderNameOnDisk(String folderNameOnDisk) {
        this.folderNameOnDisk = folderNameOnDisk;
    }
    
    public int getUploaderUserId() {
        return uploaderUserId;
    }

    public void setUploaderUserId(int uploaderUserId) {
        this.uploaderUserId = uploaderUserId;
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getAnimeSrc() {
        return animeSrc;
    }

    public void setAnimeSrc(String animeSrc) {
        this.animeSrc = animeSrc;
    }

    public String getMusicSrc() {
        return musicSrc;
    }

    public void setMusicSrc(String musicSrc) {
        this.musicSrc = musicSrc;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public boolean isIsPublic() {
        return isPublic;
    }

    public void setIsPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }


    
    
    
}
