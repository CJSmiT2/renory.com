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
    private int uploaderUserId;
    private String title;
    private String description;
    private int studioId;
    private Date timeCreated;
    private Timestamp timeUploaded;
    private int hitsOfPage;
    private int hitsOfOnlineView;
    private int downloadsCount;
    private boolean canComment;
    private String authorsJSon;
    private String animeSrcJSon;
    private String musicSrcJSon;
    private String categoryesJSon;
    private String videosJSon;
    private String screenShotsJSon;
    private String evaluatingJSon;
    private String accessTypeJSon;
    private String allowedUsersJSon;
    private String urlsJSon;
    private boolean isComplete; 
    
}
