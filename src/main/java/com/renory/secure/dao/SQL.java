/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.dao;



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

    public SQL(String login, String password, String host, String base, int port) {
        
        if (login==null || login.isEmpty()) throw new RuntimeException("Empty login!");
        if (password==null || password.isEmpty()) throw new RuntimeException("Empty password!");
        if (host==null || host.isEmpty()) throw new RuntimeException("Empty host!");
        if (base==null || login.isEmpty()) throw new RuntimeException("Empty base!");
        if (port<=0) throw new RuntimeException("Wrong port!");
        
        this.login = login;
        this.password = password;
        this.host = host;
        this.base = base;
        this.port = port;
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
