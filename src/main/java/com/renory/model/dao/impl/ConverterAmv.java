/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import com.renory.config.GeneralConfig;
import com.renory.model.dao.dto.AmvDto;
import com.renory.model.entity.amv.Amv;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author smit
 */
class ConverterAmv {
    
    public static AmvDto toDto(Amv entity){
        AmvDto dto = new AmvDto();
        dto.setId(entity.getId());
        dto.setAlias(entity.getAlias());
        dto.setFolderNameOnDisk(entity.getFolderOnDisk().getName());
        dto.setUploaderUserId(entity.getUploaderUserId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setStudioId(entity.getStudioId());
        dto.setDateCreated(entity.getDateCreated());
        dto.setTimeUploaded(entity.getTimeUploaded());
        dto.setHitsOfPage(entity.getHitsOfPage());
        dto.setHitsOfOnlineView(entity.getHitsOfOnlineView());
        dto.setDownloadsCount(entity.getDownloadsCount());
        dto.setAuthors(ConverterIdsUtil.toString(entity.getAuthors()));
        dto.setAnimeSrc(ConverterIdsUtil.toString(entity.getAnimeSrc()));
        dto.setMusicSrc(ConverterIdsUtil.toString(entity.getMusicSrc()));
        dto.setCategories(ConverterIdsUtil.toString(entity.getCategories()));
        dto.setVideos(ConverterIdsUtil.toString(entity.getVideos()));
        dto.setUrls(ConverterJsonUtil.toStringUrls(entity.getUrls()));
        dto.setIsPublic(entity.isIsPublic());
        return dto;
    }
    
    public static Amv toEntity(AmvDto dto){
        Amv entity = new Amv();
        entity.setId(dto.getId());
        entity.setAlias(dto.getAlias());
        entity.setFolderOnDisk(new File(GeneralConfig.AMV_FOLDER + dto.getFolderNameOnDisk()));
        entity.setUploaderUserId(dto.getUploaderUserId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setStudioId(dto.getStudioId());
        entity.setDateCreated(dto.getDateCreated());
        entity.setTimeUploaded(dto.getTimeUploaded());
        entity.setHitsOfPage(dto.getHitsOfPage());
        entity.setHitsOfOnlineView(dto.getHitsOfOnlineView());
        entity.setDownloadsCount(dto.getDownloadsCount());
        entity.setAuthors(ConverterIdsUtil.toInt(dto.getAuthors()));
        entity.setAnimeSrc(ConverterIdsUtil.toInt(dto.getAnimeSrc()));
        entity.setMusicSrc(ConverterIdsUtil.toInt(dto.getMusicSrc()));
        entity.setCategories(ConverterIdsUtil.toInt(dto.getCategories()));
        entity.setVideos(ConverterIdsUtil.toInt(dto.getVideos()));
        entity.setUrls(ConverterJsonUtil.toEntityUrls(dto.getUrls()));
        entity.setIsPublic(dto.isIsPublic());
        return entity;
    }
    
    public static ArrayList<Amv> toEntityArray(ArrayList<AmvDto> dtos){
        ArrayList<Amv> entityes = new ArrayList();
        for (AmvDto dto : dtos){
            entityes.add(ConverterAmv.toEntity(dto));
        }
        return entityes;
    }
    
    public static ArrayList<AmvDto> toDtoArray(ArrayList<Amv> entityes){
        ArrayList<AmvDto> dtos = new ArrayList();
        for (Amv entity : entityes){
            dtos.add(ConverterAmv.toDto(entity));
        }
        return dtos;
    }
}
