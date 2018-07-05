/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renory.model.entity.amv.Evaluating;
import com.renory.model.entity.amv.UrlFromUser;
import java.io.IOException;

/**
 *
 * @author smit
 */
class ConverterJsonUtil {
    
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static String toStringEvaluating(Evaluating evaluating) {
        try {
            return MAPPER.writeValueAsString(evaluating);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    static String toStringUrls(UrlFromUser urls) {
        try {
            return MAPPER.writeValueAsString(urls);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        }
    }

    static Evaluating toEntityEvaluating(String evaluating) {
        try {
            return MAPPER.readValue(evaluating, Evaluating.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static UrlFromUser toEntityUrls(String urls) {
        try {
            return MAPPER.readValue(urls, UrlFromUser.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
