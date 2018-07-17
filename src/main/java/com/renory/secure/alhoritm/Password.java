/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.alhoritm;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
public class Password {
    
    private static final int saltLen = 32;

    public static String getSaltedHash(String password) {
        try {
            byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
            return Base64Util.encodeBase64String(salt) + "$" + Alhoritm.hashSHA256(password, salt);
        } catch (Exception ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new RuntimeException("error to hash password! " + password);
    }

    public static boolean check(String password, String stored){
        try {
            String[] saltAndPass = stored.split("\\$");
            if (saltAndPass.length != 2) {
                throw new IllegalStateException(
                        "The stored password have the form 'salt$hash'");
            }
            String hashOfInput = Alhoritm.hashSHA256(password, Base64Util.decodeBase64(saltAndPass[0]));
            
            String expectedHash = saltAndPass[1];
            
            return hashOfInput.equals(expectedHash);
        } catch (Exception ex) {
            Logger.getLogger(Password.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
