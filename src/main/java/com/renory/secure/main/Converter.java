/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;

import java.sql.Timestamp;
import java.util.ArrayList;
import com.renory.secure.dao.dto.UserDaoDto;
import com.renory.secure.user.UserSecure;
import com.renory.secure.user.UserStatus;
import com.renory.secure.user.UserType;

/**
 *
 * @author smit
 */
class Converter {

    ArrayList<UserSecure> toEntityArray(ArrayList<UserDaoDto> dtos) {
        ArrayList<UserSecure> entityes = new ArrayList();
        for (UserDaoDto dto:dtos){
            entityes.add(toEntity(dto));
        }
        return entityes;
    }
    
    UserSecure toEntity(UserDaoDto dto){
        UserSecure entity = new UserSecure();
        
        entity.setId(dto.getId());
        entity.setLogin(dto.getLogin());
        entity.setNickName(dto.getNickName());
        entity.setPassword(dto.getPassword());
        entity.setSessionId(dto.getSessionId());
        entity.setType(UserType.valueOf(dto.getType().toUpperCase()));
        entity.setStatus(UserStatus.valueOf(dto.getStatus()));
        entity.setEmail(dto.getEmail());
        entity.setTimeOfRegistration(dto.getTimeOfRegistration().getTime());
        entity.setTimeOfLastLogin(dto.getTimeOfLastLogin().getTime());
        entity.setLastIpsLogined(converByComma(dto.getLastIpsLogined()));
        entity.setGroups(converByComma(dto.getGroups()));
         
        return entity;
    }
    
    ArrayList<UserDaoDto> toDtoArray(ArrayList<UserSecure> entityes){
        ArrayList<UserDaoDto> dtos = new ArrayList();
        
        for (UserSecure entity:entityes){
            dtos.add(toDto(entity));
        }
        
        return dtos;
    }

    UserDaoDto toDto(UserSecure entity) {
        UserDaoDto dto = new UserDaoDto();
        
        dto.setId(entity.getId());
        dto.setLogin(entity.getLogin());
        dto.setNickName(entity.getNickName());
        dto.setPassword(entity.getPassword());
        dto.setSessionId(entity.getSessionId());
        dto.setType(entity.getType().toString().toUpperCase());
        dto.setStatus(entity.getStatus().toString().toUpperCase());
        dto.setEmail(entity.getEmail());
        dto.setTimeOfRegistration(new Timestamp(entity.getTimeOfRegistration()));
        dto.setTimeOfLastLogin(new Timestamp(entity.getTimeOfLastLogin()));
        dto.setLastIpsLogined(arrayToLine(entity.getLastIpsLogined()));
        dto.setGroups(arrayToLine(entity.getGroups()));
        
        return dto;
    }

    public ArrayList<String> converByComma(String textWithCommas) {
        ArrayList<String> lines = new ArrayList();
        
        if (textWithCommas==null || textWithCommas.isEmpty()) return lines;
        
        textWithCommas = textWithCommas.trim().toUpperCase();
        
        if (!textWithCommas.contains(",")) {
            lines.add(textWithCommas);
        } else {
            String[] splited = textWithCommas.split(",");
            for (int i=0;i <splited.length; i++){
                if (splited[i].length()>2){
                    lines.add(splited[i]);
                } else {
                    // ignore
                }
            }
        }
        
        return lines;
    }
    
    public String arrayToLine(ArrayList<String> array){
        String line = "";
        
        for (String one:array){
            line += one + ",";
        }
        
        if (line.length()>2){
            line = line.substring(0, line.length()-1);
        }
        
        line = line.toUpperCase();
        
        return line;
    }
    
}
