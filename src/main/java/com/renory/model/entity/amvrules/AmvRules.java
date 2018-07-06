/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amvrules;

/**
 *
 * @author smit
 */
public class AmvRules {
    private final boolean canComment;
    private final boolean canSetRating;
    private final boolean canViewRating;

    public AmvRules(boolean canComment, boolean canSetRating, boolean canViewRating) {
        this.canComment = canComment;
        this.canSetRating = canSetRating;
        this.canViewRating = canViewRating;
    }

    public boolean isCanComment() {
        return canComment;
    }

    public boolean isCanSetRating() {
        return canSetRating;
    }

    public boolean isCanViewRating() {
        return canViewRating;
    }
    
    
}
