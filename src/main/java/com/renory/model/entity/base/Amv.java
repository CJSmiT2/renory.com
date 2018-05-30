/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.base;

import com.renory.model.entity.videoclip.VideoClip;
import com.renory.model.entity.screenshot.ScreenShot;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class Amv{
    
    private int id;
    private String alias;
    private int authorUserId;
    private int uploaderUserId;
    private int studioId;
    private Timestamp timeCreated;
    private Timestamp timeUploaded;
    private String title;
    private String about;
    private int animeTitleId;
    private int musicId;
    private File poster;
    private int hitsOfPage;
    private int hitsOfOnlineView;
    private ArrayList<CategoryAmv> categoryes = new ArrayList();
    private ArrayList<VideoClip> videos = new ArrayList();
    private ArrayList<ScreenShot> screenShots = new ArrayList();
    private ArrayList<Evaluate> evaluating = new ArrayList();
    private boolean isComplete; 
    private ArrayList<AccessType> accessType = new ArrayList();
    private ArrayList<Integer> allowedUsers = new ArrayList();
    
}
