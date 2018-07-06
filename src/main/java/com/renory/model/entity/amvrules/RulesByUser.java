/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amvrules;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
public class RulesByUser {
    private boolean canComment = true;
    private boolean canSetRating = true;
    private boolean canViewRating = true;
    private Date autoShowRatingDate;
    
    private boolean accessRuleEnable = false;
    private ArrayList<AccessType> accessType = new ArrayList();
    private ArrayList<Integer> studiosIds = new ArrayList();
    private ArrayList<Integer> allowedUsersIds = new ArrayList();

    public boolean isCanComment() {
        return canComment;
    }

    public void setCanComment(boolean canComment) {
        this.canComment = canComment;
    }

    public boolean isCanSetRating() {
        return canSetRating;
    }

    public void setCanSetRating(boolean canSetRating) {
        this.canSetRating = canSetRating;
    }

    public boolean isCanViewRating() {
        return canViewRating;
    }

    public void setCanViewRating(boolean canViewRating) {
        this.canViewRating = canViewRating;
    }

    public Date getAutoShowRatingDate() {
        return autoShowRatingDate;
    }

    public void setAutoShowRatingDate(Date autoShowRatingDate) {
        this.autoShowRatingDate = autoShowRatingDate;
    }

    public boolean isAccessRuleEnable() {
        return accessRuleEnable;
    }

    public void setAccessRuleEnable(boolean accessRuleEnable) {
        this.accessRuleEnable = accessRuleEnable;
    }

    public ArrayList<AccessType> getAccessType() {
        return accessType;
    }

    public void setAccessType(ArrayList<AccessType> accessType) {
        this.accessType = accessType;
    }

    public ArrayList<Integer> getStudiosIds() {
        return studiosIds;
    }

    public void setStudiosIds(ArrayList<Integer> studiosIds) {
        this.studiosIds = studiosIds;
    }

    public ArrayList<Integer> getAllowedUsersIds() {
        return allowedUsersIds;
    }

    public void setAllowedUsersIds(ArrayList<Integer> allowedUsersIds) {
        this.allowedUsersIds = allowedUsersIds;
    }

    
}
