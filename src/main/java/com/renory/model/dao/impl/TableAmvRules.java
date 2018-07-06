/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author smit
 */
class TableAmvRules {
    
    private static final String TABLE = "amv_rules";
    private final SQL sql = new SQL();

    void write(int amvId, String rules) {
        
        String query = "INSERT INTO `" + TABLE + "` (`amvId`,`rules`) VALUES (?,?)";
        
        try {

            PreparedStatement ps = sql.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, amvId);
            ps.setString(2, rules);
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            ps.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR to save to db!!! " + rules + " exception: " + ex);
        } finally {
            try {
                sql.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    String getByAmvId(int amvId) {
        String rules = null;
        
        Connection connect = null;
        Statement statement = null;
        
        String query = "SELECT * FROM " + TABLE + " WHERE `amvId`='" + amvId + "' ORDER BY id DESC limit 1";
        
        try {
            connect = sql.getConnection();
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                rules = rs.getString("rules");
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
        
        if (rules!=null){
            return rules;
        } else {
            throw new RuntimeException("rules cannot be null!!! query: " + query);
        }
    }

    void update(int amvId, String rules) {
        Connection connect = null;
        PreparedStatement ps = null;
        try {
            String query = "UPDATE  `" + TABLE + "` SET "
                    + "`rules`=? WHERE `amvId`=? ORDER by `id` DESC LIMIT 1";
            
            connect = sql.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, rules);
            ps.setInt(2, amvId);
            
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

    void delete(int amvId) {
        try {
            Connection connect = sql.getConnection();
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `" + TABLE + "` WHERE `amvId`='" + amvId + "' ORDER BY `id` DESC LIMIT 1");
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void clearDb() {
        try {
            Connection connect = sql.getConnection();
            Statement statement = connect.createStatement();
            statement.executeUpdate("TRUNCATE TABLE " + TABLE);
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TableAmv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
