/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class Amv{
    private int id;
    private String alias;
    private int uploaderUserId;
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
    private boolean isComplete; 

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

    public boolean isIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
    
    public void setCompleteTrue(){
        isComplete = true;
    }
    
    public void setCompleteFalse(){
        isComplete = false;
    }

    @Override
    public String toString() {
        return "Amv{" + "id=" + id + ", alias=" + alias + ", uploaderUserId=" + uploaderUserId + ", title=" + title + ", description=" + description + ", studioId=" + studioId + ", dateCreated=" + dateCreated + ", timeUploaded=" + timeUploaded + ", hitsOfPage=" + hitsOfPage + ", hitsOfOnlineView=" + hitsOfOnlineView + ", downloadsCount=" + downloadsCount + ", authors=" + authors + ", animeSrc=" + animeSrc + ", musicSrc=" + musicSrc + ", categories=" + categories + ", videos=" + videos + ", urls=" + urls + ", isComplete=" + isComplete + '}';
    }
    
    
    
}
