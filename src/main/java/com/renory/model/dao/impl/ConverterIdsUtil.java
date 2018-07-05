/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import java.util.ArrayList;
/**
 *
 * @author smit
 */
class ConverterIdsUtil {
    
    public static ArrayList<Integer> toInt(String integers){
        ArrayList<Integer> ints = new ArrayList<Integer>();
        if (integers==null || integers.isEmpty()) {
            return ints;
        }
        
        try{
            if (integers.contains(",")){
                String[] numArr = integers.split(",");
                for (int i=0;i<numArr.length;i++){
                    int num = Integer.valueOf(numArr[i]);
                    ints.add(num);
                }
            } else {
                int num = Integer.valueOf(integers);
                ints.add(num);
            }
        } catch (NumberFormatException ex){
            throw new RuntimeException(ex);
        }
        
        return ints;
    }
    
    public static String toString(ArrayList<Integer> ids){
        String str = "";
        for (Integer id:ids){
            str += id + ",";
        }
        
        if (str.length()>1) str = str.substring(0, str.length()-1);
        
        return str;
    }
}
