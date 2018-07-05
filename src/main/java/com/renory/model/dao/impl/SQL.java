/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;



import com.renory.config.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author smit
 */
class SQL {
    private final String login;
    private final String password;
    private final String host;
    private final String base;
    private final int port;

    public SQL() {
        this.login = Config.DB_LOGIN;
        this.password = Config.DB_PASSWORD;
        this.host = Config.DB_HOST;
        this.base = Config.DB_BASE;
        this.port = Config.DB_PORT;
    }
    
    
    public Connection getConnection(){
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Properties properties = new Properties();
            properties.setProperty("user", login);
            properties.setProperty("password", password);
            properties.setProperty("useUnicode","true");
            properties.setProperty("characterEncoding","UTF-8");
            
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://" + host +":" + port + "/" + base ,properties);
            
            return connection;
            
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("SQL connection init fail!");
        }
    }   

    @Override
    public String toString() {
        return "SQL{" + "login=" + login + ", password=" + password + ", host=" + host + ", base=" + base + ", port=" + port + '}';
    }
    
    

}
