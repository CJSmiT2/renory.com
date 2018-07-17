/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;

import java.util.regex.Pattern;
import com.renory.secure.dto.RegInfoDto;

/**
 *
 * @author smit
 */
class ValidUserData {
    
    private final int maxLoginLength = 20;
    private final int minLoginLength = 3;
    
    private final int maxNickNameLength = 20;
    private final int minNickNameLength = 3;
    
    private final int maxPasswordLength = 30;
    private final int minPasswordLength = 8;
    

    
    public boolean thePasswordIsValid(String password){
        if (password==null)  {
//            log.info("password is null");
            return false;
        }
        if (password.length()==0) {
//            log.info("password is empty");
            return false;
        }
        if (password.length()>maxPasswordLength) {
//            log.info("password to long");
            return false;
        }
        if (password.length()<minPasswordLength) {
//            log.info("password is short. length=" + password.length());
            return false;
        }
        return true;
    }
    
    public boolean theRegInfoIsValid(RegInfoDto info) {
        String login = info.getLogin();
        String password = info.getPassword();
        String nickName = info.getNickName();
        
        if (login==null) {
//            log.info("login = null");
            return false;
        }
        if (password==null)  {
//            log.info("password = null");
            return false;
        }     
        
        if (login.length()==0) {
//            log.info("empty login");
            return false;
        }
        if (login.length()>maxLoginLength) {
//            log.info("login to long. login.length()=" + login.length());
            return false;
        }
        if (login.length()<minLoginLength) {
//            log.info("login to short. login.length()=" + login.length());
            return false;
        }
        
        if (password.length()==0) {
//            log.info("empty password");
            return false;
        }
        if (password.length()>maxPasswordLength) {
//            log.info("password to long. password.length()=" + password.length());
            return false;
        }
        if (password.length()<minPasswordLength) {
//            log.info("password to short. password.length()=" + password.length());
            return false;
        }
        
        if (nickName.length()==0) {
//            log.info("empty nickName");
            return false;
        }
        if (nickName.length()>maxNickNameLength) {
//            log.info("nickName to long. password.length()=" + nickName.length());
            return false;
        }
        if (nickName.length()<minNickNameLength) {
//            log.info("nickName to short. password.length()=" + nickName.length());
            return false;
        }
        
        if (!stringValid(login)) {
//            log.info("Login have bad symbols! " + login);
            return false;
        }
        if (!stringValidWithCapse(nickName)) {
//            log.info("nickName have bad symbols! " + nickName);
            return false;
        }

        return true;
    }
    
    private boolean stringValid(String str){
        Pattern pattern = Pattern.compile("^[а-яА-ЯёЁa-zA-Z0-9_]+$");
        boolean valid = (str != null) && pattern.matcher(str).matches();
        return valid;
    }
    
    private boolean stringValidWithCapse(String str){
        Pattern pattern = Pattern.compile("^[а-яА-ЯёЁa-zA-Z0-9 _]+$");
        boolean valid = (str != null) && pattern.matcher(str).matches();
        return valid;
    }
    
}
