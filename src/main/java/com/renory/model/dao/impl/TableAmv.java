/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import com.renory.model.dao.dto.AmvDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
class TableAmv {
    
    private static final String TABLE = "amv";
    private final SQL sql = new SQL();

    int write(AmvDto amv) {
        int id = 0;
        
        String columns = "`alias`,"
                + "`uploaderUserId`,"
                + "`title`,"
                + "`description`,"
                + "`studioId`,"
                + "`dateCreated`,"
                + "`timeUploaded`,"
                + "`hitsOfPage`,"
                + "`hitsOfOnlineView`,"
                + "`downloadsCount`,"
                + "`authors`,"
                + "`animeSrc`,"
                + "`musicSrc`,"
                + "`categories`,"
                + "`videos`,"
                + "`evaluating`,"
                + "`urls`,"
                + "`isComplete`";
        
        String query = "INSERT INTO `" + TABLE + "`(" + columns + ") "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement ps = sql.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, amv.getAlias());
            ps.setInt(2, amv.getUploaderUserId());
            ps.setString(3, amv.getTitle());
            ps.setString(4, amv.getDescription());
            ps.setInt(5, amv.getStudioId());
            ps.setDate(6, amv.getDateCreated());
            ps.setTimestamp(7, amv.getTimeUploaded());
            ps.setInt(8, amv.getHitsOfPage());
            ps.setInt(9, amv.getHitsOfOnlineView());
            ps.setInt(10, amv.getDownloadsCount());
            ps.setString(11, amv.getAuthors());
            ps.setString(12, amv.getAnimeSrc());
            ps.setString(13, amv.getMusicSrc());
            ps.setString(14, amv.getCategories());
            ps.setString(15, amv.getVideos());
            ps.setString(16, amv.getEvaluating());
            ps.setString(17, amv.getUrls());
            ps.setBoolean(18, amv.isIsComplete());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
              id = rs.getInt(1);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR to save to db!!! " + amv + " exception: " + ex);
        } finally {
            try {
                sql.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    }

    AmvDto get(int id) {
        AmvDto amv = null;
        
        Connection connect = null;
        Statement statement = null;
        
        String query = "SELECT * FROM " + TABLE + " WHERE `id`='" + id + "' ORDER BY id DESC limit 1";
        
        try {
            connect = sql.getConnection();
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                amv = resultToDto(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (amv!=null){
            return amv;
        } else {
            throw new RuntimeException("Amv cannot be null!!! query: " + query);
        }
    }

    AmvDto get(String alias) {
        AmvDto amv = null;
        
        Connection connect = null;
        PreparedStatement ps = null;
        
        String query = "SELECT * FROM `" + TABLE + "` WHERE `alias`=? ORDER BY id DESC limit 1";
        
        try {
            connect = sql.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, alias);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                amv = resultToDto(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (amv!=null){
            return amv;
        } else {
            throw new RuntimeException("Amv cannot be null!!! query: " + query);
        }
    }

    void update(AmvDto amv) {
        Connection connect = null;
        PreparedStatement ps = null;
        try {
            String query = "UPDATE  `" + TABLE + "` SET "
                    + "`alias`=?,"
                    + "`uploaderUserId`=?,"
                    + "`title`=?,"
                    + "`description`=?,"
                    + "`studioId`=?,"
                    + "`dateCreated`=?,"
                    + "`timeUploaded`=?,"
                    + "`hitsOfPage`=?,"
                    + "`hitsOfOnlineView`=?,"
                    + "`downloadsCount`=?,"
                    + "`authors`=?,"
                    + "`animeSrc`=?,"
                    + "`musicSrc`=?,"
                    + "`categories`=?,"
                    + "`videos`=?,"
                    + "`evaluating`=?,"
                    + "`urls`=?,"
                    + "`isComplete`=? "
                    + "WHERE `id`=? ORDER by `id` DESC LIMIT 1";
            
            connect = sql.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, amv.getAlias());
            ps.setInt(2, amv.getUploaderUserId());
            ps.setString(3, amv.getTitle());
            ps.setString(4, amv.getDescription());
            ps.setInt(5, amv.getStudioId());
            ps.setDate(6, amv.getDateCreated());
            ps.setTimestamp(7, amv.getTimeUploaded());
            ps.setInt(8, amv.getHitsOfPage());
            ps.setInt(9, amv.getHitsOfOnlineView());
            ps.setInt(10, amv.getDownloadsCount());
            ps.setString(11, amv.getAuthors());
            ps.setString(12, amv.getAnimeSrc());
            ps.setString(13, amv.getMusicSrc());
            ps.setString(14, amv.getCategories());
            ps.setString(15, amv.getVideos());
            ps.setString(16, amv.getEvaluating());
            ps.setString(17, amv.getUrls());
            ps.setBoolean(18, amv.isIsComplete());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    void delete(int id) {
        try {
            Connection connect = sql.getConnection();
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `" + TABLE + "` WHERE `id`='" + id + "' ORDER BY `id` DESC LIMIT 1");
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ArrayList<AmvDto> getAll() {
        ArrayList<AmvDto> amvs = new ArrayList();
        
        Connection connect = null;
        Statement statement = null;
        
        String query = "SELECT * FROM " + TABLE;
        
        try {
            connect = sql.getConnection();
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                amvs.add(resultToDto(rs));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return amvs;
    }

    private AmvDto resultToDto(ResultSet rs) {
        try {
            AmvDto amv = new AmvDto();
            amv.setId(rs.getInt("id"));
            amv.setAlias(rs.getString("alias"));
            amv.setId(rs.getInt("uploaderUserId"));
            amv.setTitle(rs.getString("title"));
            amv.setDescription(rs.getString("description"));
            amv.setStudioId(rs.getInt("studioId"));
            amv.setDateCreated(rs.getDate("dateCreated"));
            amv.setTimeUploaded(rs.getTimestamp("timeUploaded"));
            amv.setHitsOfPage(rs.getInt("hitsOfPage"));
            amv.setHitsOfOnlineView(rs.getInt("hitsOfOnlineView"));
            amv.setDownloadsCount(rs.getInt("downloadsCount"));
            amv.setAuthors(rs.getString("authors"));
            amv.setAnimeSrc(rs.getString("animeSrc"));
            amv.setMusicSrc(rs.getString("musicSrc"));
            amv.setCategories(rs.getString("categories"));
            amv.setVideos(rs.getString("videos"));
            amv.setEvaluating(rs.getString("evaluating"));
            amv.setUrls(rs.getString("urls"));
            amv.setIsComplete(rs.getBoolean("isComplete"));
            return amv;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    
}
