/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv;

import com.renory.model.entity.videoclip.VideoClip;
import com.renory.model.entity.screenshot.ScreenShot;
import java.io.File;
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
    private Date timeCreated;
    private Timestamp timeUploaded;
    private File poster;
    private int hitsOfPage;
    private int hitsOfOnlineView;
    private int downloadsCount;
    private boolean canComment;
    private ArrayList<Integer> authors = new ArrayList();
    private ArrayList<Integer> animeSrc = new ArrayList();
    private ArrayList<String> musicSrc = new ArrayList();
    private ArrayList<CategoryAmv> categoryes = new ArrayList();
    private ArrayList<VideoClip> videos = new ArrayList();
    private ArrayList<ScreenShot> screenShots = new ArrayList();
    private ArrayList<Evaluate> evaluating = new ArrayList();
    private ArrayList<AccessType> accessType = new ArrayList();
    private ArrayList<Integer> allowedUsers = new ArrayList();
    private ArrayList<String> urls = new ArrayList();
    private boolean isComplete; 
    
}
