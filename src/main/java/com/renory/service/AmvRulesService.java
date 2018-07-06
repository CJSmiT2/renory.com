/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service;

import com.renory.model.entity.amvrules.AmvRules;
import java.sql.Date;

/**
 *
 * @author smit
 */
public interface AmvRulesService {
    
    boolean thisUserHaveAccessForAmv(int userId, int amvId);
    
    AmvRules getSimpleRules(int amvId);
    
    
    void thisAmvCanBeCommented(boolean value, int amvId);
    
    void thisAmvCanBeRating(boolean value, int amvId);
    
    void userCanViewRatingOfThisAmv(boolean value, int amvId);
    
    void setAutoShowRatingDate(Date date, int amvId);
    
    void removeAutoShowRatingDate(int amvId);
    
    void accessRulesEnable(boolean value, int amvId);
    
    void allowAccessForFriends(boolean value, int amvId);
    
    void allowAccessForStudios(boolean value, int amvId);
    
    void allowAccessByUserId(boolean value, int amvId);
    
    
    void addStudioIdForAccess(int studioId, int amvId);
    
    void removeStudioIdFromAccess(int studioId, int amvId);
    
    void addUserIdForAccess(int userId, int amvId);
    
    void removeUserIdFromAccess(int studioId, int amvId);
    
}
