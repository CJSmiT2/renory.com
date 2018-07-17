/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.dao.dto.UserDaoDto;

/**
 *
 * @author smit
 */
public class DaoLayer {
    
    private final SQL sql;
    private final String table = "auth_user";
    
    public DaoLayer(String login, String password, String host, String base, int port){
        this.sql = new SQL(login, password, host, base, port);
    }

    public DaoLayer(SqlSettings settings) {
        this.sql = new SQL(settings.login, settings.password, settings.host, settings.base, settings.port);
    }
    
    public UserDaoDto getUser(int id){
        UserDaoDto user = null;
        
        Connection connect = null;
        Statement statement = null;
        
        String query = "SELECT * FROM " + table + " WHERE `id`='" + id + "' ORDER BY id DESC limit 1";
        
        try {
            connect = sql.getConnection();
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                user = resultToDto(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (user!=null){
            return user;
        } else {
            throw new RuntimeException("FAIL sql query!!! " + query);
        }
        
    }
    
    public ArrayList<UserDaoDto> getAllUsers(){
        ArrayList<UserDaoDto> users = new ArrayList();
        
        Connection connect = null;
        Statement statement = null;
        
        String query = "SELECT * FROM " + table;
        
        try {
            connect = sql.getConnection();
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            while (rs.next()) {
                users.add(resultToDto(rs));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return users;
    }
    
    public int write(UserDaoDto user){
        int id = 0;
        
        String columns = "`login`,"
                + "`nickName`,"
                + "`password`,"
                + "`sessionId`,"
                + "`type`,"
                + "`status`,"
                + "`email`,"
                + "`timeOfRegistration`,"
                + "`timeOfLastLogin`,"
                + "`lastIpsLogined`,"
                + "`groups`";
        
        String query = "INSERT INTO `" + table + "`(" + columns + ") "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        
        try {

            PreparedStatement ps = sql.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getNickName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getSessionId());
            ps.setString(5, user.getType());
            ps.setString(6, user.getStatus());
            ps.setString(7, user.getEmail());
            ps.setTimestamp(8, user.getTimeOfRegistration());
            ps.setTimestamp(9, user.getTimeOfLastLogin());
            ps.setString(10, user.getLastIpsLogined());
            ps.setString(11, user.getGroups());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
              id = rs.getInt(1);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            throw new RuntimeException("ERROR to save to db!!! " + user + " exception: " + ex);
        } finally {
            try {
                sql.getConnection().close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return id;
    }
    
    public void update(UserDaoDto user){
        Connection connect = null;
        PreparedStatement ps = null;
        try {
            String query = "UPDATE  `" + table + "` SET "
                    + "`login`=?,"
                    + "`nickName`=?,"
                    + "`password`=?, "
                    + "`sessionId`=?, "
                    + "`type`=?, "
                    + "`status`=?, "
                    + "`email`=?, "
                    + "`timeOfRegistration`=?, "
                    + "`timeOfLastLogin`=?,"
                    + "`lastIpsLogined`=?,"
                    + "`groups`=? "
                    + "WHERE `id`=? ORDER by `id` DESC LIMIT 1";
            
            connect = sql.getConnection();
            ps = connect.prepareStatement(query);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getNickName());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getSessionId());
            ps.setString(5, user.getType());
            ps.setString(6, user.getStatus());
            ps.setString(7, user.getEmail());
            ps.setTimestamp(8, user.getTimeOfRegistration());
            ps.setTimestamp(9, user.getTimeOfLastLogin());
            ps.setString(10, user.getLastIpsLogined());
            ps.setString(11, user.getGroups());
            ps.setInt(12, user.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connect.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void delete(UserDaoDto user){
        try {
            Connection connect = sql.getConnection();
            Statement statement = connect.createStatement();
            statement.executeUpdate("DELETE FROM `" + table + "` WHERE `id`='" + user.getId() + "' ORDER BY `id` DESC LIMIT 1;");
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private UserDaoDto resultToDto(ResultSet rs){
        try {
            UserDaoDto user = new UserDaoDto();
            user.setId(rs.getInt("id"));
            user.setLogin(rs.getString("login"));
            user.setNickName(rs.getString("nickName"));
            user.setPassword(rs.getString("password"));
            user.setSessionId(rs.getString("sessionId"));
            user.setType(rs.getString("type"));
            user.setStatus(rs.getString("status"));
            user.setEmail(rs.getString("email"));
            user.setTimeOfRegistration(rs.getTimestamp("timeOfRegistration"));
            user.setTimeOfLastLogin(rs.getTimestamp("timeOfLastLogin"));
            user.setLastIpsLogined(rs.getString("lastIpsLogined"));
            user.setGroups(rs.getString("groups"));
            return user;
        } catch (SQLException ex) {
            throw new RuntimeException("Err to convert resultSet to dto! " + ex);
        }
    }

    public void clearDB() {
        try {
            Connection connect = sql.getConnection();
            Statement statement = connect.createStatement();
            statement.executeUpdate("TRUNCATE TABLE " + table);
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DaoLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
