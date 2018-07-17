/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.dto;

/**
 *
 * @author smit
 */
public class ChangePassInfoDto {
    private String oldPassword;
    private String newPassword1;
    private String newPassword2;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword1() {
        return newPassword1;
    }

    public void setNewPassword1(String newPassword1) {
        this.newPassword1 = newPassword1;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }

    @Override
    public String toString() {
        return "ChangePassInfoDto{" + "oldPassword=" + oldPassword + ", newPassword1=" + newPassword1 + ", newPassword2=" + newPassword2 + '}';
    }

    public boolean isEmpty() {
        return oldPassword==null && newPassword1==null && newPassword2==null;
    }
}
