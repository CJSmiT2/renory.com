/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.alhoritm;

import java.util.Base64;

/**
 *
 * @author smit
 */
public class Base64Util {
    public static String encodeBase64String(byte[] bytes){
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        return new String(encodedBytes);
    }
    
    public static byte[] decodeBase64(String str){
        return Base64.getDecoder().decode(str.getBytes());
    }
}
