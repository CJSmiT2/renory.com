/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.entity.amv.videoclip;

import java.io.File;

/**
 *
 * @author smit
 */
public class VideoClip {
    
    private int id;
    private File videoFile;
    private VideoQuality quality;
    private Resolution resolution;
    private int fps;
    private int bitrate;
    private VideoFormat format;
    private long fileSize;
    private int hash;
    
}
