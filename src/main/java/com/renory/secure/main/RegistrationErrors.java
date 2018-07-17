/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;

/**
 *
 * @author smit
 */
public class RegistrationErrors {
    private String loginErr;
    private String nickNameErr;
    private String passwordErr;
    private String emailErr;

    public String getLoginErr() {
        return loginErr;
    }

    public void setLoginErr(String loginErr) {
        this.loginErr = loginErr;
    }

    public String getNickNameErr() {
        return nickNameErr;
    }

    public void setNickNameErr(String nickNameErr) {
        this.nickNameErr = nickNameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getEmailErr() {
        return emailErr;
    }

    public void setEmailErr(String emailErr) {
        this.emailErr = emailErr;
    }
    
    public boolean haveErrors(){
        return loginErr!=null || nickNameErr!=null || passwordErr!=null || emailErr!=null;
    }
}
