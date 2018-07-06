/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amv;

import com.renory.model.entity.amv.Amv;
import com.renory.model.entity.amv.UrlFromUser;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author smit
 */
public class AmvContentCreater {
    
    private final static Random RANDOM = new Random();
    
    static Amv getAmv(){
        Amv amv = new Amv();
        amv.setAlias("alias-" + getRandomString());
        amv.setUploaderUserId(getRandomInt());
        amv.setTitle("title-" +getRandomString());
        amv.setDescription("description-" +getRandomString());
        amv.setStudioId(getRandomInt());
        amv.setDateCreated(getRandomDate());
        amv.setTimeUploaded(getCurrentTimestamp());
        amv.setHitsOfPage(getRandomInt());
        amv.setHitsOfOnlineView(getRandomInt());
        amv.setDownloadsCount(getRandomInt());
        amv.setAuthors(getRandomArray());
        amv.setAnimeSrc(getRandomArray());
        amv.setMusicSrc(getRandomArray());
        amv.setCategories(getRandomArray());
        amv.setVideos(getRandomArray());
        amv.setUrls(getRandomUrls());
        amv.setIsComplete(true);
        return amv;
    }
    
    private static String getRandomString(){
        return String.valueOf(System.currentTimeMillis() + RANDOM.nextInt());
    }
    
    private static int getRandomInt(){
        return RANDOM.nextInt();
    }
    
    private static Date getRandomDate(){
        Date date = new Date(RANDOM.nextInt(2017) + 1, RANDOM.nextInt(11) + 1, RANDOM.nextInt(27) + 1);  
        return date;
    }
    
    private static Timestamp getCurrentTimestamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    private static ArrayList<Integer> getRandomArray() {
        ArrayList<Integer> array = new ArrayList();
        for(int i=0;i<RANDOM.nextInt(100);i++){
            array.add(RANDOM.nextInt());
        }
        return array;
    }

    private static UrlFromUser getRandomUrls() {
        UrlFromUser urls = new UrlFromUser();
        for (int i=0; i<RANDOM.nextInt(10); i++){
            urls.addUrl("url-" + getRandomString());
        }
        return urls;
    }

}
